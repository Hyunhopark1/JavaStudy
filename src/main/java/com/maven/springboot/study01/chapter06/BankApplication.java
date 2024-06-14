package com.maven.springboot.study01.chapter06;

import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {

    String accountNum;
    String accountName;
    int money;

    ArrayList<Account> accountArrayList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        BankApplication bankApplication = new BankApplication();
        String accountNum = "";  //계좌번호
        String accountName = ""; //계좌주
        int initialInput = 0;  //초기 입금액
        int input = 0, output = 0;  //입금액, 출금액

        int key = 0;  //입력 키

        Account[] accounts = new Account[100];   //크기 100 Account 배열
        int accountIndex = 0;  // Account 배열에 생성한 객체를 넣기 위한 인덱스

        Scanner sc = new Scanner(System.in);

        while (true) {
            bankApplication.printHeader();

            System.out.print("선택>");
            key = sc.nextInt();
            switch (key) {
                case 1:
                    bankApplication.addAccount();
                    break;
                case 2:
                    bankApplication.printAccountList();
                    break;
                case 3:
                    System.out.println("------------------");
                    System.out.println("예금");
                    System.out.println("------------------");
                    System.out.print("계좌번호('-'제외한 숫자만 입력):");
                    accountNum = sc.next();
                    System.out.print("예금액:");
                    input = sc.nextInt();
                    if (accountIndex == 0) {
                        System.out.println("아직 생성된 계좌가 없습니다.");
                    } else {
                        for (int i = 0; i < accountIndex; i++) {
                            if (accounts[i].getAccountNum().equals(accountNum)) {
                                accounts[i].inputMoney(input);
                                System.out.println(accounts[i].getAccountNum() + "계좌에 " + input + "원 예금이 성공되었습니다.");
                                System.out.println(accounts[i].getAccountNum() + "계좌의 잔액 : " + accounts[i].getMoney() + "원");
                                System.out.println();
                                break;
                            } else {
                                System.out.println("입력하신 계좌는 없는 계좌입니다.");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("------------------");
                    System.out.println("출금");
                    System.out.println("------------------");
                    System.out.print("계좌번호('-'제외한 숫자만 입력):");
                    accountNum = sc.next();
                    System.out.print("출금액:");
                    output = sc.nextInt();
                    if (accountIndex == 0) {
                        System.out.println("아직 생성된 계좌가 없습니다.");
                    } else {
                        for (int i = 0; i < accountIndex; i++) {
                            if (accounts[i].getAccountNum().equals(accountNum)) {
                                if (accounts[i].getMoney() < output) {
                                    System.out.println("계좌의 잔액이 부족합니다.");
                                } else {
                                    accounts[i].outputMoney(output);
                                    System.out.println(accounts[i].getAccountNum() + "계좌에서 " + output + "원 출금이 성공되었습니다.");
                                    System.out.println(accounts[i].getAccountNum() + "계좌의 잔액 :" + accounts[i].getMoney() + "원");
                                }
                                break;
                            } else {
                                System.out.println("입력하신 계좌는 없는 계좌입니다.");
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    return;
            }
        }
    }

    //메뉴 출력
    public void printHeader() {
        System.out.println("---------------------------------------------");
        System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
        System.out.println("---------------------------------------------");
    }

    //계좌 생성
    public void addAccount() throws Exception {

        System.out.println("------------------");
        System.out.println("계좌생성");
        System.out.println("------------------");

        System.out.print("계좌번호('-'제외한 숫자만 입력):");
        accountNum = sc.next();
        System.out.print("계좌주:");
        accountName = sc.next();
        System.out.print("초기입금액:");
        money = sc.nextInt();

        if (accountArrayList == null) {
            return;
        }
        Account account = new Account(accountNum, accountName, money);
        accountArrayList.add(account);

        System.out.println("결과 : 계좌가 생성되었습니다.");

    }

    //계좌목록
    public void printAccountList(){
        System.out.println("------------------");
        System.out.println("계좌목록");
        System.out.println("------------------");

        if (accountArrayList.isEmpty()) {
            System.out.println("등록된 계좌가 없습니다.");
        }else{
            for (Account accounts : accountArrayList) {
                System.out.print(accounts.getAccountNum()+"\t");
                System.out.print(accounts.getAccountName()+"\t");
                System.out.println(accounts.getMoney());
            }
        }
    }

    //예금
    public void deposit(){
        System.out.println("------------------");
        System.out.println("예금");
        System.out.println("------------------");

        System.out.print("계좌번호('-'제외한 숫자만 입력):");
        accountNum = sc.next();
        System.out.print("예금액:");
        money = sc.nextInt();

        if (accountArrayList.isEmpty()) {
            System.out.println("생성된 계좌가 없습니다.");
        }
        for (int i = 0; i < accountArrayList.size(); i++) {
            if (!(accountNum.equals(accountArrayList.get(i).getAccountNum()))) {
                System.out.println("해당 계좌가 존재하지 않습니다.");
            }else {
                accountArrayList.get(i).inputMoney(money);
                System.out.println("계좌 생성 완료");
            }
        }
    }




}
