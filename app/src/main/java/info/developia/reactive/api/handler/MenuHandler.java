package info.developia.reactive.api.handler;

import info.developia.reactive.api.service.MenuService;
import ratpack.core.handling.Context;

import static ratpack.core.jackson.Jackson.json;

public class MenuHandler {
    private final MenuService menuService = new MenuService();

    public void getMenus(Context ctx) {
        var menus = menuService.getMenus();
        ctx.render(json(menus));
    }

    public void getMenu(Context ctx) {
        String id = ctx.getPathTokens().get("id");
        var menu = menuService.getMenu(id);
        ctx.render(json(menu));
    }
}
