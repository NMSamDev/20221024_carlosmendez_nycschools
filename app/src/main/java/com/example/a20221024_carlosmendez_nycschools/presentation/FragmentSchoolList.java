package com.example.a20221024_carlosmendez_nycschools.presentation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20221024_carlosmendez_nycschools.R;
import com.example.a20221024_carlosmendez_nycschools.domain.model.School;
import com.example.a20221024_carlosmendez_nycschools.presentation.adapter.SchoolListAdapter;
import com.example.a20221024_carlosmendez_nycschools.presentation.viewmodel.SchoolViewModel;

import java.util.List;

public class FragmentSchoolList extends Fragment {

    private static final String TAG = "FragmentSchoolList";
    private List<School> schoolList;
    private SchoolListAdapter adapter;
    private SchoolViewModel schoolViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_school_list, container, false);

        schoolViewModel = ViewModelProviders.of(this).get(SchoolViewModel.class);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        RecyclerView recyclerView = view.findViewById(R.id.rv_school_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SchoolListAdapter(getContext(), schoolList);
        recyclerView.setAdapter(adapter);

        schoolViewModel.getSchoolListObserver().observe(getViewLifecycleOwner(), schools -> {
            if(schools != null) {
                schoolList = schools;
                adapter.setSchoolList(schoolList);
                progressBar.setVisibility(View.GONE);
            }
        });
        schoolViewModel.getSchoolsAPI();
        return view;
    }
}
