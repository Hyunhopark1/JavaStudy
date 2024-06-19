package com.maven.springboot.account;

import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {

    private AccountService accountService = new AccountService();

    public static void main(String[] args) throws Exception {
        BankApplication bApp=new BankApplication();
        while (true) {
            bApp.printHeader();
            int choice = bApp.getChoice();
            switch (choice) {
                case 1:
                    bApp.addAccount();
                    break;
                case 2:
                    bApp.showAccounts();
                    break;
                case 3:
                    bApp.income();
                    break;
                case 4:
                    bApp.outcome();
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }

    }
    private void printHeader() {
        System.out.println("============================================");
        System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
        System.out.println("============================================");
    }
    private int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("선택>");
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }
    private void addAccount() {
        Scanner sc = new Scanner(System.in);

        System.out.println("--------");
        System.out.println("계좌생성");
        System.out.println("--------");
        System.out.print("계좌번호:");
        String accountNum = sc.nextLine();
        System.out.print("계좌주:");
        String accountName = sc.nextLine();
        System.out.print("초기입금액:");
        String money = sc.nextLine();
        int m = Integer.parseInt(money);

        if (accountService.addAccount(accountNum, accountName, m)) {
            System.out.println("결과 : 계좌가 생성되었습니다.");
        } else {
            System.out.println("결과 : 계좌 생성 실패");
        }
        
        
    }
    private void showAccounts() {
        System.out.println("--------");
        System.out.println("계좌목록");
        System.out.println("--------");

        ArrayList<Account> list = accountService.getAllAccount();

        for (Account account : list) {
            System.out.println(account.toString());
        }
    }
    private void income() throws Exception {
        System.out.println("--------");
        System.out.println("예금");
        System.out.println("--------");

        Scanner sc = new Scanner(System.in);
        System.out.print("계좌번호: ");
        String accountNum=sc.nextLine();
        System.out.print("예금액: ");
        String money = sc.nextLine();
        int m = Integer.parseInt(money);

        if (accountService.deposit(accountNum, m)) {
            System.out.println(accountNum+"계좌에 "+m+"원 예금 성공");
        }else {
            System.out.println("예금 실패");
        }
    }
    private void outcome() throws Exception {
        System.out.println("--------");
        System.out.println("출금");
        System.out.println("--------");
        Scanner sc = new Scanner(System.in);
        System.out.print("계좌번호: ");
        String accountNum=sc.nextLine();
        System.out.print("출금액: ");
        String money = sc.nextLine();
        int m = Integer.parseInt(money);

        if (accountService.withdraw(accountNum, m)) {
            System.out.println(accountNum+"계좌에서 "+m+"원 출금 성공");
        }else{
            System.out.println("출금 실패");
        }
    }
}
