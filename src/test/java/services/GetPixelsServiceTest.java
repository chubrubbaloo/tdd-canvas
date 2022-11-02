package java.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repositories.MemoryPixelRepository;
import repositories.PixelRepository;
import services.CanvasService;

import java.util.ArrayList;
import java.util.Arrays;

public class GetPixelsServiceTest {

    PixelRepository repository;
    CanvasService service;

    @BeforeEach
    void setup() {
        repository = Mockito.mock(MemoryPixelRepository.class);
        service = new CanvasService(repository);
    }

    @Test
    @DisplayName("Get empty canvas (2x3-array)")
    void get_empty_canvas_array() {
        //Given
        Mockito.when(repository.getAllPixels()).thenReturn(new ArrayList<>());
        var result = service.getPixels();
        var expected = new String[2][3];

        //When
        Arrays.stream(expected)
                .forEach(x -> Arrays.fill(x, "white"));

        //Then
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }

    @Test
    @DisplayName("Get white canvas (2x3-array)")
    void get_white_canvas_from_pixels() {
        //Given
        Mockito.when(repository.getAllPixels()).thenReturn(new ArrayList<>());
        var result = service.getPixels();
        var expected = new String[2][3];

        //When
        Arrays.stream(expected)
                .forEach(x -> Arrays.fill(x, "white"));

        //Then
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }

    @Test
    @DisplayName("Get canvas (real-array)")
    void get_real_canvas_from_pixels() {
        //Given
        Mockito.when(repository.getAllPixels()).thenReturn(new ArrayList<>());
        var result = service.getPixels();

        //When
        var expected = CanvasService.generateEmptyArray(2);
        System.out.println(Arrays.deepToString(service.getPixels()));

        //Then
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }

    @Test
    @DisplayName("Get canvas2 (real-array)")
    void test_size_3_array_pixels() {
        //Given
        Mockito.when(repository.getAllPixels()).thenReturn(new ArrayList<>());
        var result = service.getPixels();

        //When
        var expected = CanvasService.generateEmptyArray(3);
        System.out.println(Arrays.deepToString(service.getPixels()));


        //Then
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }

}
