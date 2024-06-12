package com.maven.springboot.study01.mathexam;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Account {
    private String accountNum;
    private String accountName;
    private int money;

    public Account(String accountNum,String accountName,int money) {
        this.accountNum=accountNum;
        this.accountName=accountName;
        this.money=money;
    }

    public void inputMoney(int input) {
        money+=input;
    }

    public void outputMoney(int output) {
        money-=output;
    }

}
