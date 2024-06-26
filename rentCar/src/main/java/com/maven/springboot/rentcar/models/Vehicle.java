package com.maven.springboot.rentcar.models;

import com.maven.springboot.rentcar.models.VehicleStatus;
import com.maven.springboot.rentcar.models.VehicleType;
import lombok.Getter;
import lombok.Setter;


public interface Vehicle {


    public Long getId();
    public String getCompany();
    public String getModel();
    public int getMakeYear();
    public VehicleType getType();
    public String getColor();
    public int getTotalKm();
    public String getFactoryNumber();
    public String getRegistNumber();
    public VehicleStatus getStatus();


    public void setid(String id);
    public void setCompany(String company);
    public void setModel(String model);
    public void setmakeYear(int makeYear);
    public void setType(VehicleType type);
    public void setColor(String color);
    public void setTotalKm(int totalKm);
    public void setFactoryNumber(String factoryNumber);
    public void setregisterNumber(String registerNumber);
    public void setStatus(VehicleStatus status);

}
