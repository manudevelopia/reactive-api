package info.developia.reactive.api;

import info.developia.reactive.api.handler.CORSHandler;
import info.developia.reactive.api.handler.MenuHandler;
import info.developia.reactive.api.handler.UserHandler;
import ratpack.core.server.RatpackServer;

public class App {
    UserHandler userHandler = new UserHandler();
    MenuHandler menuHandler = new MenuHandler();

    public static void main(String[] args) throws Exception {
        new App().run();
    }

    private void run() throws Exception {
        RatpackServer.start(server -> server
                .handlers(chain -> chain
                        .all(new CORSHandler())
                        .get("user", userHandler::hello)
                        .get("menus", menuHandler::getMenus)
                        .get("menus/:id", menuHandler::getMenu)
                )
        );
    }
}
