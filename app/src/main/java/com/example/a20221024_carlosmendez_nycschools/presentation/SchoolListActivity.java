package com.example.a20221024_carlosmendez_nycschools.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20221024_carlosmendez_nycschools.R;

import com.example.a20221024_carlosmendez_nycschools.domain.model.School;
import com.example.a20221024_carlosmendez_nycschools.presentation.adapter.SchoolListAdapter;

import java.util.List;

public class SchoolListActivity extends AppCompatActivity {

    private List<School> schoolList;
    private SchoolListAdapter adapter;
    private SchoolViewModel schoolViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_list);

        RecyclerView recyclerView = findViewById(R.id.rv_school_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SchoolListAdapter(this, schoolList);
        recyclerView.setAdapter(adapter);

        schoolViewModel = ViewModelProviders.of(this).get(SchoolViewModel.class);

        schoolViewModel.getSchoolListObserver().observe(this, schools -> {
            if(schools != null) {
                schoolList = schools;
                adapter.setSchoolList(schoolList);
            }
        });
        schoolViewModel.getSchoolsAPI();
    }
}
