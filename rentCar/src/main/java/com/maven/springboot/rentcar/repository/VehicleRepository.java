package com.maven.springboot.rentcar.repository;

import com.maven.springboot.rentcar.models.Vehicle;
import org.json.simple.parser.ParseException;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface VehicleRepository {

    boolean save(List<Vehicle> vehicleList) throws Exception;

    boolean load(List<Vehicle> vehicleList) throws IOException, ParseException, Exception;
}
