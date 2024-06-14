package com.maven.springboot.study01.chapter07;

public class SmartPhone extends Phone {

    public SmartPhone(String owner) {
        super(owner);
    }

    void internet() {
        System.out.println("인터넷 검색");
    }

    @Override
    void turnOn() {
        System.out.println(owner+"가 스마트폰 킴");
    }

    @Override
    void turnOff() {
        System.out.println(owner+"가 스마트폰 끔");
    }
}
class Tablet extends Phone{

    public Tablet(String owner) {
        super(owner);
    }
    @Override
    void turnOn() {
        System.out.println(owner+"가 태블릿 킴");
    }
    @Override
    void turnOff(){
        System.out.println(owner+"가 태블릿 끔");
    }

}
class Ex011 {

    public static void main(String[] args) {
        Phone s = new SmartPhone("홍길동");
        Phone t = new Tablet("김");

        phoneTurn(s);
        phoneTurn(t);
    }

    public static void phoneTurn(Phone phone) {
        phone.turnOn();
        phone.turnOff();
    }



}
