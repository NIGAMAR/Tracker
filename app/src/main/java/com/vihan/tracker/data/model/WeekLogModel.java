package com.vihan.tracker.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WeekLogModel {
    @PrimaryKey @NonNull private String id;
    @ColumnInfo(name = "SystemCount") private int systemCount;
    @ColumnInfo(name="Uvs") private int businessVolume;
    @ColumnInfo(name = "ExpectedClosing") private int expectedClosing;
    @ColumnInfo(name = "ClosingHappened") private int numberOfClosingHappened;
    @ColumnInfo(name = "WeekNumber") private int weekNumber;

    public int getSystemCount() {
        return systemCount;
    }

    public void setSystemCount(int systemCount) {
        this.systemCount = systemCount;
    }

    public int getBusinessVolume() {
        return businessVolume;
    }

    public void setBusinessVolume(int businessVolume) {
        this.businessVolume = businessVolume;
    }

    public int getExpectedClosing() {
        return expectedClosing;
    }

    public void setExpectedClosing(int expectedClosing) {
        this.expectedClosing = expectedClosing;
    }

    public int getNumberOfClosingHappened() {
        return numberOfClosingHappened;
    }

    public void setNumberOfClosingHappened(int numberOfClosingHappened) {
        this.numberOfClosingHappened = numberOfClosingHappened;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }
}
