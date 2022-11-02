package controller;

import entities.Pixel;
import io.javalin.http.Context;
import services.CanvasService;

public class CanvasController {

    CanvasService service;

    public CanvasController(CanvasService service){
        this.service = service;
    }

    public void getCanvas(Context context){
        context.json(service.getPixels());
    }

    public void putPixel(Context context){
        Pixel pixel;
        try{
            pixel = context.bodyAsClass(Pixel.class);
            if (pixel == null){
                context.status(400);
                return;
            }
            context.json(service.putPixel(pixel.getX(), pixel.getY(), pixel.getColor()));
        }catch (Exception e){
            pixel = null;
        }
    }
}
