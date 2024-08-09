package com.softagape.mustacheajax.commons.inif;

import com.softagape.mustacheajax.commons.dto.CUDInfoDto;

public interface IServiceCRUD<T> {
    void insert(CUDInfoDto info, T dto);
    void update(CUDInfoDto info, T dto);
    void deleteFlag(CUDInfoDto info, T dto);
    void deleteById(Long id);
    T findById(Long id);
}
