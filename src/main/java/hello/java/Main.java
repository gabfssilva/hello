package hello.java;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static spark.Spark.*;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
public class Main {
    public static void main(String[] args) {
        final String appInterface = args[0];
        final int appPort = parseInt(args[1]);

        ipAddress(appInterface);
        port(appPort);

        get("/hello-java/hello", (req, resp) -> format("hello-scala, world! running on %s:%d", appInterface, appPort));
        get("/hello-java/health", (req, resp) -> "ok!");
        get("/loaderio-93f4cb143cf6225704731e0dfc39c59a/", (req, resp) -> "loaderio-93f4cb143cf6225704731e0dfc39c59a");
    }
}
