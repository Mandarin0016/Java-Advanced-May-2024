package _05_Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            // ВАЛИДЕН
            if (!url.matches(".*[0-9].*")) {
                sb.append("Browsing: ").append(url).append("!");
            }
            // НЕВАЛИДЕН
            else {
                sb.append("Invalid URL!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            // ВАЛИДЕН
            if (number.matches("[0-9]+")) {
                sb.append("Calling... ").append(number);
            }
            // НЕВАЛИДЕН
            else {
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
