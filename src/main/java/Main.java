import controller.CanvasController;
import repositories.MemoryPixelRepository;
import services.CanvasService;


public class Main {
    public static void main(String[] args) {
        CanvasRestApi.getApp(new CanvasController(new CanvasService( new MemoryPixelRepository())));
    }
}
