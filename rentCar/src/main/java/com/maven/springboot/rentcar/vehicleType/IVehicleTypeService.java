package com.maven.springboot.rentcar.vehicleType;

import java.util.List;

public interface IVehicleTypeService {
    IVehicleType findById(Long id);


    IVehicleType findByName(String name);

    //모든 리스트 출력
    List<IVehicleType> getAllList();

    //데이터 추가
    IVehicleType insert(IVehicleType vehicleType) throws Exception;

    //데이터 삭제
    boolean delete(Long id);

    //데이터 수정
    IVehicleType update(Long id, IVehicleType vehicleType) throws Exception;

    //이름이 포함된 리스트 출력
    List<IVehicleType> findAllByNameContains(String name);
}
