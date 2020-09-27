package com.example.fleetmanagementsystem.driverFunctionality.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.example.fleetmanagementsystem.carsFunctionality.models.CarHistoryModel;

public class DriverHistoryModel implements Serializable {
    String carId,carName,startDate,endDate;

    public DriverHistoryModel(){}

    public DriverHistoryModel(String carId, String carName) {
        this.carId = carId;
        this.carName = carName;
        this.startDate = CarHistoryModel.getCurrentDateAndTime();
        this.endDate = "Currently Assigned";
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
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
        this.endDate = CarHistoryModel.getCurrentDateAndTime();
    }
}
