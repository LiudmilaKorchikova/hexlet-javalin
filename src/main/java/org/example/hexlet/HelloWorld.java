package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/hello", ctx ->{
            String name = ctx.queryParam("name");
            if (name == null) {
                name = "World";
            }
            ctx.result("Hello " + name + "!");
        });

        app.get("/users/{id}/post/{postId}", ctx -> {
            String userId = ctx.pathParam("id");
            String postId = ctx.pathParam("postId");
            ctx.result("User ID: " + userId + ", Post ID: " + postId);
        });

        app.start(7070);
    }
}
