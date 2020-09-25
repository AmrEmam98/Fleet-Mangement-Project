package com.example.fleetmanagementsystem.carsFunctionality.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CarHistoryModel implements Serializable {
     String driverId,driverName,startDate,endDate;

    public CarHistoryModel() {
    }

    public CarHistoryModel(String driverId, String driverName) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.startDate = getCurrentDateAndTime();
        endDate="Currently Assigned";
    }
    private String getCurrentDateAndTime(){

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = simpleDateFormat.format(c);
        return formattedDate;
    }
    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate() {
        this.endDate = getCurrentDateAndTime();
    }
}
