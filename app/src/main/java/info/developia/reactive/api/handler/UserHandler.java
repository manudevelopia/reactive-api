package info.developia.reactive.api.handler;

import info.developia.reactive.api.model.User;
import ratpack.core.handling.Context;

import static ratpack.core.jackson.Jackson.json;

public class UserHandler {
    private final User user = new User("Manu");

    public void hello(Context ctx) {
        ctx.render(json(user));
    }
}
