package com.vihan.tracker.enums;

public enum Zone {
    HOT("HOT"),
    OYE_BUDDY("OYE-BUDDY"),
    WARM("WARM"),
    COLD("COLD");
    private String zone;

    Zone(String zone) {
        this.zone = zone;
    }

    public String getZone() {
        return zone;
    }
}
