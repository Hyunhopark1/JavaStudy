package com.maven.springboot.account3;

import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountJSONRepositoryTest {

    @Test
    public void JsonToObject() throws Exception {
        //given 초기값을 준다
        String json = "{\"bankAccount\" : \"11111\", \"current\":70000, \"name\":\"aaaaa\"}";
        //when 테스트할 값을 만든다
        //String 문자열을 JSON객체로 변환한다

        JSONParser jsonParser = new JSONParser();
        Account account;
        try {
            Object obj =jsonParser.parse(json);
            account = getAccountFromJson((JSONObject)obj);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }



    }

    private Account getAccountFromJson(JSONObject jsonObject) throws Exception {
        if (jsonObject == null) {
            throw new Exception("jsonObject is null error");
        }
        Account account = new Account();
        account.setName((String)jsonObject.get("name"));
        account.setBankNumber((String)jsonObject.get("bankNumber"));
        account.setCurrent( ((Long) jsonObject.get("current")).intValue());

        return account;
    }

    public void ObjectToJsonTest() throws Exception {
        // given 초기값을 준다
        Account account = new Account("asdas", "1111", 123123);
        //when 테스트할 값을 만든다.
        String str = "";
        try{
            JSONObject jsonObject = getJsonFromObject(account);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = getJsonFromObject(account);



    }

    private JSONObject getJsonFromObject(Account account) throws Exception {
        if (account == null) {
            throw new Exception("account is null error");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", account.getName());
        jsonObject.put("bankNumber", account.getBankNumber());
        jsonObject.put("current", account.getCurrent());

        return jsonObject;
    }

    public void loadJson() {

    }

}