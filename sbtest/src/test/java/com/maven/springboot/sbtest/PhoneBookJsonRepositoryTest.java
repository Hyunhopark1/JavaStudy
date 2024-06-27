package com.maven.springboot.sbtest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;


class PhoneBookJsonRepositoryTest {


    @Test
    public void jsonRepositoryTest() throws Exception {

        PhoneBookJsonRepository repository=new PhoneBookJsonRepository("test.json");

        String json="{\"phoneNumber\":\"111111111\",\"name\":\"홍길동\",\"id\":1,\"email\":\"eiskd@gmail.com\",\"group\":\"Friends\"}";

        JSONParser jsonParser = new JSONParser();
        IPhoneBook phoneBook=null;

        Object obj = jsonParser.parse(json);
        phoneBook = repository.getObjectFromJson((JSONObject) obj);

        assertThat(phoneBook.getId()).isEqualTo(1L);
        assertThat(phoneBook.getName()).isEqualTo("홍길동");
        assertThat(phoneBook.getGroup()).isEqualTo(EPhoneGroup.Friends);
        assertThat(phoneBook.getEmail()).isEqualTo("eiskd@gmail.com");
        assertThat(phoneBook.getPhoneNumber()).isEqualTo("111111111");


        IPhoneBook phoneBook2 = new PhoneBook();
        phoneBook2.setId(2L);
        phoneBook2.setName("폰북");
        phoneBook2.setGroup(EPhoneGroup.Hobbies);
        phoneBook2.setPhoneNumber("1111-3333");
        phoneBook2.setEmail("asdasdas@naver.com");

        JSONObject jobject = repository.getJsonFromObject(phoneBook2);

        assertThat((Long)jobject.get("id")).isEqualTo(2L);
        assertThat((String)jobject.get("name")).isEqualTo("폰북");
        assertThat(EPhoneGroup.valueOf((String)jobject.get("group"))).isEqualTo(EPhoneGroup.Hobbies);
        assertThat((String)jobject.get("phoneNumber")).isEqualTo("1111-3333");
        assertThat((String)jobject.get("email")).isEqualTo("asdasdas@naver.com");

    }
    @Test
    public void textRepositoryTest() throws Exception {

        PhoneBookTextRepository repository = new PhoneBookTextRepository("text.txt");

        String str = "1 길길동 Friends 12341234 askie@gis.com";


        IPhoneBook phoneBook = repository.getObjectFromText(str);

        assertThat(phoneBook.getId()).isEqualTo(1L);
        assertThat(phoneBook.getName()).isEqualTo("길길동");
        assertThat(phoneBook.getGroup()).isEqualTo(EPhoneGroup.Friends);
        assertThat(phoneBook.getPhoneNumber()).isEqualTo("12341234");
        assertThat(phoneBook.getEmail()).isEqualTo("askie@gis.com");

        System.out.println("텍스트 -> 폰북 통과");

        IPhoneBook phoneBook2 = new PhoneBook();
        phoneBook2.setId(10L);
        phoneBook2.setName("김길수");
        phoneBook2.setGroup(EPhoneGroup.Families);
        phoneBook2.setPhoneNumber("123123");
        phoneBook2.setEmail("aaa@naver.com");

        String str2 = repository.getTextFromObject(phoneBook2);
        assertThat(str2).isEqualTo("10 김길수 Families 123123 aaa@naver.com\n");

        String[] items = str2.split(" ");
        assertThat(Long.parseLong(items[0])).isEqualTo(10L);
        assertThat(items[1]).isEqualTo("김길수");
        assertThat(EPhoneGroup.valueOf(items[2])).isEqualTo(EPhoneGroup.Families);
        assertThat(items[3]).isEqualTo("123123");
        assertThat(items[4]).isEqualTo("aaa@naver.com\n");

        System.out.println("폰북 -> 텍스트 통과");
    }

}