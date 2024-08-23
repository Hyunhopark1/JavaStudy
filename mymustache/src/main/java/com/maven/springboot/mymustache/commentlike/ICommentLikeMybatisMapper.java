package com.maven.springboot.mymustache.commentlike;

import com.maven.springboot.mymustache.commons.inif.IMybatisCRUD;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICommentLikeMybatisMapper extends IMybatisCRUD<CommentLikeDto> {
    void deleteByCommentTableUserBoard(CommentLikeDto dto);
    Integer countByCommentTableUserBoard(CommentLikeDto searchDto);
}
