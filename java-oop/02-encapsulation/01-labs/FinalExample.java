public class FinalExample {

    private static class Cat {
        private final String name;

        public Cat(String name) {
            this.name = name;
        }

        // Compile time error assignment operation cannot be done on final field
        // outside of constructor
//        public void setName(String name) {
//            this.name = name;
//        }
    }

    // Compile time error cannot extend final class
//    private static class MyString extends String {
//
//    }

    private static class BaseClass {
        public final void printHello() {
            System.out.println("Hello");
        }
    }

    private static class ChildClass extends BaseClass {
        // Compile time error cannot override final method from base class
//        @Override
//        public void printHello() {
//            System.out.println("Hello");
//        }
    }

    public static void main(String[] args) {

    }
}
