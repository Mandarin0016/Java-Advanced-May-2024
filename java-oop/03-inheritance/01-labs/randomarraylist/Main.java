package randomarraylist;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();

        for (int i = 0; i < 13; i++) {
            randomArrayList.add(i);
        }

        System.out.println(randomArrayList.getRandomElement());

    }
}
