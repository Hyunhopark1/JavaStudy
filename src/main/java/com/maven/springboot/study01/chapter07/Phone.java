package com.maven.springboot.study01.chapter07;

public abstract class Phone {
    
    String nation;

    Phone(String nation) {
        this.nation=nation;
        System.out.println("폰 매개변수 생성자실행");
    }
    Phone() {
        this("대한민국");
        System.out.println("폰 기본생성자실행");
    }
    

}
