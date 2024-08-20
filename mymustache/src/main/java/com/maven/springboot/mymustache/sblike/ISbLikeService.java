package com.maven.springboot.mymustache.sblike;


import com.maven.springboot.mymustache.commons.inif.IServiceCRUD;

public interface ISbLikeService extends IServiceCRUD<ISbLike> {
    Boolean deleteByTableUserBoard(SbLikeDto dto);
    Integer countByTableUserBoard(ISbLike searchDto);
}
