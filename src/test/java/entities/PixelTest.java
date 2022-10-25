package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PixelTest {

    @Test
    void PixelCreatedCorrectly(){
        int x = 0;
        int y = 0;
        String color = "green";

        Pixel pixel = new Pixel(x, y, color);

        assertEquals(x, pixel.getX());
        assertEquals(y, pixel.getY());
        assertEquals(color, pixel.getColor());
    }

    @Test
    void PixelChangeColorCorrectly(){
        int x = 0;
        int y = 0;
        String color = "green";
        Pixel pixel = new Pixel(x, y, color);

        String newColor = "blue";
        pixel.setColor(newColor);
        assertEquals(newColor, pixel.getColor());
    }

    @Test
    void testingEquals(){
        int x = 0;
        int y = 0;
        String color1 = "green";
        String color2 = "blue";
        Pixel pixel1 = new Pixel(x, y, color1);
        Pixel pixel2 = new Pixel(x, y, color2);
        assertEquals(pixel1, pixel2);
    }

    @Test
    void testingNotEquals(){
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 1;
        String color = "green";
        Pixel pixel1 = new Pixel(x1, y1, color);
        Pixel pixel2 = new Pixel(x2, y2, color);
        assertNotEquals(pixel1, pixel2);
    }


}