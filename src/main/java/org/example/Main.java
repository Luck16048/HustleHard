package org.example;

import org.example.entity.*;
import org.example.repository.*;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
    ProductEntity p = new ProductEntity();
    p.setId(5);
    p.setName("Jopa3");
    p.setCountry("USA");
    p.setStatus(StatusProductEntity.In_stock);

    ProductRepository pr = new ProductRepository();
        pr.saveProduct(p);

    ProductEntity fromDb =pr.findProduct(2);
        System.out.println("Id: " + fromDb.getId());
        System.out.println("Name: " + fromDb.getName());
        System.out.println("Country: " + fromDb.getCountry());
        System.out.println("Status: " + fromDb.getStatus());

        pr.deleteProduct(2);

        CacheProductRepository cp = new CacheProductRepository();
        cp.saveProductCache(p);
        System.out.println("Status: " + cp.findStatusProdust(5));
          cp.deleteProduct(5);


        PassportEntity pass = new PassportEntity();
        pass.setId(5);
        pass.setFullName("Asia Przemek");
        pass.setCountry("USA");
        pass.setCode(14368);

        PassportRepository passRep = new PassportRepository();
        passRep.savePassport(pass);

        CachePassportRepository cpass = new CachePassportRepository();
        cpass.saveCachePassport(pass);
        System.out.println("Code: " + cpass.findCachePassport(5));
            cpass.deleteCachePassport(3);


        PassportEntity findPass = passRep.findPassport(3);
        System.out.println("Id: " + findPass.getId());
        System.out.println("Full name: " + findPass.getFullName());
        System.out.println("Country: " + findPass.getCountry());
        System.out.println("Code: " + findPass.getCode());

        passRep.deletePassport(3);


       ApartmentEntity ap = new ApartmentEntity();
       ap.setId(5);
       ap.setNumber(7);
       ap.setType(ServesLevelEntity.Available);
       ap.setStatus(StatusEntity.STD);

        ApartmentRepository apRep = new ApartmentRepository();
        apRep.saveApartment(ap);

       ApartmentEntity findAp = apRep.findApartment(3);
       System.out.println("Id: " + findAp.getId());
      System.out.println("Number: " + findAp.getNumber());
       System.out.println("Class: " + findAp.getType());
      System.out.println("Status: " + findAp.getStatus());

        apRep.deleteApartment(1);
    }
}