package com.example.a20221024_carlosmendez_nycschools.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a20221024_carlosmendez_nycschools.R;
import com.example.a20221024_carlosmendez_nycschools.domain.model.School;
import com.example.a20221024_carlosmendez_nycschools.presentation.adapter.SchoolListAdapter;
import com.example.a20221024_carlosmendez_nycschools.presentation.viewmodel.SchoolViewModel;

import java.util.List;

public class SchoolListActivity extends AppCompatActivity {

    FragmentContainerView fragmentContainerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_list);

        fragmentContainerView = findViewById(R.id.fragment_container_view);

        // Fragment Container View
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, FragmentSchoolList.class, null)
                    .commit();
        }

    }
}
