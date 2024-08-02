package createannotation;

public class Main {
    public static void main(String[] args) {

        Class<UsageDemo> clazz = UsageDemo.class;

        Subject annotation = clazz.getAnnotation(Subject.class);

        for (String category : annotation.categories()) {
            System.out.println(category);
        }

    }
}
