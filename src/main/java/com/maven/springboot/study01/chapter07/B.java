package com.maven.springboot.study01.chapter07;

public class B implements A {
    @Override
    public void a1() {
        System.out.println("b가만든 a1메소드");
    }
    @Override
    public void a2() {
        System.out.println("b가만든 a2메소드");
    }public void b1() {
        System.out.println("b1메소드");
    }
}
