package com.maven.springboot.sbtest;



import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleApplication {

    private IPhoneBookService<IPhoneBook> phoneBookService;

    public void setPhoneBookService(IPhoneBookService<IPhoneBook> phoneBookService) throws Exception {

        this.phoneBookService = phoneBookService;
        this.phoneBookService.loadData();
    }

    public ConsoleApplication() {

    }

    public void printTitle() {
        System.out.println("============================================================================");
        System.out.println("1.연락처생성|2.목록|3.수정|4.삭제|5.이름검색|6.그룹검색|7.폰검색|8.이메일검색|9.종료");
        System.out.println("============================================================================");
    }

    public int getChoice(Scanner input) throws Exception {
        System.out.print("선택 > ");
        String a = input.nextLine();
        return Integer.parseInt(a);
    }

    public void printList() {
        
        this.printList("",this.phoneBookService.getAllList());
    }

    private void printList(String title,List<IPhoneBook> array) {
        if (array.isEmpty()) {
            System.out.println(title+" 연락처가 없습니다");
        }
        System.out.println("===========연락처 목록 ===========");
        for (IPhoneBook object : array) {
            System.out.println(object.toString());
        }
    }

    private EPhoneGroup getGroupFromScanner(Scanner input, String title) {
        boolean doWhile = false;
        EPhoneGroup eGroup = EPhoneGroup.Friends;
        do {
            System.out.print(title + "연락처 그룹{Friends(1),Families(2),Schools(3),Jobs(4),Hobbies(5)} :");
            String group = input.nextLine();
            switch (group) {
                case "1":
                    eGroup = EPhoneGroup.Friends;
                    doWhile = false;
                    break;
                case "2":
                    eGroup = EPhoneGroup.valueOf("Families");
                    doWhile = false;
                    break;
                case "3":
                    eGroup = EPhoneGroup.Schools;
                    doWhile = false;
                    break;
                case "4":
                    eGroup = EPhoneGroup.Jobs;
                    doWhile = false;
                    break;
                case "5":
                    eGroup = EPhoneGroup.Hobbies;
                    doWhile = false;
                    break;
                default:
                    doWhile = true;
                    System.out.println("Friends(1),Families(2),Schools(3),Jobs(4),Hobbies(5) 1~5사이에 입력");
                    break;
            }
        } while (doWhile);
        return eGroup;
    }private EPhoneGroup getUpdateGroupFromScanner(Scanner input, String title) {
        boolean doWhile = false;
        EPhoneGroup eGroup = EPhoneGroup.Friends;
        do {
            System.out.print(title + " 연락처 그룹{Friends(1),Families(2),Schools(3),Jobs(4),Hobbies(5)} 선택:");
            String group = input.nextLine();
            switch (group) {
                case "1":
                    eGroup = EPhoneGroup.Friends;
                    doWhile = false;
                    break;
                case "2":
                    eGroup = EPhoneGroup.valueOf("Families");
                    doWhile = false;
                    break;
                case "3":
                    eGroup = EPhoneGroup.Schools;
                    doWhile = false;
                    break;
                case "4":
                    eGroup = EPhoneGroup.Jobs;
                    doWhile = false;
                    break;
                case "5":
                    eGroup = EPhoneGroup.Hobbies;
                    doWhile = false;
                    break;
                case "":
                    eGroup = null;
                    doWhile = false;
                    break;
                default:
                    doWhile = true;
                    System.out.println("Friends(1),Families(2),Schools(3),Jobs(4),Hobbies(5) 1~5사이에 입력");
                    break;
            }
        } while (doWhile);
        return eGroup;
    }

    public void insert(Scanner input) throws Exception {
        System.out.println("--------");
        System.out.println("연락처 생성");
        System.out.println("--------");
        System.out.print("연락처 이름 :");
        String name = input.nextLine();
        EPhoneGroup group = this.getGroupFromScanner(input, "");
        String phone = this.phoneValidity(input);
        String email = this.emailValidity(input);

        try {
            if (this.phoneBookService.insert(name, group, phone, email)) {
                this.phoneBookService.saveData();
                System.out.println("결과: 데이터 추가 성공되었습니다.");
            } else {
                System.out.println("결과 : 데이터 추가 실패되었습니다.");
            }
        } catch (Exception e) {
            System.out.println("데이터 추가 실패 : "+e.getMessage());
        }
    }
    //전화번호가 빈 값이 아니고 형식에 맞지 않으면 다시 입력
    private String phoneValidity(Scanner input) {

        boolean phoneNotVal=false;
        String phoneNumberPattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
        String phone;
        do {
            System.out.print("전화번호 [ 000 - 000(0) - 0000 ] 형식으로 입력 :");
            phone = input.nextLine();
            if (!(Pattern.matches(phoneNumberPattern, phone))&&!phone.isEmpty()) {
                phoneNotVal=true;
                System.out.println("전화번호 형식 오류 : 다시 입력해 주세요");
            }else {
                phoneNotVal=false;
            }
        }while (phoneNotVal);
        return phone;
    }

    //이메일이 빈 값이 아니고 형식에 맞지 않으면 다시 입력
    private String emailValidity(Scanner input) {

        boolean emailNotVal = false;
        String emailPattern = ".+@.+";
        String email;
        do {
            System.out.print("이메일 [ 문자 @ 문자 ] 형식으로 입력 :");
            email = input.nextLine();
            if (!(Pattern.matches(emailPattern, email))&&!email.isEmpty()) {
                emailNotVal = true;
                System.out.println("이메일 형식 오류 : 다시 입력해 주세요");
            } else {
                emailNotVal = false;
            }
        } while (emailNotVal);
        return email;
    }


    public void update(Scanner input) throws Exception {
        System.out.println("===========================================================");
        System.out.println("연락처 수정 : 수정을 원치 않는 정보는 엔터키를 눌러 다음으로 넘겨주세요");
        System.out.println("===========================================================");
        IPhoneBook result = getFindIdConsole(input, "수정할");
        if (result == null) {
            System.out.println("에러: ID 데이터 가 존재하지 않습니다.");
            return;
        }
        System.out.print("[ 기존 이름 : "+ result.getName() +" ] -> 수정할 이름 :");
        String name = input.nextLine();

        System.out.println("[ 기존 그룹 : "+result.getGroup()  +"]");
        EPhoneGroup group = this.getUpdateGroupFromScanner(input, "수정할");

        System.out.print("[ 기존 전화번호 : : "+ result.getPhoneNumber() +" ] -> 수정할 전화번호 :");
        String phone = this.phoneValidity(input);

        System.out.print("[ 기존 이메일 : "+ result.getEmail() +" ] -> 수정할 이메일 :");
        String email = this.emailValidity(input);

        IPhoneBook update = PhoneBook.builder()
                .id(result.getId()).name(name)
                .group(group)
                .phoneNumber(phone).email(email).build();
        if (this.phoneBookService.update(update.getId(),result, update)) {
            this.phoneBookService.saveData();
            System.out.println("결과: 데이터 수정 성공되었습니다.");
        }
    }

    public void delete(Scanner input) throws Exception {

        IPhoneBook result = getFindIdConsole(input, "삭제할");
        if (result == null) {
            System.out.println("에러: ID 데이터 가 존재하지 않습니다.");
            return;
        }
        if (this.phoneBookService.remove(result.getId())) {
            this.phoneBookService.saveData();
            System.out.println("결과: 데이터 삭제 성공되었습니다.");
        } else {
            System.out.println("결과: 데이터 삭제 실패되었습니다.");
        }
    }

    private IPhoneBook getFindIdConsole(Scanner input, String title) {
        long l = 0L;
        do {
            System.out.print(title + " ID 번호:");
            String id = input.nextLine();
            try {
                l = Long.parseLong(id);
            } catch (Exception ex) {
                System.out.println("ID 번호를 숫자로만 입력하세요.");
            }
        } while ( l <= 0 );
        IPhoneBook iPhoneBook = (IPhoneBook)this.phoneBookService.findById(l);
        return iPhoneBook;
    }

    public void searchByName(Scanner input) {
        boolean nameVal=false;
        String name;
        do {
            System.out.print("찾을 이름 :");
            name = input.nextLine();
            nameVal=false;

            if (name == null || name.isEmpty()) {
                nameVal=true;
                System.out.println("이름을 입력해 주세요");
            }
        } while (nameVal);

        List<IPhoneBook> list = this.phoneBookService.getListFromName(name);
        System.out.println("==========["+name+"]이 포함된 연락처를 모두 표시합니다==========");
        this.printList("해당하는",list);
    }

    public void searchByGroup(Scanner input) {
        EPhoneGroup group = this.getGroupFromScanner(input, "찾을 ");

        List<IPhoneBook> list = this.phoneBookService.getListFromGroup(group);
        System.out.println("========== ["+group+"] 그룹에 포함된 연락처를 모두 표시합니다==========");
        this.printList("해당하는",list);
    }

    public void searchByPhone(Scanner input) {
        boolean phoneVal=false;
        String phone;
        do {
            System.out.print("찾을 번호 :");
            phone = input.nextLine();
            phoneVal=false;

            if (phone == null || phone.isEmpty()) {
                phoneVal=true;
                System.out.println("전화번호를 입력해 주세요");
            }
        } while (phoneVal);

        List<IPhoneBook> list = this.phoneBookService.getListFromPhoneNumber(phone);
        System.out.println("==========["+phone+"]이 포함된 연락처를 모두 표시합니다==========");
        this.printList("해당하는",list);

    }

    public void searchByEmail(Scanner input) {
        boolean emailVal=false;
        String email;
        do {
            System.out.print("찾을 Email :");
            email = input.nextLine();
            emailVal=false;

            if (email == null || email.isEmpty()) {
                emailVal=true;
                System.out.println("이메일을 입력해 주세요");
            }
        } while (emailVal);

        List<IPhoneBook> list = this.phoneBookService.getListFromEmail(email);
        System.out.println("==========["+email+"]이 포함된 연락처를 모두 표시합니다==========");
        this.printList("해당하는",list);
    }
}