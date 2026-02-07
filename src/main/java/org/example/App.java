package org.example;
import io.javalin.Javalin;

public class App{
    public static void main(String[] args){
       Javalin app = Javalin.create().start(9000);

       app.get("/getName", ctx -> {
           ctx.result("Karyna");
       });

       app.get("/getLocation", ctx -> {
           ctx.result("Poland");
       });
    }
}