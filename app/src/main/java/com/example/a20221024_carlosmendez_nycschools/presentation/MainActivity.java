package com.example.a20221024_carlosmendez_nycschools.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.a20221024_carlosmendez_nycschools.R;

public class MainActivity extends AppCompatActivity {

    Button btnToSchoolList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToSchoolList = findViewById(R.id.btn_main_to_school_list);
        btnToSchoolList.setOnClickListener(view -> {
            Intent intent = new Intent(this, SchoolListActivity.class);
            startActivity(intent);
        });
    }
}