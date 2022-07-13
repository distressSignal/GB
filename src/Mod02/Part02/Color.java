package Mod02.Part02;

public enum Color {
    BLACK("черный"),
    WHITE("белый"),
    RED("красный"),
    GRAY("серый");

    private String russianColor;

    Color(String russianColor) {
        this.russianColor = russianColor;
    }

    public String getRussianColor() {
        return russianColor;
    }
    public String getEnglishColor() {
        return  name().toLowerCase();
    }


}
