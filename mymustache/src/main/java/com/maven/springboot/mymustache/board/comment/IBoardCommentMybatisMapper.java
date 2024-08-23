package com.maven.springboot.mymustache.board.comment;

import com.maven.springboot.mymustache.commons.dto.SearchAjaxDto;
import com.maven.springboot.mymustache.commons.inif.IMybatisCRUD;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IBoardCommentMybatisMapper extends IMybatisCRUD<BoardCommentDto> {
    void addLikeQty(Long id);
    void subLikeQty(Long id);

    Integer countAllByBoardId(SearchAjaxDto search);
    List<BoardCommentDto> findAllByBoardId(SearchBoardCommentDto dto);
}
