package com.maven.springboot.mymustache.commons.inif;


import com.maven.springboot.mymustache.commons.dto.CUDInfoDto;

public interface IServiceCRUD<T> {
    void insert(CUDInfoDto info, T dto);
    void update(CUDInfoDto info, T dto);
    void deleteFlag(CUDInfoDto info, T dto);
    void deleteById(Long id);
    T findById(Long id);
}
