public class DataStructuresMain {

    public static void main(String[] args) {
        SmartArray<Integer> smartArray = new SmartArray<>();
        smartArray.add(13);
        smartArray.add(42);
        smartArray.add(73);
        smartArray.add(69);

        for (int i = 0; i < smartArray.size(); i++) {
            int element = smartArray.get(i);
            System.out.println(element);
        }

        System.out.println("<============================>");

        for (int n : smartArray) {
            System.out.println(n);
        }

        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(13);
        stack.push(42);
        stack.push(69);
        stack.push(73);

        System.out.println("<============================>");

        for (int n : stack) {
            System.out.println(n);
        }
    }
}
