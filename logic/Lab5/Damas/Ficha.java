public class Ficha {
    private String color; // "R" o "B"

    public Ficha(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color;
    }
}
