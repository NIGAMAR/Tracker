package com.vihan.tracker;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.vihan.tracker.data.db.TrackerDb;
import com.vihan.tracker.data.repository.TrackerRepo;
import com.vihan.tracker.data.repository.TrackerRepoImpl;

public class TrackerApplication extends Application {

    private static TrackerRepo trackerRepository;
    @Override
    public void onCreate() {
        super.onCreate();
        trackerRepository = TrackerRepoImpl.instantiateTrackerRepository(this);
        AndroidThreeTen.init(this);
    }

    public static TrackerRepo getTrackerRepository() {
        return trackerRepository;
    }

}
