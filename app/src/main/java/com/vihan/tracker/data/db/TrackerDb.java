package com.vihan.tracker.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.vihan.tracker.data.Converter;
import com.vihan.tracker.data.dao.TrackerDao;
import com.vihan.tracker.data.model.CallLogModel;
import com.vihan.tracker.data.model.WeekLogModel;

@Database(entities = {CallLogModel.class, WeekLogModel.class},version = 1)
@TypeConverters(value = Converter.class)
public abstract class TrackerDb extends RoomDatabase {
    public abstract TrackerDao getTrackerDao();
}
