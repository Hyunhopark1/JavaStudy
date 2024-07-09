package com.maven.springboot.rentcar.vehicle;


import com.maven.springboot.rentcar.vehicleType.IVehicleType;


public interface IVehicle {

   public Long getId();
   public void setId(Long id);

   public String getCompany();
   public void setCompany(String company);

   public String getModel();
   public void setModel(String model);

   public int getMakeYear();
   public void setMakeYear(int year);

   public IVehicleType getType();
   public void setType(IVehicleType type);

   public String getColor();
   public void setColor(String color);

   public int getTotalKm();
   public void setTotalKm(int totalKm);

   public String getFactoryNumber();
   public void setFactoryNumber(String factoryNumber);

   public String getRegisterNumber();
   public void setRegisterNumber(String registerNumber);

   public VehicleStatus getStatus();
   public void setStatus(VehicleStatus status);




}
