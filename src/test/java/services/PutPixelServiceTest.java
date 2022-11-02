package services;

import entities.Pixel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repositories.MemoryPixelRepository;

public class PutPixelServiceTest {

    MemoryPixelRepository repository;
    CanvasService service;


    @BeforeEach
    void setup() {
        repository = Mockito.mock(MemoryPixelRepository.class);
        service = new CanvasService(repository);
    }

    @Test
    @DisplayName("Test if put pixel stores correctly in repository")
    void putPixelTest() {
        //given
        Pixel finalPixel = new Pixel(1, 2, "white");

        //when/then
        var pixel = Assertions.assertDoesNotThrow(() -> service.putPixel(
                        finalPixel.getX(),
                        finalPixel.getY(),
                        finalPixel.getColor()));
        //then
        Assertions.assertNotNull(pixel);
        Mockito.verify(repository).updatePixel(pixel);
    }

    @Test
    @DisplayName("If pixel-color is null throw exception")
    void ifPixelColorIsNull(){
        //given
        var pixel = new Pixel (1, 2, null);

        //when/then
        Assertions.assertThrows(Exception.class, () -> service.putPixel(
                pixel.getX(),
                pixel.getY(),
                pixel.getColor()));

        //then
        Mockito.verify(repository, Mockito.never()).updatePixel(pixel);


    }
}
