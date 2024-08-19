package com.maven.springboot.mymustache.boardlike;


import com.maven.springboot.mymustache.commons.inif.IMybatisCRUD;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBoardLikeMybatisMapper extends IMybatisCRUD<BoardLikeDto> {
    void deleteByTableUserBoard(BoardLikeDto dto);
    Integer countByTableUserBoard(BoardLikeDto searchDto);
}
