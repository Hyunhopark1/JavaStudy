package com.maven.springboot.study01.chapter07;

public class AudioEx {
    public static void main(String[] args) {
        Audio a =new Audio();

        a.turnOn();
        a.setVolume(10);
        a.setMute(true);
        a.turnOff();
    }
}
