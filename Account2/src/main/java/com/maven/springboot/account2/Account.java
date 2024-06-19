package com.maven.springboot.account2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

    private String accountNum;
    private String accountName;
    private int balance;

    public Account() {
        this.accountNum=null;
        this.accountName=null;
        this.balance=0;
    }

    public Account(String accountNum, String accountName, int balance) {
        this.accountNum=accountNum;
        this.accountName=accountName;
        this.balance=balance;
    }

    @Override
    public String toString() {
        return String.format("| 계좌번호 : %s | 계좌주 : %s | 잔액 : %d |", accountNum, accountName, balance);
    }
}
