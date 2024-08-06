package com.maven.springboot.mymustache.category;

import java.util.List;


public interface ICategoryService<T> {
    T findById(Long id);
    List<T> getAllList();
    T insert(T dto) throws Exception;
    Boolean delete(Long id) throws Exception;
    T update(Long id, T dto) throws Exception;
    ICategory findByName(String name);
    List<ICategory> findAllByNameContains(SearchCategoryDto dto);
    int countAllByNameContains(SearchCategoryDto searchCategoryDto);
}
