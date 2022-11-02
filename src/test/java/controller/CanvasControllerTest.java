package controller;

import entities.Pixel;
import io.javalin.http.Context;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import services.CanvasService;

import java.util.Arrays;


class CanvasControllerTest {

    Context context;
    CanvasController controller;
    CanvasService service;
    String[][] expectedResult;

    @BeforeEach
    void setup(){
        context = Mockito.mock(Context.class);
        service = Mockito.mock(CanvasService.class);
        controller = new CanvasController(service);
        expectedResult = new String[2][3];
        Arrays.stream(expectedResult).forEach(x -> Arrays.fill(x, "white"));
    }

    @Test
    void getCanvasRespondsWithACanvas(){
        Mockito.when(service.getPixels()).thenReturn(expectedResult);
        Mockito.when(context.json(expectedResult)).thenReturn(context);
        controller.getCanvas(context);
        Mockito.verify(context).json(expectedResult);
    }

    @Test
    void putCanvasRespondsWithPixelData(){
        Pixel pixel = new Pixel(1,2,"blue");

        Mockito.when(context.bodyAsClass(Pixel.class)).thenReturn(pixel);
        Mockito.when(context.json(pixel)).thenReturn(context);
        Assertions.assertDoesNotThrow( () ->
                Mockito.when(service.putPixel(pixel.getX(), pixel.getY(), pixel.getColor())).thenReturn(pixel)
        );
        Assertions.assertDoesNotThrow( () -> controller.putPixel(context));
        Mockito.verify(context).json(pixel);
    }

    @Test
    void putCanvasBadlyRespondsWith400(){
        //Mockito.when(context.bodyAsClass(Pixel.class)).thenThrow(Exception.class);
        Mockito.when(context.status(400)).thenReturn(context);
        Assertions.assertDoesNotThrow( () -> controller.putPixel(context));
        Mockito.verify(context).status(400);
    }
}