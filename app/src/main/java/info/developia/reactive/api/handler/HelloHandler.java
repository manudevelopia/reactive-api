package info.developia.reactive.api.handler;

import info.developia.reactive.api.model.Menu;
import info.developia.reactive.api.model.User;
import ratpack.handling.Context;
import ratpack.jackson.Jackson;

import java.util.List;

public class HelloHandler implements Handler {

    private final User user = new User("Manu");
    private final List<Menu> menus = List.of(
            new Menu("Menu 1"),
            new Menu("Menu 2"),
            new Menu("Menu 3"),
            new Menu("Menu 4"),
            new Menu("Menu 5"),
            new Menu("Menu 6"),
            new Menu("Menu 7"),
            new Menu("Menu 8"),
            new Menu("Menu 9"),
            new Menu("Menu 10")
    );

    public void hello(Context ctx) {
        ctx.render(toJson(user));
    }

    public void getMenus(Context ctx) {
        ctx.render(Jackson.json(menus));
    }
}
