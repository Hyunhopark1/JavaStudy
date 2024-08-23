package com.maven.springboot.mymustache.commentlike;


import com.maven.springboot.mymustache.commons.inif.IServiceCRUD;

public interface ICommentLikeService extends IServiceCRUD<ICommentLike> {
    Boolean deleteByCommentTableUserBoard(CommentLikeDto dto);
    Integer countByCommentTableUserBoard(ICommentLike searchDto);
}
