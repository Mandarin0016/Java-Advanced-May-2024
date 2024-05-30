import java.io.*;
import java.util.ArrayList;

public class SerializationDemo {

    private static class Cube implements Serializable {
        private int height;
        private int width;
        private int length;

        public Cube(int height, int width, int length) {
            this.height = height;
            this.width = width;
            this.length = length;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public int getLength() {
            return length;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Integer> serNumbers = new ArrayList<>();

        serNumbers.add(13);
        serNumbers.add(42);
        serNumbers.add(69);
        serNumbers.add(73);

        String listSerFile = "list-serialization-out.txt";
        ObjectOutputStream listOutputStream = new ObjectOutputStream(
                new FileOutputStream(listSerFile));
        listOutputStream.writeObject(serNumbers);

        ObjectInputStream listInputStream = new ObjectInputStream(new FileInputStream(listSerFile));
        ArrayList deSerNumbers = (ArrayList) listInputStream.readObject();

        System.out.println("Printing de serialized numbers: ");
        for (Object n : deSerNumbers) {
            System.out.println(n);
        }

        Cube serCube = new Cube(13, 42, 69);

        String cubeSerFile = "cube-serialization-out.txt";
        ObjectOutputStream cubeOutputStream = new ObjectOutputStream(
                new FileOutputStream(cubeSerFile));
        cubeOutputStream.writeObject(serCube);

        ObjectInputStream cubeInputStream = new ObjectInputStream(new FileInputStream(cubeSerFile));
        Cube deSerCube = (Cube) cubeInputStream.readObject();

        System.out.println("Printing de serialized cube: ");
        System.out.println(deSerCube.getHeight());
        System.out.println(deSerCube.getWidth());
        System.out.println(deSerCube.getLength());
    }
}
