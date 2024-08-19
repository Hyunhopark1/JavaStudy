package com.maven.springboot.mymustache.boardlike;


import com.maven.springboot.mymustache.commons.inif.IServiceCRUD;

public interface IBoardLikeService extends IServiceCRUD<IBoardLike> {
    Boolean deleteByTableUserBoard(BoardLikeDto dto);
    Integer countByTableUserBoard(IBoardLike searchDto);
}
