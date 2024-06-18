package com.maven.springboot.rentcar.models;

import com.maven.springboot.rentcar.models.VehicleStatus;
import com.maven.springboot.rentcar.models.VehicleType;

public interface Vehicle {


    public Long getId();
    public String getCompany();
    public String getModel();
    public int getMakeYear();
    public VehicleType getType();
    public String getColor();
    public int getTotalKM();
    public String getFactoryNumber();
    public String getRegistNumber();
    public VehicleStatus getStatus();
    public Long getDriver();
    public String reserve();
    public String cancel();
    public String rentVehicle();
    public String returnVehicle();

}
