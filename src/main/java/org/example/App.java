package org.example;

import io.javalin.Javalin;
import org.example.entity.*;
import org.example.service.ApartmentService;
import org.example.service.PassportService;
import org.example.service.PersonService;
import org.example.service.ProductService;

import java.util.Map;


public class App {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(9000);

        ApartmentService serviceAp = new ApartmentService();
        PassportService servicePass = new PassportService();
        PersonService servicePer = new PersonService();
        ProductService servicePro = new ProductService();

        app.get("/apartment/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            ctx.json(serviceAp.getById(id));
        });
        app.get("/passport/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            ctx.json(servicePass.getById(id));
        });
        app.get("/person/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            ctx.json(servicePer.getById(id));
        });
        app.get("/product/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            ctx.json(servicePro.getById(id));
        });


        app.delete("/apartment/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            serviceAp.deleteById(id);
            ctx.result("Deleted");
        });
        app.delete("/passport/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            servicePass.deleteById(id);
            ctx.result("Deleted");
        });
        app.delete("/person/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            servicePer.deleteById(id);
            ctx.result("Deleted");
        });
        app.delete("/product/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            servicePro.deleteById(id);
            ctx.result("Deleted");
        });

        app.post("/apartment", ctx -> {
            ApartmentEntity apart = ctx.bodyAsClass(ApartmentEntity.class);
            serviceAp.save(apart);
            ctx.result("Saved");
        });
        app.post("/passport", ctx -> {
            PassportEntity pass = ctx.bodyAsClass(PassportEntity.class);
            servicePass.save(pass);
            ctx.result("Saved");
        });
        app.post("/person", ctx -> {
            PersonEntity person = ctx.bodyAsClass(PersonEntity.class);
            servicePer.save(person);
            ctx.result("Saved");
        });
        app.post("/product", ctx -> {
            ProductEntity prod = ctx.bodyAsClass(ProductEntity.class);
            servicePro.save(prod);
            ctx.result("Saved");
        });

        app.put("/apartment/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            ApartmentEntity apart = ctx.bodyAsClass(ApartmentEntity.class);
            apart.setId(id);
            serviceAp.update(apart);
            ctx.result("Updated");
        });
        app.put("/passport/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            PassportEntity pass = ctx.bodyAsClass(PassportEntity.class);
            pass.setId(id);
            servicePass.update(pass);
            ctx.result("Updated");
        });
        app.put("/person/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            PersonEntity person = ctx.bodyAsClass(PersonEntity.class);
            person.setId(id);
            servicePer.update(person);
            ctx.result("Updated");
        });
        app.put("/product/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            ProductEntity prod = ctx.bodyAsClass(ProductEntity.class);
            prod.setId(id);
            servicePro.update(prod);
            ctx.result("Updated ");
        });

        app.patch("/apartment/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            ApartmentEntity apart = serviceAp.getById(id);
            Map<String, Object> updates = ctx.bodyAsClass(Map.class);
            if(updates.containsKey("id")){
                apart.setId((int) updates.get("id"));
            }
            if(updates.containsKey("number")){
                apart.setNumber((int) updates.get("number"));
            }
            if(updates.containsKey("type")){
                apart.setType(ServesLevelEntity.valueOf((String) updates.get("type")));
            }
            if(updates.containsKey("status")){
                apart.setStatus(StatusEntity.valueOf((String) updates.get("status")));
            }
            serviceAp.update(apart);
            ctx.result("Patched");
        });
        app.patch("/passport/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            PassportEntity pass = servicePass.getById(id);
            Map<String, Object> updates = ctx.bodyAsClass(Map.class);
            if(updates.containsKey("id")){
                pass.setId((int) updates.get("id"));
            }
            if(updates.containsKey("fullName")){
                pass.setFullName((String) updates.get("fullName"));
            }
            if(updates.containsKey("country")){
                pass.setCountry((String) updates.get("country"));
            }
            if(updates.containsKey("code")){
                pass.setCode((int) updates.get("code"));
            }
            servicePass.update(pass);
            ctx.result("Patched");
        });
        app.patch("/person/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            PersonEntity person = servicePer.getById(id);
            Map<String, Object> updates = ctx.bodyAsClass(Map.class);
            if(updates.containsKey("id")){
                person.setId((int) updates.get("id"));
            }
            if(updates.containsKey("name")){
                person.setName((String) updates.get("name"));
            }
            if(updates.containsKey("age")){
                person.setAge((int) updates.get("age"));
            }
            servicePer.update(person);
            ctx.result("Patched");
        });
        app.patch("/product?{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            ProductEntity prod = servicePro.getById(id);
            Map<String, Object> updates = ctx.bodyAsClass(Map.class);
            if(updates.containsKey("id")){
                prod.setId((int) updates.get("id"));
            }
            if(updates.containsKey("name")){
                prod.setName((String) updates.get("name"));
            }
            if(updates.containsKey("country")){
                prod.setCountry((String) updates.get("country"));
            }
            if(updates.containsKey("status")){
                prod.setStatus(StatusProductEntity.valueOf((String) updates.get("status")));
            }
            servicePro.update(prod);
            ctx.result("Patched");
        });
    }
}