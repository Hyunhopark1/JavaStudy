package com.maven.springboot.mymustache.board;


import com.maven.springboot.mymustache.commons.dto.CUDInfoDto;
import com.maven.springboot.mymustache.commons.dto.SearchAjaxDto;
import com.maven.springboot.mymustache.commons.inif.IServiceCRUD;

import java.util.List;

public interface IBoardService extends IServiceCRUD<BoardDto> {
    void addViewQty(Long id);
    void addLikeQty(Long id);

    Integer countAllByNameContains(SearchAjaxDto searchAjaxDto);
    List<BoardDto> findAllByNameContains(SearchAjaxDto searchAjaxDto);
}
