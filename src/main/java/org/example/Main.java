package org.example;

import org.example.entity.*;
import org.example.repository.*;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

//        ApartmentEntity ap = new ApartmentEntity();
//        ap.setId(3);
//        ap.setNumber(73);
//        ap.setType(ServesLevelEntity.VIP);
//        ap.setStatus(StatusEntity.Available);
//
//        ApartmentRepository apRep = new ApartmentRepository();
//        apRep.save(ap);
//
//        ApartmentEntity findAp = apRep.getById(5);
//        System.out.println("Id: " + findAp.getId());
//        System.out.println("Number: " + findAp.getNumber());
//        System.out.println("Class: " + findAp.getType());
//        System.out.println("Status: " + findAp.getStatus());
//
//        apRep.deleteById(7);
//
//        CacheApartmentRepository capar = new CacheApartmentRepository();
//        capar.saveCache(ap);
//
//        System.out.print("Status: " + capar.findCache(2));
//
//        capar.deleteCache(2);
//
//
//        PassportEntity pass = new PassportEntity();
//        pass.setId(7);
//        pass.setFullName("Nick Tores");
//        pass.setCountry("Italy");
//        pass.setCode(92868);
//
//        PassportRepository passRep = new PassportRepository();
//        passRep.save(pass);
//
//        PassportEntity findPass = passRep.getById(7);
//        System.out.println("Id: " + findPass.getId());
//        System.out.println("Full name: " + findPass.getFullName());
//        System.out.println("Country: " + findPass.getCountry());
//        System.out.println("Code: " + findPass.getCode());
//
//        passRep.deleteById(3);
//
//        CachePassportRepository cpass = new CachePassportRepository();
//        cpass.saveCache(pass);
//
//        System.out.println("Code: " + cpass.findCache(5));
//
//        cpass.deleteCache(3);
//
//
//        PersonEntity pe = new PersonEntity();
//        pe.setId(4);
//        pe.setName("Rose");
//        pe.setAge(19);
//
//        PersonRepository pRep = new PersonRepository();
//        pRep.save(pe);
//
//        PersonEntity byId = pRep.getById(2);
//        System.out.println("Id: " + byId.getId());
//        System.out.println("Name: " + byId.getName());
//        System.out.println("Age: " + byId.getAge());
//
//        pRep.deleteById(3);
//
//        CachePersonRepository cpers = new CachePersonRepository();
//        cpers.saveCache(pe);
//
//        System.out.print("Age: " + cpers.findCache(2));
//        cpers.deleteCache(2);
//
//
//        ProductEntity p = new ProductEntity();
//        p.setId(3);
//        p.setName("Inek");
//        p.setCountry("India");
//        p.setStatus(StatusProductEntity.Out_of_stock);
//
//        ProductRepository pr = new ProductRepository();
//        pr.save(p);
//
//        ProductEntity fromDb = pr.getById(3);
//        System.out.println("Id: " + fromDb.getId());
//        System.out.println("Name: " + fromDb.getName());
//        System.out.println("Country: " + fromDb.getCountry());
//        System.out.println("Status: " + fromDb.getStatus());
//
//
//        CacheProductRepository cp = new CacheProductRepository();
//        cp.saveCache(p);
//
//        System.out.println("Status: " + cp.findCache(5));
//        cp.deleteCache(5);
//        pr.deleteById(3);
    }
}