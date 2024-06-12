package com.maven.springboot.study01.mathexam;

public class MemberService {

    public boolean login(String id, String password) {
        if (id.equals("hong") && password.equals("12345")) {
            return true;
        }
        else
            return false;
    }

    public void logout(String id) {
        
    }
}
