package com.maven.springboot.study01.mathexam;

public class ShopService {

    private static ShopService singleton = new ShopService();

    private ShopService(){}

    public static ShopService getInstance() {
        return singleton;
    }
}
