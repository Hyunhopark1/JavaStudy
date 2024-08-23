package com.maven.springboot.mymustache.board.comment;


import com.maven.springboot.mymustache.commons.dto.CUDInfoDto;
import com.maven.springboot.mymustache.commons.dto.SearchAjaxDto;
import com.maven.springboot.mymustache.commons.inif.IServiceCRUD;
import com.maven.springboot.mymustache.member.IMember;

import java.util.List;

public interface IBoardCommentService extends IServiceCRUD<BoardCommentDto> {
    void addLikeQty(CUDInfoDto cudInfoDto, Long id);
    void subLikeQty(CUDInfoDto cudInfoDto, Long id);

    Integer countAllByBoardId(SearchAjaxDto search);
    List<BoardCommentDto> findAllByBoardId(IMember loginUser, SearchBoardCommentDto dto);
}
