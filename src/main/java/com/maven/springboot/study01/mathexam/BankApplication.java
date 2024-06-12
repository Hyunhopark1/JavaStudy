package com.maven.springboot.study01.mathexam;

import java.util.Scanner;

public class BankApplication {

    public static void main(String[] args) {
        String accountNum="";  //계좌번호
        String accountName=""; //계좌주
        int initialInput=0;  //초기 입금액
        int input=0,output=0;  //입금액, 출금액

        int key=0;  //입력 키

        Account[] accounts = new Account[100];
        int accountIndex=0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("---------------------------------------------");

            System.out.print("선택>");
            key=sc.nextInt();
            switch (key) {
                case 1:
                    System.out.println("------------------");
                    System.out.println("계좌생성");
                    System.out.println("------------------");
                    System.out.print("계좌번호:");
                    accountNum=sc.next();
                    System.out.print("계좌주:");
                    accountName=sc.next();
                    System.out.print("초기입금액:");
                    initialInput=sc.nextInt();

                    //계좌 생성
                    accounts[accountIndex] = new Account(accountNum, accountName, initialInput);
                    accountIndex++;
                    System.out.println("결과 : 계좌가 생성되었습니다.");
                    break;
                case 2:
                    System.out.println("------------------");
                    System.out.println("계좌목록");
                    System.out.println("------------------");
                    for (int i=0; i<accountIndex; i++) {
                        System.out.print(accounts[i].getAccountNum()+"\t");
                        System.out.print(accounts[i].getAccountName()+"\t");
                        System.out.println(accounts[i].getMoney());
                    }
                    break;
                case 3:
                    System.out.println("------------------");
                    System.out.println("예금");
                    System.out.println("------------------");
                    System.out.print("계좌번호:");
                    accountNum=sc.next();
                    System.out.print("예금액:");
                    input=sc.nextInt();
                    for (int i = 0; i < accountIndex; i++) {
                        if (accounts[i].getAccountNum().equals(accountNum)) {
                            accounts[i].inputMoney(input);
                        }
                    }
                    System.out.println(accountNum+"계좌에"+input+"원 예금이 성공되었습니다.");
                    break;
                case 4:
                    System.out.println("------------------");
                    System.out.println("예금");
                    System.out.println("------------------");
                    System.out.print("계좌번호:");
                    accountNum=sc.next();
                    System.out.print("출금액:");
                    output=sc.nextInt();
                    for (int i = 0; i < accountIndex; i++) {
                        if (accounts[i].getAccountNum().equals(accountNum)) {
                            accounts[i].outputMoney(output);
                        }
                    }
                    System.out.println(accountNum+"계좌에서"+output+"원 출금이 성공되었습니다.");
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    return;
            }
        }
    }
}
