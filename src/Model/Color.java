package Model;

public enum Color {

    WHITE("\u001B[37m"),
    BLACK("\u001B[30m");

    private String colour;

    Color(String utf) {
        this.colour = utf;
    }

    public String getColour() {
        return colour;
    }
}
