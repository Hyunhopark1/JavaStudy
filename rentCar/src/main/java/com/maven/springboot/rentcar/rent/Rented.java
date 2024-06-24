package com.maven.springboot.rentcar.rent;

import com.maven.springboot.rentcar.members.Member;
import com.maven.springboot.rentcar.models.Vehicle;
import com.maven.springboot.rentcar.reserve.Reserved;

import java.util.Date;

public class Rented {
    private Vehicle vehicle;
    private Member member;
    private Date startDate;
    private String startPoint;
    private Date endDate;
    private String endPoint;
    private int money;
    private Date rentDate;
    private Date returnDate;
    private Date brokenDate;
    private RentStatus status;
    private Reserved reserved;

    public boolean rentVehicle(Vehicle vehicle, Member member, Date startDate, String startPoint, int money, Date rentDate, RentStatus status) {
        return false;
    }

    public boolean returnVehicle(Vehicle vehicle, Member member, Date endDate, String endPoint, Date returnDate) {
        return false;
    }

    public boolean brokenVehicle(Vehicle vehicle, Member member, Date brokenDate) {
        return false;
    }
}
