package com.maven.springboot.study01.chapter07;

public class Tire {
    public String color;
    public String name;
    public String model;

    public Tire(String c,String n,String m) {
        color=c;
        name=n;
        model=m;
    }
    public void run() {
        System.out.println("go");
    }
}

class HKTire extends Tire {

    public HKTire(String c,String n,String m){
        super(c, n, m);
    }
    @Override
    public void run() {
        System.out.println(color+" "+name+" "+model+"회전");
    }
}
class EE12E{
    public static void main(String[] args) {
        HKTire h = new HKTire("R", "a", "s");
        Tire tire = h;

        h.run();
        tire.run();
    }
}
