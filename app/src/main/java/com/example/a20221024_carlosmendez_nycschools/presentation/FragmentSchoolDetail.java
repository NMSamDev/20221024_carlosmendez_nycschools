package com.example.a20221024_carlosmendez_nycschools.presentation;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.a20221024_carlosmendez_nycschools.R;
import com.example.a20221024_carlosmendez_nycschools.domain.model.SatResult;
import com.example.a20221024_carlosmendez_nycschools.presentation.viewmodel.SchoolViewModel;

import java.util.List;

public class FragmentSchoolDetail extends DialogFragment {

    private static final String TAG = "FragmentSchoolDetail";
    private List<SatResult> satResultList;
    private SchoolViewModel schoolViewModel;
    private TextView tvSchoolName;
    private TextView tvReadingScore;
    private TextView tvMathScore;
    private TextView tvWritingScore;

    private TextView tvLabelReadingScore;
    private TextView tvLabelMathScore;
    private TextView tvLabelWritingScore;

    private String dbn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbn = getArguments().getString("dbn");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_school_detail, container, false);

        findViews(view);

        schoolViewModel = ViewModelProviders.of(this).get(SchoolViewModel.class);
        schoolViewModel.getSatResultListObserver().observe(getViewLifecycleOwner(), satResults -> {
            try {
                if(satResults != null) {
                    satResultList = satResults;
                    tvSchoolName.setText(satResultList.get(0).getSchool_name());
                    tvReadingScore.setText(satResultList.get(0).getSat_critical_reading_avg_score());
                    tvMathScore.setText(satResultList.get(0).getSat_math_avg_score());
                    tvWritingScore.setText(satResultList.get(0).getSat_writing_avg_score());
                }
            } catch (Exception e) {
                showDataNotFetchedMessage();
            }
        });
        schoolViewModel.getSatResultsAPI(dbn);
        return view;
    }

    void findViews(View view) {
        tvSchoolName = view.findViewById(R.id.tv_school_name_detail);
        tvReadingScore = view.findViewById(R.id.tv_reading_score_value);
        tvMathScore = view.findViewById(R.id.tv_math_score_value);
        tvWritingScore = view.findViewById(R.id.tv_writing_score_value);

        tvLabelReadingScore = view.findViewById(R.id.tv_reading_score_label);
        tvLabelMathScore = view.findViewById(R.id.tv_math_score_label);
        tvLabelWritingScore = view.findViewById(R.id.tv_writing_score_label);
    }

    void showDataNotFetchedMessage(){
        tvLabelMathScore.setVisibility(View.GONE);
        tvLabelReadingScore.setVisibility(View.GONE);
        tvLabelWritingScore.setVisibility(View.GONE);
        tvReadingScore.setVisibility(View.GONE);
        tvMathScore.setVisibility(View.GONE);
        tvWritingScore.setVisibility(View.GONE);

        tvSchoolName.setText("No SAT Scores Available");
        tvSchoolName.setBackgroundColor(getResources().getColor(R.color.white));
    }
}
