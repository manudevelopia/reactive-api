package info.developia.reactive.api.handler;

import info.developia.reactive.api.service.MenuService;
import ratpack.core.handling.Context;
import ratpack.rx2.RxRatpack;

import static ratpack.core.jackson.Jackson.json;

public class MenuHandler {
    private final MenuService menuService = new MenuService();

    public void getMenus(Context ctx) {
        RxRatpack.promise(menuService.getMenus())
                .onError(ctx::error)
                .then(menu -> ctx.render(json(menu)));
    }

    public void getMenu(Context ctx) {
        String id = ctx.getPathTokens().get("id");
        RxRatpack.promise(menuService.getMenu(id))
                .onError(ctx::error)
                .then(menu -> ctx.render(json(menu)));
    }

    public void getMenuStream(Context ctx) {
        RxRatpack.promiseAll(menuService.getMenusStream())
                .onError(ctx::error)
                .then(menu -> ctx.render(json(menu)));
    }
}
