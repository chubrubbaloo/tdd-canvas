package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PixelTest {

    @Test
    void PixelCreatedCorrectly(){
        int x = 1;
        int y = 2;
        String color = "green";

        Pixel pixel = new Pixel(x, y, color);

        assertEquals(x, pixel.getX());
        assertEquals(y, pixel.getY());
        assertEquals(color, pixel.getColor());
    }

    @Test
    void PixelConstructorThrowsWithBadArguments(){
        assertThrows(IllegalArgumentException.class, () -> new Pixel(0, 1, "blue"));
        assertThrows(IllegalArgumentException.class, () -> new Pixel(2, 0, "blue"));
        assertThrows(IllegalArgumentException.class, () -> new Pixel(1, 2, null));
    }

    @Test
    void PixelCopiedCorrectly(){
        int x = 1;
        int y = 2;
        String color = "green";

        Pixel pixel = new Pixel(x, y, color);
        Pixel pixelCopy = new Pixel(pixel);

        assertEquals(pixel.getX(), pixelCopy.getX());
        assertEquals(pixel.getY(), pixelCopy.getY());
        assertEquals(pixel.getColor(), pixelCopy.getColor());
    }

    @Test
    void PixelChangeColorCorrectly(){
        int x = 1;
        int y = 2;
        String color = "green";
        Pixel pixel = new Pixel(x, y, color);

        String newColor = "blue";
        pixel.setColor(newColor);
        assertEquals(newColor, pixel.getColor());
    }


    @Test
    void EqualsItself(){
        int x = 1;
        int y = 2;
        String color1 = "green";
        Pixel pixel1 = new Pixel(x, y, color1);
        assertEquals(pixel1, pixel1);
    }

    @Test
    void EqualsDifferentPixel(){
        int x = 1;
        int y = 2;
        String color1 = "green";
        String color2 = "blue";
        Pixel pixel1 = new Pixel(x, y, color1);
        Pixel pixel2 = new Pixel(x, y, color2);
        assertEquals(pixel1, pixel2);
    }

    @Test
    void NotEqualsDifferentPixel(){
        int x1 = 1;
        int y1 = 1;
        int x2 = 1;
        int y2 = 2;
        String color = "green";
        Pixel pixel1 = new Pixel(x1, y1, color);
        Pixel pixel2 = new Pixel(x2, y2, color);
        assertNotEquals(pixel1, pixel2);
    }


}