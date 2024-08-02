package com.maven.springboot.mymustache.category;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;



// Mybatis 쿼리를 선언한 xml 파일의 함수와 연결된다.
//<mapper namespace> 에 클래스 경로
//각 쿼리태그의 id에 메소드명
//각 쿼리태그의 parameterType에 파라미터 타입
//각 쿼리태그의 returnType에 리턴 타입
@Mapper
// Mybatis 쿼리를 선언한 xml 파일의 함수와 연결한다.
public interface CategoryMybatisMapper {
    void insert(CategoryDto dto);

    void update(CategoryDto dto);

    void deleteById(Long id);

    CategoryDto findById(long id);

    CategoryDto findByName(String name);

    List<CategoryDto> findAll();

    int countAllByNameContains(SearchCategoryDto searchCategoryDto);
    List<CategoryDto> findAllByNameContains(SearchCategoryDto searchCategoryDto);
}
