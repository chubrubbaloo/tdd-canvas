import controller.CanvasController;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;
import io.javalin.testtools.JavalinTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repositories.MemoryPixelRepository;
import services.CanvasService;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CanvasRestApiTest {
    Javalin app = CanvasRestApi.getApp(new CanvasController(new CanvasService(new MemoryPixelRepository())));
    String[][] expectedResult = new String[50][75];

    @BeforeEach
    void setup(){
        Arrays.stream(expectedResult).forEach(x -> Arrays.fill(x, "white"));
    }

    @Test
    void getPixelsReturnsCanvas(){
        JavalinTest.test(app, (server, client) -> {
            assertEquals(new JavalinJackson().toJsonString(expectedResult, String[][].class), client.get("/pixels").body().string());
        });
    }

    @Test
    void getPixelsReturnsCanvasAfterChangingColor(){
        JavalinTest.test(app, (server, client) -> {
            client.put("/pixels", "{\"x\": 0, \"y\": 0, \"color\": \"blue\"}").close();
            expectedResult[0][0] = "blue";
            assertEquals(new JavalinJackson().toJsonString(expectedResult, String[][].class), client.get("/pixels").body().string());
        });
    }

    @Test
    void getPixelsReturnsCanvasAfterChangingColorIncorrectly(){
        JavalinTest.test(app, (server, client) -> {
            assertEquals(400, client.put("/pixels", "{\"x\": 0, \"y\": 0, \"color\": none}").code());
            assertEquals(400, client.put("/pixels", "{\"x\": -1, \"y\": 0, \"color\": \"blue\"}").code());
            assertEquals(400, client.put("/pixels", "{\"x\": 0, \"y\": -1, \"color\": \"blue\"}").code());
            assertEquals(400, client.put("/pixels", "{\"y\": 0, \"color\": \"blue\"}").code());

        });
    }

}