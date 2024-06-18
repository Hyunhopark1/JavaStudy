package com.maven.springboot.rentcar.models;

public class Car implements Vehicle {

    public Long id;
    public String company;
    public String model;
    public int makeYear;
    public VehicleType type;
    public String color;
    public int totalKm;
    public String factoryNumber;
    public String registNumber;

    @Override
    public Long getId() {
        return 0L;
    }

    @Override
    public String getCompany() {
        return "";
    }

    @Override
    public String getModel() {
        return "";
    }

    @Override
    public int getMakeYear() {
        return 0;
    }

    @Override
    public VehicleType getType() {
        return null;
    }

    @Override
    public String getColor() {
        return "";
    }

    @Override
    public int getTotalKM() {
        return 0;
    }

    @Override
    public String getFactoryNumber() {
        return "";
    }

    @Override
    public String getRegistNumber() {
        return "";
    }

    @Override
    public VehicleStatus getStatus() {
        return null;
    }

    @Override
    public Long getDriver() {
        return 0L;
    }

    @Override
    public String reserve() {
        return "";
    }

    @Override
    public String cancel() {
        return "";
    }

    @Override
    public String rentVehicle() {
        return "";
    }

    @Override
    public String returnVehicle() {
        return "";
    }
}
