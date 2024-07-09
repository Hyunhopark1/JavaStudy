package com.maven.springboot.rentcar.repository;

import com.maven.springboot.rentcar.vehicle.IVehicle;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface VehicleRepository {

    boolean save(List<IVehicle> vehicleList) throws Exception;

    boolean load(List<IVehicle> vehicleList) throws IOException, ParseException, Exception;
}
