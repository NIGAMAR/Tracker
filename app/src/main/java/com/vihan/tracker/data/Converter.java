package com.vihan.tracker.data;

import androidx.room.TypeConverter;

import com.vihan.tracker.enums.CallType;

import org.threeten.bp.OffsetDateTime;


public class Converter {

    @TypeConverter
    public static String dateToDbText(OffsetDateTime dateTime){
        return dateTime.toString();
    }

    @TypeConverter
    public static OffsetDateTime dbTextToDate(String dateTime){
        return OffsetDateTime.parse(dateTime);
    }

    @TypeConverter
    public static String callTypeToDbText(CallType callType){
        return callType.getCallType();
    }

    @TypeConverter
    public static CallType dbTextToCallType(String callType){
        return CallType.valueOf(callType);
    }

}
