package repositories;

import entities.Pixel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MemoryPixelRepositoryTest {

    MemoryPixelRepository repository;
    Pixel pixel1;
    Pixel pixel2;
    Pixel pixel3;

    @BeforeEach
    void setup(){
        this.repository = new MemoryPixelRepository();

        pixel1 = mock(Pixel.class);
        when(pixel1.getX()).thenReturn(0);
        when(pixel1.getY()).thenReturn(0);
        when(pixel1.getColor()).thenReturn("blue");

        pixel2 = mock(Pixel.class);
        when(pixel2.getX()).thenReturn(0);
        when(pixel2.getY()).thenReturn(1);
        when(pixel2.getColor()).thenReturn("green");

        pixel3 = mock(Pixel.class);
        when(pixel3.getX()).thenReturn(1);
        when(pixel3.getY()).thenReturn(0);
        when(pixel3.getColor()).thenReturn("white");
    }

    @Test
    void testGetAllPixels(){

    }

    @Test
    void testUpdatePixel(){

    }

}