package com.maven.springboot.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

    //private로 선언한 계좌번호,계좌주,잔액 멤버변수
    private String accountNum;
    private String accountName;
    private int balance;

    //매개변수 3개 생성자
    public Account(String accountNum, String accountName, int balance) {
        this.accountNum=accountNum;
        this.accountName=accountName;
        this.balance=balance;
    }
    //기본 생성자
    public Account() {
        this.accountNum="";
        this.accountName="";
        this.balance = 0;
    }
    //계좌의 필드 정보 출력하는 toString 메소드
    @Override
    public String toString() {
        return String.format("계좌번호 : %s | 계좌주 : %s | 잔액 : %d |" ,this.accountNum,this.accountName,this.balance);
    }
}
