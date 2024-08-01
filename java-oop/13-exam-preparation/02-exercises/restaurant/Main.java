package restaurant;


import restaurant.core.ControllerImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    private static final String METHOD_INCORRECT_RETURN_VALUE = "Method '%s.%s' returns invalid data (expected res: '%s'; actual - '%s')!";
    private static final String METHOD_INCORRECT_EXCEPTION_MESSAGE = "Method '%s.%s' throws invalid ex (expected: '%s - %s'; actual - '%s - %s')!";


    private Class controllerClass;
    private Object controller;

    public static void main(String[] args) {
        Main main = new Main();
        main.validateStartWorkingMethod();
    }

    public void beforeMethod() {
        Class controllerClass = getType("ControllerImpl");

        Object controller = createObjectInstance(controllerClass, new Object[]{});

        this.controllerClass = controllerClass;
        this.controller = controller;
    }

    public void validateStartWorkingMethod() {
        beforeMethod();
        getMethodValue(this.controller, this.controllerClass, "addWaiter", new Object[]{"FullTimeWaiter", "Zahari"}, String.class, String.class);
        getMethodValue(this.controller, this.controllerClass, "addWaiter", new Object[]{"HalfTimeWaiter", "Kiril"}, String.class, String.class);

        Object[] addClientArguments1 = new Object[]
                {"Genadi", new String[]{"order1", "order2", "order3", "order4", "order5", "order6"}};
        getMethodValue(this.controller, this.controllerClass, "addClient", addClientArguments1, String.class, String[].class);

        Object[] addClientArguments2 = new Object[]{"Stamat", new String[]{"order1", "order2"}};
        getMethodValue(this.controller, this.controllerClass, "addClient", addClientArguments2, String.class, String[].class);

        // Act
        String methodName = "startWorking";
        Object[] methodArgs = new Object[]{"Genadi"};

        String expectedMessage = String.format("Client %s was served.", methodArgs[0]);

        Class[] paramTypes = new Class[]{String.class};
        Object actualResult = getMethodValue(this.controller, this.controllerClass, methodName, methodArgs, paramTypes);
        String message = String.format(METHOD_INCORRECT_RETURN_VALUE, this.controller.getClass().getSimpleName(), methodName, expectedMessage, actualResult);

    }

    private Object getMethodValue(Object object, Class clazz, String methodName, Object[] methodArgs, Class... parameterTypes) {
        Method method = getMethod(clazz, methodName, parameterTypes);

        Object methodValue = null;
        if (method != null) {
            try {
                methodValue = method.invoke(object, methodArgs);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }

        return methodValue;
    }

    private Object createObjectInstance(Class clazz, Object[] arguments) {
        Class[] argumentTypes = null;

        if (arguments != null) {
            argumentTypes = Arrays.stream(arguments).map(Object::getClass).toArray(Class[]::new);
        }

        Constructor ctor = null;
        try {
            ctor = clazz.getDeclaredConstructor(argumentTypes);
        } catch (NoSuchMethodException e) {
            mapIntegerToInt(argumentTypes);

            try {
                ctor = clazz.getDeclaredConstructor(argumentTypes);
            } catch (NoSuchMethodException ex) {
                try {
                    argumentTypes = Arrays.stream(arguments).map(a -> a.getClass().getInterfaces()[0]).toArray(Class[]::new);
                    ctor = clazz.getDeclaredConstructor(argumentTypes);
                } catch (NoSuchMethodException exc) {
                }
            }
        }

        Object obj = null;

        if (ctor != null) {
            try {
                obj = ctor.newInstance(arguments);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }

        return obj;
    }

    private void mapIntegerToInt(Class[] types) {
        for (int i = 0; i < types.length; i++) {
            if (types[i].getSimpleName().equals(Integer.class.getSimpleName())) {
                types[i] = int.class;
            }
        }
    }

    private static Class getType(String name) {
        Class clazz = ControllerImpl.class;

        return clazz;
    }

    private Method getMethod(Class clazz, String expectedName, Class... parameterTypes) {
        Method method = null;

        try {
            method = clazz.getMethod(expectedName, parameterTypes);
        } catch (NoSuchMethodException e) {
        }

        return method;
    }
}