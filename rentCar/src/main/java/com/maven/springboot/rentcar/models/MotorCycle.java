package com.maven.springboot.rentcar.models;

import com.maven.springboot.rentcar.vehicle.IVehicle;
import com.maven.springboot.rentcar.vehicle.VehicleStatus;
import com.maven.springboot.rentcar.vehicleType.IVehicleType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MotorCycle implements IVehicle {

    private Long id ;
    private String  company;
    private String  model;
    private int  makeYear;
    private IVehicleType type;
    private String color;
    private int totalKm;
    private String factoryNumber;
    private String registerNumber;
    private VehicleStatus status;


}
