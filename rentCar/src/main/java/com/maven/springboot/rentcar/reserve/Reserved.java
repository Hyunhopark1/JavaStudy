package com.maven.springboot.rentcar.reserve;

import com.maven.springboot.rentcar.members.Member;
import com.maven.springboot.rentcar.vehicle.IVehicle;

import java.util.Date;

public class Reserved {
    private IVehicle vehicle;
    private Member member;
    private Date startDate;
    private String startPoint;
    private Date endDate;
    private String endPoint;
    private int money;
    private Date reserveDate;
    private Date untilDate;
    private Date returnDate;
    private Date cancelDate;
    private ReserveStatus status;

    public boolean reserveVehicle(IVehicle vehicle, Member member, Date startDate, String startPoint, Date endDate, String endPoint, int money, Date reserverDate, Date untilDate, ReserveStatus status) {
        return false;
    }

    public boolean reserveVehicle(IVehicle vehicle, Member member, Date startDate, String startPoint, Date endDate, String endPoint, int money, Date reserverDate) {
        return false;
    }

    public boolean cancleVehicle(IVehicle vehicle, Member member, Date cancelDate) {
        return false;
    }
}
