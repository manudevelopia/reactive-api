package info.developia.reactive.api.handler;

import info.developia.reactive.api.service.UserService;
import ratpack.core.handling.Context;
import ratpack.rx2.RxRatpack;

import static ratpack.core.jackson.Jackson.json;

public class UserHandler {
    private final UserService userService = new UserService();


    public void user(Context ctx) {
        String id = ctx.getPathTokens().get("id");
        RxRatpack.promise(userService.getUser(Long.valueOf(id)))
                .onError(ctx::error)
                .then(user -> ctx.render(json(user)));
    }

    public void users(Context ctx) {
        RxRatpack.promise(userService.getUsers())
                .onError(ctx::error)
                .then(user -> ctx.render(json(user)));
    }

    public void usersStream(Context ctx) {
        RxRatpack.promiseAll(userService.getUsersStream())
                .onError(ctx::error)
                .then(user -> ctx.render(json(user)));
    }
}
