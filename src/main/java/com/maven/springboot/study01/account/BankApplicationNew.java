package com.maven.springboot.study01.account;

import com.maven.springboot.study01.account.Account;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class BankApplicationNew {
    private AccountService accountService = new AccountService();

    private void printHeader() {
        System.out.println("========================================================");
        System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료|6.파일읽기|7.파일저장");
        System.out.println("========================================================");
    }

    private int getChoice(Scanner input) throws Exception {
        System.out.print("선택 > ");
        String a = input.nextLine();
        return Integer.parseInt(a);
    }

    private void addAccount(Scanner input) throws Exception {
        System.out.println("--------");
        System.out.println("계좌생성");
        System.out.println("--------");

        System.out.print("계좌번호:");
        String bankNumber = input.nextLine();
        System.out.print("계좌주:");
        String name = input.nextLine();
        System.out.print("초기입금액:");
        String current = input.nextLine();
        int money = Integer.parseInt(current);
        this.accountService.addAccount(new Account(name, bankNumber, money));
    }

    private void printAccounts() {
        for ( Account account : this.accountService.getAllAccount() ) {
            System.out.println(account.toString());
        }
    }

    private void income(Scanner input) throws Exception {
        System.out.println("--------");
        System.out.println("예금");
        System.out.println("--------");

        System.out.print("계좌번호:");
        String bankNumber = input.nextLine();
        System.out.print("예금액:");
        String current = input.nextLine();
        int money = Integer.parseInt(current);

        if ( this.accountService.deposit(bankNumber, money) ) {
            System.out.println("결과: 예금이 성공되었습니다.");
        }
    }

    private void outcome(Scanner input) throws Exception {
        System.out.println("--------");
        System.out.println("출금");
        System.out.println("--------");

        System.out.print("계좌번호:");
        String bankNumber = input.nextLine();
        System.out.print("출금액:");
        String current = input.nextLine();
        int money = Integer.parseInt(current);

        if ( this.accountService.deposit(bankNumber, money) ) {
            System.out.println("결과: 출금이 성공되었습니다.");
        }
    }

    private void loadJson(Scanner input) throws Exception {
        System.out.println("--------");
        System.out.println("파일읽기");
        System.out.println("--------");

        System.out.print("파일이름:");
        String fileName = input.nextLine();

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(fileName, Charset.defaultCharset());
        Object jobj = parser.parse(reader);

        JSONObject jsonObject = (JSONObject) jobj;
        reader.close();
        System.out.print(jsonObject);

        JSONArray jsonArray = (JSONArray) jsonObject.get("accounts");
        this.accountService.clear();
        for ( Object obj : jsonArray ) {
            JSONObject element = (JSONObject)obj;
            String name = (String) element.get("name");
            String bankAccount = (String) element.get("bankAccount");
            Long current = (Long) element.get("current");
            this.accountService.addAccount(new Account(name, bankAccount, current.intValue()));
        }
    }

    private void saveJson(Scanner input) throws Exception {
        System.out.println("--------");
        System.out.println("파일저장");
        System.out.println("--------");

        System.out.print("파일이름:");
        String fileName = input.nextLine();

        JSONArray jsonArray = new JSONArray();
        for ( Account account : this.accountService.getAllAccount() ) {
            JSONObject jobj = new JSONObject();
            jobj.put("name", account.getName());
            jobj.put("bankAccount", account.getBankNumber());
            jobj.put("current", account.getCurrent());
            jsonArray.add(jobj);
        }
        JSONObject jroot = new JSONObject();
        jroot.put("accounts", jsonArray);

        FileWriter fileWriter = new FileWriter(fileName, Charset.defaultCharset());
        fileWriter.write(jroot.toString());
        fileWriter.flush();
        fileWriter.close();
    }

    public static void main(String[] args) {
        try {
            BankApplicationNew bapp = new BankApplicationNew();
            Scanner input = new Scanner(System.in);
            boolean run = true;
            while(run) {
                bapp.printHeader();
                int choice = bapp.getChoice(input);
                switch (choice) {
                    case 1:
                        bapp.addAccount(input);
                        break;
                    case 2:
                        bapp.printAccounts();
                        break;
                    case 3:
                        bapp.income(input);
                        break;
                    case 4:
                        bapp.outcome(input);
                        break;
                    case 5:
                        run = false;
                        break;
                    case 6:
                        bapp.loadJson(input);
                        break;
                    case 7:
                        bapp.saveJson(input);
                        break;
                    default:
                        System.out.println("!!! 잘못된 입력입니다. !!!");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

