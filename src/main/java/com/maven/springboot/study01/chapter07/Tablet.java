package com.maven.springboot.study01.chapter07;


public class Tablet extends Phone{

    String owner;
    public Tablet(String owner) {
        this.owner=owner;
        System.out.println("태블릿 매개변수 생성자 실행");
    }
    public Tablet() {
        this("오너");
        System.out.println("태블릿 기본생성자 실행");
    }


}
class Ex011 {

    public static void main(String[] args) {
        Tablet t = new Tablet();

        
    }
}
