package com.maven.springboot.study01.chapter07;

public interface Remote {

    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;

    void turnOn();

    void turnOff();

    void setVolume(int volume);

    default void setMute(boolean mute) {
        if (mute) {
            System.out.println("무음 처리 합니다");
            setVolume(MIN_VOLUME);
        }else {
            System.out.println("무음 해제 합니다");
        }
    }

    public static void main(String[] args) {
        Remote a = new Audio();
        a.turnOn();
        a.turnOff();
    }
}
