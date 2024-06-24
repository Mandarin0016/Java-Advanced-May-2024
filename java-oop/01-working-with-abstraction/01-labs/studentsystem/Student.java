package studentsystem;

public record Student(String name, int age, double grade) {

    @Override
    public String toString() {
        return String.format("%s is %s years old. %s", name, age, getPostfix());
    }

    private String getPostfix() {
        String postfix = "Very nice person.";

        if (grade >= 5.00) {
            postfix = "Excellent student.";
        }
        else if (grade >= 3.50) {
            postfix = "Average student.";
        }

        return postfix;
    }
}

