import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create();

        app.get("/", ctx -> ctx.result("Hello World"));
        app.start(7070);
    }
}
