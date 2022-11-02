import controller.CanvasController;
import io.javalin.Javalin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.MemoryPixelRepository;
import services.CanvasService;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CanvasRestApiTest {
    Javalin app;
    String[][] expectedResult = new String[2][3];

    @BeforeEach
    void setup(){
        app = CanvasRestApi.getApp(new CanvasController(new CanvasService(new MemoryPixelRepository())));
        Arrays.stream(expectedResult).forEach(x -> Arrays.fill(x, "white"));
    }

    // ingen JavalinTest class? wth...
    @Test
    void EmptyCanvas(){
    }
}