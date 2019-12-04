package com.vihan.tracker.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.vihan.tracker.TrackerApplication;
import com.vihan.tracker.data.model.WeekLogModel;
import com.vihan.tracker.data.repository.TrackerRepo;

public class DashboardViewModel extends ViewModel {

    private TrackerRepo trackerRepo;

    public DashboardViewModel() {
       trackerRepo = TrackerApplication.getTrackerRepository();
    }

    LiveData<Boolean> insertWeeklyModel(WeekLogModel weekLogModel){
        return trackerRepo.insertWeeklyLog(weekLogModel);
    }

}