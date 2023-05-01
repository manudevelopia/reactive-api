package info.developia.reactive.api;

import info.developia.reactive.api.handler.CORSHandler;
import info.developia.reactive.api.handler.HelloHandler;
import ratpack.server.RatpackServer;

public class App {
    HelloHandler helloHandler = new HelloHandler();

    public static void main(String[] args) throws Exception {
        new App().run();
    }

    private void run() throws Exception {
        RatpackServer.start(server -> server
                .handlers(chain -> chain
                        .all(new CORSHandler())
                        .get("user", helloHandler::hello)
                        .get("menus", helloHandler::getMenus)
                )
        );
    }
}
