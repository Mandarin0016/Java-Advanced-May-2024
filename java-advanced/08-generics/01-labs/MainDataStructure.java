public class MainDataStructure {
    public static void main(String[] args) {

        CustomStack stack = new CustomStack();

        stack.push(13);
        stack.push(42);
        stack.push(69);
        stack.push(73);


        SmartArray<Integer> smartArray = new SmartArray<>();

        smartArray.add(13);
        smartArray.add(42);
        smartArray.add(69);

        SmartArray<String> stringSmartArray = new SmartArray<>();

        stringSmartArray.add("Pesho");
        stringSmartArray.add("Ivan");
        stringSmartArray.add("Georgi");
    }
}
