package info.developia.reactive.api.handler;

import info.developia.reactive.api.model.Menu;
import ratpack.handling.Context;

import java.util.Map;

import static ratpack.jackson.Jackson.json;

public class MenuHandler {
    private final Map<String, Menu> menus = Map.of(
            "1", new Menu("Menu 1"), "2", new Menu("Menu 2"), "3", new Menu("Menu 3"), "4", new Menu("Menu 4"), "5", new Menu("Menu 5"),
            "6", new Menu("Menu 6"), "7", new Menu("Menu 7"), "8", new Menu("Menu 8"), "9", new Menu("Menu 9"), "10", new Menu("Menu 10")
    );

    public void getMenus(Context ctx) {
        ctx.render(json(menus.values()));
    }

    public void getMenu(Context ctx) {
        String id = ctx.getPathTokens().get("id");
        ctx.render(json(menus.get(id)));
    }
}
