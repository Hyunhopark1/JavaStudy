package com.maven.springboot.mymustache.sblike;

import com.maven.springboot.mymustache.commons.inif.IMybatisCRUD;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ISbLikeMybatisMapper extends IMybatisCRUD<SbLikeDto> {
    void deleteByTableUserBoard(SbLikeDto dto);
    Integer countByTableUserBoard(SbLikeDto searchDto);
}