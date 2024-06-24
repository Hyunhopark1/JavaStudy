package com.maven.springboot.rentcar.repository;

import com.maven.springboot.rentcar.models.Vehicle;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.util.List;

public interface VehicleRepository {

    boolean save(List<Vehicle> vehicleList) throws Exception;

    boolean load(List<Vehicle> vehicleList);
}
