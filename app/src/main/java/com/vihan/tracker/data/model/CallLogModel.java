package com.vihan.tracker.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.vihan.tracker.enums.CallType;
import org.threeten.bp.OffsetDateTime;

@Entity
public class CallLogModel {
    @NonNull
    @PrimaryKey private String id;
    @ColumnInfo(name = "Name") private String name;
    @ColumnInfo(name = "Number") private String number;
    @ColumnInfo(name = "Zone") private String zone;
    @ColumnInfo(name = "City") private String city;
    @ColumnInfo(name = "Remarks") private String remarks;
    @ColumnInfo(name = "Date") private OffsetDateTime date;
    @ColumnInfo(name = "Info") private boolean info;
    @ColumnInfo(name = "Invite") private boolean invite;
    @ColumnInfo(name = "PlanDone") private boolean planDone;
    @ColumnInfo(name = "CallType") private CallType callType;
    @ColumnInfo(name = "WeekNumber") private int weekNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public boolean isInfo() {
        return info;
    }

    public void setInfo(boolean info) {
        this.info = info;
    }

    public boolean isInvite() {
        return invite;
    }

    public void setInvite(boolean invite) {
        this.invite = invite;
    }

    public boolean isPlanDone() {
        return planDone;
    }

    public void setPlanDone(boolean planDone) {
        this.planDone = planDone;
    }

    public CallType getCallType() {
        return callType;
    }

    public void setCallType(CallType callType) {
        this.callType = callType;
        if (callType == CallType.INFO){
            setInfo(true);
        }else if (callType == CallType.INVITE){
            setInvite(true);
        }
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CallLogModel copyByUpdatingRemarks(CallLogModel other){
        this.zone = other.zone;
        this.city = other.city;
        this.date=other.date;
        this.callType = other.callType;
        this.remarks += other.remarks;
        return this;
    }
}
