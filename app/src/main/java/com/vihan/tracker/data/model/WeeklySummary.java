package com.vihan.tracker.data.model;

public class WeeklySummary {

    private int numberOfInfos;
    private int numberOfInvites;
    private int numberOfPlans;
    private int numberOfClosings;
    private int numberOfUv;
    private int weekNumber;

    public int getNumberOfInfos() {
        return numberOfInfos;
    }

    public void setNumberOfInfos(int numberOfInfos) {
        this.numberOfInfos = numberOfInfos;
    }

    public int getNumberOfInvites() {
        return numberOfInvites;
    }

    public void setNumberOfInvites(int numberOfInvites) {
        this.numberOfInvites = numberOfInvites;
    }

    public int getNumberOfPlans() {
        return numberOfPlans;
    }

    public void setNumberOfPlans(int numberOfPlans) {
        this.numberOfPlans = numberOfPlans;
    }

    public int getNumberOfClosings() {
        return numberOfClosings;
    }

    public void setNumberOfClosings(int numberOfClosings) {
        this.numberOfClosings = numberOfClosings;
    }

    public int getNumberOfUv() {
        return numberOfUv;
    }

    public void setNumberOfUv(int numberOfUv) {
        this.numberOfUv = numberOfUv;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }
}
