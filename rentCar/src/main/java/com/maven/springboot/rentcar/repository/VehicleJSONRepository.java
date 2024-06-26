package com.maven.springboot.rentcar.repository;

import com.maven.springboot.rentcar.models.Vehicle;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class VehicleJSONRepository implements VehicleRepository {

    @Override
    public boolean save(List<Vehicle> vehicleList) throws Exception {

        if (vehicleList == null) {
            return false;
        }
        JSONArray jsonArray = new JSONArray();
        for (Vehicle vehicle : vehicleList) {
            JSONObject jobj = new JSONObject();
            jobj.put("id", vehicle.getId());
            jobj.put("company", vehicle.getCompany());
            jobj.put("model", vehicle.getModel());
            jobj.put("makeYear", vehicle.getMakeYear());
            jobj.put("type", vehicle.getType());
            jobj.put("color", vehicle.getColor());
            jobj.put("totalKm", vehicle.getTotalKm());
            jobj.put("factoryNumber", vehicle.getFactoryNumber());
            jobj.put("registerNumber", vehicle.getRegistNumber());
            jobj.put("status", vehicle.getStatus());
            jsonArray.add(jobj);
        }

        JSONObject jroot = new JSONObject();
        jroot.put("vehicles", jsonArray);

        try {
            FileWriter fileWriter = new FileWriter("a", Charset.defaultCharset());
            fileWriter.write(jroot.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return false;
    }
    @Override
    public boolean load(List<Vehicle> vehicleList) throws Exception {
        if (vehicleList == null) {
            return false;
        }
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("a", Charset.defaultCharset());
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

        return false;
    }
}
