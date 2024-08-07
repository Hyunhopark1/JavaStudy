package com.maven.springboot.mymustache.category;

import com.maven.springboot.mymustache.ICommonService;
import com.maven.springboot.mymustache.SearchAjaxDto;

import java.util.List;

public interface ICategoryService<T> extends ICommonService<T> {
    ICategory findByName(String name);
    List<ICategory> findAllByNameContains(SearchAjaxDto dto);
    int countAllByNameContains(SearchAjaxDto searchAjaxDto);
}
