package com.maven.springboot.rentcar.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MotorCycle implements Vehicle{

    private Long id ;
    private String  company;
    private String  model;
    private String  makeYear;
    private VehicleType type;
    private String color;
    private int totalKm;
    private String factoryNumber;
    private String registNumber;
    private VehicleStatus status;


}
