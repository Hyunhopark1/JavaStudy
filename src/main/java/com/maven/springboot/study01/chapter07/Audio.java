package com.maven.springboot.study01.chapter07;

public class Audio implements Remote {

    private int volume;
    @Override
    public void turnOn() {
        System.out.println("오디오를 켭니다");
    }

    @Override
    public void turnOff() {
        System.out.println("오디오를 끕니다");
    }

    @Override
    public void setVolume(int volume) {
        if (volume > Remote.MAX_VOLUME) {
            this.volume=Remote.MAX_VOLUME;
        } else if (volume < Remote.MIN_VOLUME) {
            this.volume=Remote.MIN_VOLUME;
        }else{
            this.volume=volume;
        }
        System.out.println("현재 볼륨 : "+this.volume);
        
    }

    @Override
    public void setMute(boolean mute) {

        if (mute) {
            System.out.println("무음 처리합니다");
            setVolume(Remote.MIN_VOLUME);
        }else{
            System.out.println("무음 해제합니다");
            setVolume(this.volume);
        }
    }
    
    public void print() {
        System.out.println("그냥 출력");
    }
}
