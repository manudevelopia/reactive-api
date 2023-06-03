package info.developia.reactive.api.handler;

import info.developia.reactive.api.service.UserService;
import ratpack.core.handling.Context;

import static ratpack.core.jackson.Jackson.json;

public class UserHandler {
    private final UserService userService = new UserService();


    public void user(Context ctx) {
        String id = ctx.getPathTokens().get("id");
        var user = userService.getUser(Long.parseLong(id));
        ctx.render(json(user));
    }

    public void users(Context ctx) {
        var users = userService.getUsers();
        ctx.render(json(users));
    }
}
