package com.vihan.tracker.enums;

public enum CallType {
    INFO("Info"),
    INVITE("Invite"),
    CONNECT_UP("ConnectUp"),
    PROSPECTING("Prospecting"),
    EDIFICATION("Edification"),
    CLOSING("Closing");

    private String callType;

    CallType(String callType) {
        this.callType=callType;
    }

    public String getCallType() {
        return callType;
    }
}
