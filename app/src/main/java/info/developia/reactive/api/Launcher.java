package info.developia.reactive.api;

import info.developia.reactive.api.handler.CORSHandler;
import info.developia.reactive.api.handler.MenuHandler;
import info.developia.reactive.api.handler.UserHandler;
import ratpack.core.server.RatpackServer;
import ratpack.rx2.RxRatpack;

public class Launcher {
    public static final Persitence persitence = new Persitence("info.developia.reactive.api.repository.mapper");
    private final UserHandler userHandler = new UserHandler();
    private final MenuHandler menuHandler = new MenuHandler();


    public static void main(String[] args) throws Exception {
        new Launcher().run();
    }

    private void run() throws Exception {
        RxRatpack.initialize();
        RatpackServer.start(server -> server
                .handlers(chain -> chain
                        .all(new CORSHandler())
                        .get("users/:id", userHandler::user)
                        .get("users", userHandler::users)
                        .get("usersStream", userHandler::usersStream)
                        .get("menus", menuHandler::getMenus)
                        .get("menusStream", menuHandler::getMenuStream)
                        .get("menus/:id", menuHandler::getMenu)
                )
        );
    }
}
