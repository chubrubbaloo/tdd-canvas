package entities;

public class Pixel {
    private final int x;
    private final int y;
    private String color;

    public Pixel(int x, int y, String color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
