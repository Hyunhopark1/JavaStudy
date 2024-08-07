package com.maven.springboot.mymustache.board;

import com.maven.springboot.mymustache.SearchAjaxDto;
import com.maven.springboot.mymustache.commons.inif.IMybatisCRUD;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IBoardMybatisMapper extends IMybatisCRUD<BoardDto> {
//    void insert(BoardDto dto);
//    void update(BoardDto dto);
//    void deleteFlag(BoardDto dto);
//    void deleteById(Long id);
//    BoardDto findById(Long id);
    int countByCreateId(SearchAjaxDto searchDto);
    List<BoardDto> findPagesByCreateId(SearchAjaxDto searchDto);

    int countByNameContains(SearchAjaxDto searchDto);
    List<BoardDto> findPagesByNameContains(SearchAjaxDto searchDto);

    int countByContentContains(SearchAjaxDto searchDto);
    List<BoardDto> findPagesByContentContains(SearchAjaxDto searchDto);
}
