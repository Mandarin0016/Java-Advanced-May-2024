public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // 5, 4, 3, 2, 1
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        list.forEach(el -> System.out.print(el + ", "));
        int[] array = list.toArray();
    }
}
