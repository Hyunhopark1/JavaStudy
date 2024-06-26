package com.maven.springboot.sbtest;


import lombok.*;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PhoneBook implements IPhoneBook {

    private Long id;
    private String name;
    private EPhoneGroup group;
    private String phoneNumber;
    private String email;



    @Override
    public String toString() {
        return String.format("ID : %6d,  이름 : %s, 그룹 : %s, 전화번호 : %s, 이메일 : %s",
                this.id, this.name, this.group, this.phoneNumber, this.email);
    }

}
