package com.vihan.tracker.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.vihan.tracker.TrackerApplication;
import com.vihan.tracker.data.model.CallLogModel;
import com.vihan.tracker.data.repository.TrackerRepo;

public class HomeViewModel extends ViewModel {

    private TrackerRepo trackerRepo;

    public HomeViewModel() {
        trackerRepo = TrackerApplication.getTrackerRepository();
    }

    LiveData<Boolean> saveCallLog(CallLogModel callLogModel){
        return trackerRepo.insertCallLog(callLogModel);
    }
}