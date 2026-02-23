package org.example;
import io.javalin.Javalin;
import org.example.entity.ApartmentEntity;
import org.example.entity.PassportEntity;
import org.example.entity.PersonEntity;
import org.example.entity.ProductEntity;
import org.example.service.ApartmentService;
import org.example.service.PassportService;
import org.example.service.PersonService;
import org.example.service.ProductService;


public class App{
    public static void main(String[] args){

        Javalin app = Javalin.create().start(9000);

        ApartmentService serviceAp = new ApartmentService();
        PassportService servicePass = new PassportService();
        PersonService servicePer = new PersonService();
        ProductService servicePro = new ProductService();

        app.get("/apartment/{id}", ctx ->{
           int id = Integer.parseInt(ctx.pathParam("id"));
           ctx.json(serviceAp.getById(id));
        });
            app.get("/passport/{id}", ctx ->{
               int id = Integer.parseInt(ctx.pathParam("id"));
               ctx.json(servicePass.getById(id));
            });
                app.get("/person/{id}", ctx ->{
                   int id = Integer.parseInt(ctx.pathParam("id"));
                    ctx.json(servicePer.getById(id));
                });
                    app.get("/product/{id}", ctx ->{
                       int id = Integer.parseInt(ctx.pathParam("id"));
                       ctx.json(servicePro.getById(id));
                    });


        app.delete("/apartment/{id}", ctx ->{
           int id = Integer.parseInt(ctx.pathParam("id"));
           serviceAp.deleteById(id);
           ctx.result("Deleted");
        });
            app.delete("/passport/{id}", ctx ->{
               int id = Integer.parseInt(ctx.pathParam("id"));
               servicePass.deleteById(id);
               ctx.result("Deleted");
            });
                app.delete("/person/{id}", ctx -> {
                    int id = Integer.parseInt(ctx.pathParam("id"));
                   servicePer.deletById(id);
                   ctx.result("Deleted");
                });
                    app.delete("/product/{id}", ctx ->{
                       int id = Integer.parseInt(ctx.pathParam("id"));
                       servicePro.deleteById(id);
                       ctx.result("Deleted");
                    });

        app.post("/apartment", ctx ->{
            ApartmentEntity apart =ctx.bodyAsClass(ApartmentEntity.class);
            serviceAp.save(apart);
            ctx.result("Saved");
        });
            app.post("/passport", ctx ->{
                PassportEntity pass = ctx.bodyAsClass(PassportEntity.class);
                servicePass.save(pass);
                ctx.result("Saved");
            });
                app.post("/person", ctx -> {
                   PersonEntity person = ctx.bodyAsClass(PersonEntity.class);
                   servicePer.save(person);
                   ctx.result("Saved");
                });
                    app.post("/product", ctx ->{
                        ProductEntity prod = ctx.bodyAsClass(ProductEntity.class);
                        servicePro.save(prod);
                        ctx.result("Saved");
                    });
    }
}