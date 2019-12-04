package com.vihan.tracker.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.vihan.tracker.R;
import com.vihan.tracker.data.model.CallLogModel;
import com.vihan.tracker.enums.CallType;
import com.vihan.tracker.utils.Logger;
import com.vihan.tracker.utils.UUIDGeneratorUtil;
import org.threeten.bp.OffsetDateTime;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    @BindView(R.id.et_name) public EditText etName;
    @BindView(R.id.et_number) public EditText etNumber;
    @BindView(R.id.et_remarks) public EditText etRemarks;
    @BindView(R.id.spinner_cities) public Spinner spinnerCities;
    @BindView(R.id.spinner_zone) public Spinner spinnerZone;
    @BindView(R.id.spinner_callType) public Spinner spinnerCallType;
    @BindView(R.id.spinner_weekNumber) public Spinner spinnerWeekNumber;
    @BindView(R.id.bt_save_log) public Button btSaveLog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,root);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        btSaveLog.setOnClickListener(v -> createAndInsertLog());
    }

    private void createAndInsertLog() {
        CallLogModel callLogModel = new CallLogModel();
        if (etNumber.getText().toString().isEmpty()){
            Toast.makeText(getActivity(),getResources().getString(R.string.insert_error_toast_msg),Toast.LENGTH_LONG).show();
            return;
        }
        callLogModel.setId(UUIDGeneratorUtil.generateUUID(etNumber.getText().toString().trim()));
        callLogModel.setName(etName.getText().toString());
        callLogModel.setNumber(etNumber.getText().toString().trim());
        callLogModel.setCity((String) spinnerCities.getSelectedItem());
        callLogModel.setZone((String) spinnerZone.getSelectedItem());
        callLogModel.setDate(OffsetDateTime.now());
        callLogModel.setCallType(CallType.valueOf((String) spinnerCallType.getSelectedItem()));
        callLogModel.setRemarks(etRemarks.getText().toString().trim());
        callLogModel.setWeekNumber(Integer.parseInt((String)spinnerWeekNumber.getSelectedItem()));
        homeViewModel.saveCallLog(callLogModel).observe(this, insertedSuccessFully -> {
            if(insertedSuccessFully){
                clearAllViews();
            }
        });
    }

    private void clearAllViews() {
        Logger.debug("CallLog Inserted Successfully");
      // clear all the views so that another entry can be made
      etName.setText("");
      etNumber.setText("");
      etRemarks.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}