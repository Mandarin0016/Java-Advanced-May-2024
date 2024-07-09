package _03_Word;

public class CutTransform implements TextTransform {

    private String cut;

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {

        // Взимам частта, която ще премахвам
        String cutPart = text.substring(startIndex, endIndex);
        setCut(cutPart);
        // Премахвам тази част
        text.delete(startIndex, endIndex);
    }

    public String getCut() {
        return cut;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }
}
