package com.softagape.mustacheajax.board;

import com.softagape.mustacheajax.commons.dto.SearchAjaxDto;
import com.softagape.mustacheajax.commons.inif.IServiceCRUD;

import java.util.List;

public interface IBoardService extends IServiceCRUD<IBoard> {
    int countByCreateId(SearchAjaxDto searchDto);
    List<IBoard> findPagesByCreateId(SearchAjaxDto searchDto);

    int countByNameContains(SearchAjaxDto searchDto);
    List<IBoard> findPagesByNameContains(SearchAjaxDto searchDto);

    int countByContentContains(SearchAjaxDto searchDto);
    List<IBoard> findPagesByContentContains(SearchAjaxDto searchDto);
}
