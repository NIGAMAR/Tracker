package com.vihan.tracker.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.vihan.tracker.data.model.CallLogModel;
import com.vihan.tracker.data.model.WeekLogModel;
import java.util.List;

@Dao
public interface TrackerDao {

    @Query("select count(*) from CallLogModel as InfoTable where info in ( select info from CallLogModel where weekNumber=:weekNumber)")
    LiveData<Integer> countInfoInGivenWeek(int weekNumber);

    @Query("select count(*) from CallLogModel as InviteTable where invite in ( select invite from CallLogModel where weekNumber=:weekNumber)")
    LiveData<Integer> countInviteInGivenWeek(int weekNumber);

    @Query("select count(*) from CallLogModel as PlanTable where planDone in ( select planDone from CallLogModel where weekNumber=:weekNumber)")
    LiveData<Integer> countNumberOfPlansInGivenWeek(int weekNumber);

    @Query("select * from CallLogModel where id like :uuid")
    LiveData<CallLogModel> getDetailsOfProspect(String uuid);

    @Query("select * from CallLogModel where weekNumber=:weekNumber")
    LiveData<List<CallLogModel>> getLogsForEntireWeek(int weekNumber);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCallLog(CallLogModel callLogModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWeeklyLog(WeekLogModel weekLogModel);

    @Update
    void updateCallLog(CallLogModel callLogModel);
}
