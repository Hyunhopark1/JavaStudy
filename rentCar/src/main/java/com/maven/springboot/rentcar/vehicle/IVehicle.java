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

   default void copyFields(IVehicle from) {
      if ( from == null ) {
         return;
      }
      if ( from.getId() != null ) {
         this.setId(from.getId());
      }
      if (from.getCompany() != null && !from.getCompany().isEmpty()) {
         this.setCompany(from.getCompany());
      }
      if (from.getModel() != null && !from.getModel().isEmpty()) {
         this.setModel(from.getModel());
      }
      if (from.getMakeYear()>=0) {
         this.setMakeYear(from.getMakeYear());
      }if (from.getType() != null) {
         this.setType(from.getType());
      }
      if (from.getColor() != null && !from.getColor().isEmpty()) {
         this.setColor(from.getColor());
      } if (from.getTotalKm()>=0) {
         this.setTotalKm(from.getTotalKm());
      }if (from.getFactoryNumber() != null && !from.getFactoryNumber().isEmpty()) {
         this.setFactoryNumber(from.getFactoryNumber());
      }if (from.getRegisterNumber() != null && !from.getRegisterNumber().isEmpty()) {
         this.setRegisterNumber(from.getRegisterNumber());
      }if (from.getStatus() != null) {
         this.setStatus(from.getStatus());
      }

   }


}
