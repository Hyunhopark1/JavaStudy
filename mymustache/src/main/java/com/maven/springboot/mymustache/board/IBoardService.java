package com.maven.springboot.mymustache.board;


import com.maven.springboot.mymustache.commons.dto.CUDInfoDto;
import com.maven.springboot.mymustache.SearchAjaxDto;
import com.maven.springboot.mymustache.commons.inif.IServiceCRUD;

import java.util.List;

public interface IBoardService extends IServiceCRUD<IBoard> {
//    void insert(CUDInfoDto info, IBoard dto);
//    void update(CUDInfoDto info, IBoard dto);
//    void deleteFlag(CUDInfoDto info, IBoard dto);
//    void deleteById(Long id);
//    IBoard findById(Long id);
    int countByCreateId(SearchAjaxDto searchDto);
    List<IBoard> findPagesByCreateId(SearchAjaxDto searchDto);

    int countByNameContains(SearchAjaxDto searchDto);
    List<IBoard> findPagesByNameContains(SearchAjaxDto searchDto);

    int countByContentContains(SearchAjaxDto searchDto);
    List<IBoard> findPagesByContentContains(SearchAjaxDto searchDto);
}
