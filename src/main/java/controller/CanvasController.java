package controller;

import entities.Pixel;
import io.javalin.http.Context;
import services.CanvasService;

import java.util.HashMap;

public class CanvasController {

    CanvasService service;

    public CanvasController(CanvasService service){
        this.service = service;
    }

    public void getCanvas(Context context){
        context.json(service.getPixels());
    }

    public void putPixel(Context context){
        try{
            var data = context.bodyAsClass(HashMap.class);
            context.json(service.putPixel((int) data.get("x"), (int)data.get("y"), (String) data.get("color")));
        }catch (Exception e){
            context.status(400);
        }
    }
}
