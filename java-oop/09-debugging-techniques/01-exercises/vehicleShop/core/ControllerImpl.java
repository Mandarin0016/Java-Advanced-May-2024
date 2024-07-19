package vehicleShop.core;

import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.List;

import static vehicleShop.common.ConstantMessages.*;
import static vehicleShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private WorkerRepository workerRepository;
    private VehicleRepository vehicleRepository;
    private Shop shop;

    // НЕ СА МИ КАЗАЛИ НИЩО ЗА АРГУМЕНТИ НА КОНСТРУКТОРА!
    public ControllerImpl() {
        this.workerRepository = new WorkerRepository();
        this.vehicleRepository = new VehicleRepository();
        this.shop = new ShopImpl();
    }

    @Override
    public String addWorker(String type, String workerName) {

        Worker worker;
        if (type.equals("FirstShift")) {
            worker = new FirstShift(workerName);
        } else if (type.equals("SecondShift")) {
            worker = new SecondShift(workerName);
        } else {
            throw new IllegalArgumentException(WORKER_TYPE_DOESNT_EXIST);
        }

        workerRepository.add(worker);
        return String.format(ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {

        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);
        vehicleRepository.add(vehicle);
        return String.format(SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {

        Tool tool = new ToolImpl(power);
        Worker worker = workerRepository.findByName(workerName);
        if (worker == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        worker.getTools().add(tool);
        return String.format(SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {

        // 1. Намирам превозното средство по неговото име
        Vehicle vehicle = vehicleRepository.findByName(vehicleName);

        // 2. Намирам работниците, чиято сила е над 70
        List<Worker> workers = workerRepository.getWorkers().stream()
                .filter(worker -> worker.getStrength() > 70)
                .toList();

        // 3. Ако нямам работници - хвърлям грешка
        if (workers.isEmpty()) {
            throw new IllegalArgumentException(NO_WORKER_READY);
        }

        // 4. Всеки един работник да се опита да поправи превозното средство
        long countBrokenTools = 0;
        for (Worker worker : workers) {
            shop.make(vehicle, worker);
            countBrokenTools += worker.getTools().stream().filter(Tool::isUnfit).count();
        }

        //"Vehicle {vehicleName} is {done/not done}. {countBrokenTools} tool/s have been unfit while working on it!"
        String vehicleOutput;
        if (vehicle.reached()) {
            vehicleOutput = String.format(VEHICLE_DONE, vehicleName, "done");
        } else {
            vehicleOutput = String.format(VEHICLE_DONE, vehicleName, "not done");
        }
        String brokenToolsOutput = String.format(COUNT_BROKEN_INSTRUMENTS, countBrokenTools);

        return vehicleOutput + brokenToolsOutput;
    }

    @Override
    public String statistics() {

        StringBuilder sb = new StringBuilder();

        long countReadyVehicles = vehicleRepository.getWorkers().stream().filter(Vehicle::reached).count();
        String firstRowOutput = String.format("%d vehicles are ready!", countReadyVehicles);
        sb.append(firstRowOutput).append(System.lineSeparator());
        sb.append("Info for workers:").append(System.lineSeparator());

        for (Worker worker : workerRepository.getWorkers()) {
            String workerFirstRow = String.format("Name: %s, Strength: %d", worker.getName(), worker.getStrength());
            String workerSecondRow = String.format("Tools: %d fit left", worker.getTools().stream().filter(tool -> !tool.isUnfit()).count());
            sb.append(workerFirstRow).append(System.lineSeparator());
            sb.append(workerSecondRow).append(System.lineSeparator());
        }

        // Винаги като връщам StringBuilder като текст - слагаме .trim()
        return sb.toString().trim();
    }
}
