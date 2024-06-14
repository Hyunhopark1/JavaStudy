package com.maven.springboot.study01.chapter06;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Account {
    private String accountNum;
    private String accountName;
    private int money;

    public Account(String accountNum, String accountName, int money) throws Exception {
        if (!accountNum.chars().allMatch(Character::
                isDigit)) {
            throw new Exception("계좌 번호는 숫자만 입력해 주세요");
        }

        this.accountNum = accountNum;
        this.accountName = accountName;
        this.money = money;
    }

    public void inputMoney(int input) {

        money += input;
    }

    public void outputMoney(int output) {
        money -= output;
    }


}
