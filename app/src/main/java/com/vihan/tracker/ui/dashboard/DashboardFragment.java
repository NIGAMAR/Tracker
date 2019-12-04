package com.vihan.tracker.ui.dashboard;

import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.vihan.tracker.R;
import com.vihan.tracker.data.model.WeekLogModel;
import com.vihan.tracker.utils.Logger;

import java.time.OffsetDateTime;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    @BindView(R.id.spinner_weekNumber) public Spinner weekNumber;
    @BindView(R.id.bt_save_log) public Button saveLog;
    @BindView(R.id.et_system_count) public EditText systemCount;
    @BindView(R.id.et_expected_closing) public EditText expectedClosing;
    @BindView(R.id.et_actual_closing) public EditText actualClosing;
    @BindView(R.id.et_uv_uploaded) public EditText uvsUploaded;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this,root);
        saveLog.setOnClickListener(v -> createAndInsertWeeklyLog());
        return root;
    }


    private void createAndInsertWeeklyLog() {
        WeekLogModel weekLogModel=  new WeekLogModel();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            weekLogModel.setId(Calendar.getInstance().get(Calendar.YEAR)+""+weekNumber.getSelectedItem());
        }
        weekLogModel.setWeekNumber( parse((String)weekNumber.getSelectedItem()));
        weekLogModel.setSystemCount(parse(systemCount.getText().toString()));
        weekLogModel.setExpectedClosing(parse(expectedClosing.getText().toString()));
        weekLogModel.setNumberOfClosingHappened(parse(actualClosing.getText().toString()));
        weekLogModel.setBusinessVolume(parse(uvsUploaded.getText().toString()));
        dashboardViewModel.insertWeeklyModel(weekLogModel).observe(this, isDataInserted -> {
            if (isDataInserted){
                clearAllViews();
            }
                Logger.debug("Weekly data inserted successfully");
        });
    }

    private void clearAllViews() {
        systemCount.setText("");
        expectedClosing.setText("");
        actualClosing.setText("");
        uvsUploaded.setText("");
    }

    private int parse(String value){
        return Integer.parseInt(value);
    }
}