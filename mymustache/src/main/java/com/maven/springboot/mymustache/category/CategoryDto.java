package com.maven.springboot.mymustache.category;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder    //@Builder는 상속을 못한다. @SuperBuilder는 상속 가능
@NoArgsConstructor   //매개변수 없는 기본생성자 자동생성
@AllArgsConstructor  //모든 매개변수로 생성자 생성


//데이터 전달을 위한 객체
public class CategoryDto implements ICategory {

    private Long id;
    private String name;
}
