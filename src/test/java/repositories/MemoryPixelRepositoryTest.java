package repositories;

import entities.Pixel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MemoryPixelRepositoryTest {

    MemoryPixelRepository repository;
    Pixel pixel1;
    Pixel pixel2;
    Pixel pixel3;
    Pixel pixel3blue;

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

        pixel3blue = mock(Pixel.class);
        when(pixel3blue.getX()).thenReturn(1);
        when(pixel3blue.getY()).thenReturn(0);
        when(pixel3blue.getColor()).thenReturn("blue");

        //when(pixel1.equals(pixel1)).thenReturn(true);

    }


    @Test
    void pixelReturnedAfterUpdate(){
        assertEquals(pixel1, repository.updatePixel(pixel1));
    }

    @Test
    void pixelCorrectColorAfterUpdate(){
        assertEquals(pixel1.getColor(), repository.updatePixel(pixel1).getColor());
    }

    @Test
    void pixelCorrectColorAfterUpdatingSameTwice(){
        assertEquals(pixel1.getColor(), repository.updatePixel(pixel1).getColor());
        assertEquals(pixel1.getColor(), repository.updatePixel(pixel1).getColor());
    }

    @Test
    void pixelCorrectColorAfterUpdatingSameTwiceWithChange(){
        assertEquals(pixel3.getColor(), repository.updatePixel(pixel3).getColor());
        assertEquals(pixel3blue.getColor(), repository.updatePixel(pixel3blue).getColor());
    }

    @Test
    void getAllPixelsIsEmpty(){
        assertTrue(repository.getAllPixels().isEmpty());
    }

    @Test
    void getAllPixelsCorrectSizeAfterUpdatingOne(){
        repository.updatePixel(pixel1);
        assertEquals(1, repository.getAllPixels().size());
    }

    @Test
    void getAllPixelsCorrectSizeAfterUpdatingOneTwice(){
        repository.updatePixel(pixel1);
        repository.updatePixel(pixel1);
        assertEquals(1, repository.getAllPixels().size());
    }

    @Test
    void getAllPixelsCorrectSizeAfterUpdatingOneTwiceWithColorChange(){
        repository.updatePixel(pixel3);
        repository.updatePixel(pixel3blue);
        System.out.println(repository.getAllPixels());
        assertEquals(1, repository.getAllPixels().size());
    }

    @Test
    void getAllPixelsCorrectSizeAfterUpdatingMultiple(){
        repository.updatePixel(pixel1);
        repository.updatePixel(pixel2);
        repository.updatePixel(pixel3);
        assertEquals(3, repository.getAllPixels().size());
    }

    @Test
    void getAllPixelsContainsCorrectAfterUpdatingOne(){
        repository.updatePixel(pixel1);
        assertTrue(repository.getAllPixels().contains(pixel1));
    }


    @Test
    void getAllPixelsContainsCorrectAfterUpdatingOneTwice(){
        repository.updatePixel(pixel1);
        repository.updatePixel(pixel1);
        assertTrue(repository.getAllPixels().contains(pixel1));
    }

    @Test
    void getAllPixelsContainsCorrectAfterUpdatingOneTwiceWithChange(){
        repository.updatePixel(pixel3);
        repository.updatePixel(pixel3blue);
        assertTrue(repository.getAllPixels().contains(pixel3blue));
    }

    @Test
    void getAllPixelsContainsAllAfterUpdatingMultiple(){
        repository.updatePixel(pixel1);
        repository.updatePixel(pixel2);
        repository.updatePixel(pixel3);
        assertTrue(repository.getAllPixels().containsAll(List.of(pixel1, pixel2, pixel3)));
    }

    @Test
    void getAllPixelsContainsCorrectColorsAfterUpdatingOne(){
        repository.updatePixel(pixel1);
        assertEquals(pixel1.getColor(), repository.getAllPixels().get(0).getColor());
    }


    @Test
    void getAllPixelsContainsCorrectColorsAfterUpdatingOneTwice(){
        repository.updatePixel(pixel1);
        repository.updatePixel(pixel1);
        assertEquals(pixel1.getColor(), repository.getAllPixels().get(0).getColor());
    }

    @Test
    void getAllPixelsContainsCorrectColorsAfterUpdatingOneTwiceWithChange(){
        repository.updatePixel(pixel3);
        repository.updatePixel(pixel3blue);
        assertEquals(pixel3blue.getColor(), repository.getAllPixels().get(0).getColor());
    }

    @Test
    void getAllPixelsContainsCorrectColorsAfterUpdatingMultiple(){
        repository.updatePixel(pixel1);
        repository.updatePixel(pixel2);
        repository.updatePixel(pixel3);

        var allPixels = repository.getAllPixels();
        assertEquals(pixel1.getColor(), allPixels.get(allPixels.indexOf(pixel1)).getColor());
        assertEquals(pixel2.getColor(), allPixels.get(allPixels.indexOf(pixel2)).getColor());
        assertEquals(pixel3.getColor(), allPixels.get(allPixels.indexOf(pixel3)).getColor());
    }
}