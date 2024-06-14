package com.maven.springboot.study01.chapter07;

public abstract class Phone {
    
    String owner;

    Phone(String owner) {
        this.owner=owner;
    }

    abstract void turnOn();



    abstract void turnOff();


}
