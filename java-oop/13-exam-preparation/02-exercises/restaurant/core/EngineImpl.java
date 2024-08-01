package restaurant.core;

import restaurant.common.Command;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class EngineImpl implements Engine {
    private final Controller controller;
    private final Scanner scanner;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.scanner.nextLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddWaiter:
                result = addWaiter(data);
                break;
            case AddClient:
                result = addClient(data);
                break;
            case RemoveWaiter:
                result = removeWaiter(data);
                break;
            case RemoveClient:
                result = removeClient(data);
                break;
            case TakeOrders:
                result = startWorking(data);
                break;
            case GetStatistics:
                result = getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }

        return result;
    }


    private String addWaiter(String[] data) {
        //TODO
        return null;
    }

    private String addClient(String[] data) {
        String clientName = data[0];
        String[] order = Arrays.stream(data).skip(1).toArray(String[]::new);
        return controller.addClient(clientName, order);
    }

    private String removeWaiter(String[] data) {
        //TODO
        return null;
    }

    private String removeClient(String[] data) {
        //TODO
        return null;
    }

    private String startWorking(String[] data) {
        //TODO
        return null;
    }

    private String getStatistics() {
        //TODO
        return null;
    }


}
