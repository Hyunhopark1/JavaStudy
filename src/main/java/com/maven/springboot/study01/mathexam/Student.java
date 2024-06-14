package com.maven.springboot.study01.mathexam;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter //getter메소드 자동생성 어노테이션
public class Student {
    private String name;
    private int score;


    public Student(String name, int score) {
        this.name=name;
        this.score=score;


    }


    @Override
    public String toString() {

        return String.format("이름 : %s, 점수 : %d", name, score);

    }
}
