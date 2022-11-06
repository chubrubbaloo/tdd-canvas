package services;

import entities.Pixel;
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
    @DisplayName("Get white canvas (50x75-array)")
    void get_blank_canvas_from_pixels() {
        //Given
        Mockito.when(repository.getAllPixels()).thenReturn(new ArrayList<>());
        var result = service.getPixels();
        var expected = new String[50][75];

        //When
        Arrays.stream(expected)
                .forEach(x -> Arrays.fill(x, "white"));

        //Then
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }

    @Test
    @DisplayName("Get canvas ('real'-array)")
    void get_real_canvas_from_pixels() {
        //Given
        Mockito.when(repository.getAllPixels()).thenReturn(new ArrayList<>());
        var result = service.getPixels();

        //When
        var expected = CanvasService.generateEmptyArray(50);
        System.out.println(Arrays.deepToString(service.getPixels()));

        //Then
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }

    @Test
    @DisplayName("Get populated dummy-canvas")
    void get_populated_canvas_from_repository() {
        //Given
        var pixelList = new ArrayList<Pixel>();
        pixelList.add(new Pixel(0, 2, "green"));
        pixelList.add(new Pixel(0, 1, "blue"));
        Mockito.when(repository.getAllPixels()).thenReturn(pixelList);
        var result = service.getPixels();

        //When
        var expected = CanvasService.generateEmptyArray(50);
        expected[0][2] = "green";
        expected[0][1] = "blue";
        System.out.println(Arrays.deepToString(service.getPixels()));

        //Then
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }

}

