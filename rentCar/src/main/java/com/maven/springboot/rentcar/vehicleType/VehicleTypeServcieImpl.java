package com.maven.springboot.rentcar.vehicleType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeServcieImpl implements IVehicleTypeService {

    @Autowired
    VehicleTypeJpaRepository vehicleTypeJpaRepository;

    @Override
    public IVehicleType findById(Long id) {

        Optional<VehicleTypeEntity> find = vehicleTypeJpaRepository.findById(id);
        return find.orElse(null);
    }

    @Override
    public IVehicleType findByName(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        Optional<VehicleTypeEntity> find = vehicleTypeJpaRepository.findByName(name);
        return find.orElse(null);
    }

    @Override
    public List<IVehicleType> getAllList() {
        List<IVehicleType> list = new ArrayList<>();
        List<VehicleTypeEntity> entityList = vehicleTypeJpaRepository.findAll();
        for (VehicleTypeEntity items : entityList) {
            list.add((VehicleTypeEntity) items);
        }
        return list;
    }

    private boolean isValidInsert(IVehicleType vehicleType) {
        if ( vehicleType == null ) {
            return false;
        } else if ( vehicleType.getName() == null || vehicleType.getName().isEmpty() ) {
            return false;
        }
        return true;
    }

    @Override
    public IVehicleType insert(IVehicleType vehicleType) throws Exception {
        if (!this.isValidInsert(vehicleType)) {
            return null;
        }
        VehicleTypeEntity entity = new VehicleTypeEntity();
        entity.copyFields(vehicleType);

        return vehicleTypeJpaRepository.saveAndFlush(entity);

    }

    @Override
    public IVehicleType update(Long id, IVehicleType vehicleType) throws Exception {
        IVehicleType find = this.findById(id);
        if (find == null) {
            return null;
        }
        find.copyFields(vehicleType);
        VehicleTypeEntity entity = new VehicleTypeEntity();
        entity.copyFields(find);

        return vehicleTypeJpaRepository.saveAndFlush(entity);

    }

    @Override
    public boolean delete(Long id) {
        IVehicleType find = this.findById(id);
        if (find == null) {
            return false;
        }

        VehicleTypeEntity entity = new VehicleTypeEntity();
        entity.copyFields(find);
        vehicleTypeJpaRepository.delete(entity);
        vehicleTypeJpaRepository.flush();
        return true;
    }

    @Override
    public List<IVehicleType> findAllByNameContains(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        List<VehicleTypeEntity> entityList = vehicleTypeJpaRepository.findAllByNameContains(name);
        List<IVehicleType> list =new ArrayList<>();
        for (VehicleTypeEntity items : entityList) {
            list.add((VehicleTypeEntity) items);
        }
        return list;
    }


}
