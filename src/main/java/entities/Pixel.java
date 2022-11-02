package entities;

public class Pixel {
    private final int x;
    private final int y;
    private String color;

    public Pixel(int x, int y, String color){
        if(x <= 0){
            throw new IllegalArgumentException("x greater then 0");
        }
        if(y <= 0){
            throw new IllegalArgumentException("y greater then 0");
        }
        if(color == null){
            throw new IllegalArgumentException("a color must be specified");
        }

        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Pixel(Pixel pixel){
        this.x = pixel.x;
        this.y = pixel.y;
        this.color = pixel.color;
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

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Pixel pixel)){
            return false;
        }
        return pixel.getX() == this.getX() && pixel.getY() == this.getY();
    }
}
