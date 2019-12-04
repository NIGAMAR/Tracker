package com.vihan.tracker.data.repository;

import androidx.lifecycle.LiveData;

import com.vihan.tracker.data.model.CallLogModel;
import com.vihan.tracker.data.model.WeekLogModel;
import com.vihan.tracker.data.model.WeeklySummary;

public interface TrackerRepo {
    LiveData<WeeklySummary> getWeeklySummary(int weekNumber);
    LiveData<Boolean> insertCallLog(CallLogModel model);
    LiveData<Boolean> insertWeeklyLog(WeekLogModel weekLogModel);
}
