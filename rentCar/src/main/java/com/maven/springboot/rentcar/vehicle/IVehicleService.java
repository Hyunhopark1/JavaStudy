package com.maven.springboot.rentcar.vehicle;

import java.util.List;

public interface IVehicleService {
    IVehicle addVehicle(IVehicle vehicle);

    boolean removeVehicle(Long id);

    IVehicle updateVehicle(Long id, IVehicle vehicle);

    IVehicle findVehicleById(Long id);

    List<IVehicle> getAllVehicle();



}
