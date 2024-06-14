package com.maven.springboot.study01.chapter07;

public class Car {
    public Tire tire;

    public void run() {
        tire.run();
    }
}

class Ex01 {
    public static void main(String[] args) {
        Car car=new Car();


        car.tire=new HKTire("파란색","한국타이어","B모델");
        car.run();
    }
}
