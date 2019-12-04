package com.vihan.tracker.enums;

public enum City {

    DELHI("Delhi"),
    BANGALORE("Bangalore"),
    PUNE("Pune"),
    LUCKNOW("Lucknow"),
    KANPUR("Kanpur"),
    MUMBAI("Mumbai"),
    BASTI("Basti"),
    KOLKATA("Kolkata"),
    HYDERABAD("Hyderabad"),
    CHENNAI("Chennai"),
    OTHER("OtherCity");

    private String city;

    City(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
