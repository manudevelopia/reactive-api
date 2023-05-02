package info.developia.reactive.api.handler;

import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;
import ratpack.core.http.MutableHeaders;

public class CORSHandler implements Handler {
    @Override
    public void handle(Context ctx) {
        MutableHeaders headers = ctx.getResponse().getHeaders();
        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept");
        ctx.next();
    }
}