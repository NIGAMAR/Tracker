package com.vihan.tracker.data.repository;

import android.content.Context;

import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.room.Room;
import com.vihan.tracker.data.dao.TrackerDao;
import com.vihan.tracker.data.db.TrackerDb;
import com.vihan.tracker.data.model.CallLogModel;
import com.vihan.tracker.data.model.WeekLogModel;
import com.vihan.tracker.data.model.WeeklySummary;
import com.vihan.tracker.utils.Constants;


public class TrackerRepoImpl implements TrackerRepo{
    private TrackerDb trackerDb;
    private TrackerDao trackerDao;
    public static TrackerRepo trackerRepo;
    private TrackerRepoImpl(Context context) {
        trackerDb = Room.databaseBuilder(context,TrackerDb.class, Constants.DATABASE_NAME).allowMainThreadQueries().build();
        trackerDao = trackerDb.getTrackerDao();
    }

    public static TrackerRepo instantiateTrackerRepository(Context context){
        if (trackerRepo == null){
            trackerRepo = new TrackerRepoImpl(context);
        }
        return trackerRepo;
    }

    @Override
    public LiveData<WeeklySummary> getWeeklySummary(int weekNumber) {
//        return trackerDao.getWeeklySummary();
        return null;
    }

    @Override
    public LiveData<Boolean> insertCallLog(CallLogModel model) {
        MutableLiveData<Boolean> isDataInserted = new MutableLiveData<>();
        // check if the data is already present
        LiveData<CallLogModel> existingCallLog = trackerDao.getDetailsOfProspect(model.getId());
        CallLogModel exiCallLogModel = existingCallLog.getValue();
        if (exiCallLogModel!=null){
            trackerDao.insertCallLog(exiCallLogModel.copyByUpdatingRemarks(model));
        }else {
            trackerDao.insertCallLog(model);
        }
        isDataInserted.postValue(true);
        return isDataInserted;
    }

    private void updateExistingLog(CallLogModel existingCallLog) {

    }

    @Override
    public LiveData<Boolean> insertWeeklyLog(WeekLogModel weekLogModel) {
        MutableLiveData<Boolean> isDataInserted = new MutableLiveData<>();
        trackerDao.insertWeeklyLog(weekLogModel);
        isDataInserted.postValue(true);
        return isDataInserted;
    }
}
