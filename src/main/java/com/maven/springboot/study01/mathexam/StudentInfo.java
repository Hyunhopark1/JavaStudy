package com.maven.springboot.study01.mathexam;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentInfo {
    private char code;
    private int no;
    private String name;

    public StudentInfo(char code, int no, String name) {
        this.code=code;
        this.no=no;
        this.name=name;
    }
}
