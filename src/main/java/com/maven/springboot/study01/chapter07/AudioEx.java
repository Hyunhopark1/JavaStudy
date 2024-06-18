package com.maven.springboot.study01.chapter07;

public class AudioEx {
    public static void main(String[] args) {
        Remote a =new Audio();
        Audio ad =(Audio)a;
        ad.print();
        ad.turnOn();
        a.setVolume(10);
        a.setMute(true);
        a.turnOff();
    }
}
