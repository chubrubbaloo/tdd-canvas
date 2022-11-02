import controller.CanvasController;
import io.javalin.Javalin;

public class CanvasRestApi {

    public static Javalin getApp(CanvasController controller){
        Javalin app = Javalin.create();
        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/pixels", controller::getCanvas);
        app.put("/pixels", controller::putPixel);
        app.start(7070);
        return app;
    }
}

