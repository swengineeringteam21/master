package com.example.myapplication;

public class scheduleList {

    String scheduleName;
    String scheduleDate;
    String schedultLocation;

    public scheduleList(String scheduleName, String scheduleDate, String schedultLocation) {
        this.scheduleName = scheduleName;
        this.scheduleDate = scheduleDate;
        this.schedultLocation = schedultLocation;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public String getSchedultLocation() {
        return schedultLocation;
    }
}
