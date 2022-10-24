package com.example.a20221024_carlosmendez_nycschools.presentation.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20221024_carlosmendez_nycschools.data.data_source.network.APIService;
import com.example.a20221024_carlosmendez_nycschools.data.data_source.network.RetrofitInstance;
import com.example.a20221024_carlosmendez_nycschools.domain.model.SatResult;
import com.example.a20221024_carlosmendez_nycschools.domain.model.School;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolViewModel extends ViewModel {

    private MutableLiveData<List<School>> schoolList;
    private MutableLiveData<List<SatResult>> satResultList;

    public SchoolViewModel() {
        schoolList = new MutableLiveData<>();
        satResultList = new MutableLiveData<>();
    }

    public MutableLiveData<List<School>> getSchoolListObserver() {
        return schoolList;
    }

    public MutableLiveData<List<SatResult>> getSatResultListObserver() {
        return satResultList;
    }

    public void getSchoolsAPI() {
        APIService apiService = RetrofitInstance.getClient().create(APIService.class);
        Call<List<School>> call = apiService.getSchools(100, 0);

        call.enqueue(new Callback<List<School>>() {
            private static final String TAG = "SchoolViewModel";

            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                schoolList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                schoolList.postValue(null);
            }
        });
    }

    public void getSatResultsAPI(String dbn) {
        APIService apiService = RetrofitInstance.getClient().create(APIService.class);
        Call<List<SatResult>> call = apiService.getSatResult(dbn);

        call.enqueue(new Callback<List<SatResult>>() {
            private static final String TAG = "SchoolViewModel";

            @Override
            public void onResponse(Call<List<SatResult>> call, Response<List<SatResult>> response) {
                satResultList.setValue(response.body());
                Log.d(TAG, "onResponse Body: " + response.body());
            }

            @Override
            public void onFailure(Call<List<SatResult>> call, Throwable t) {
                Log.d(TAG, "onResponse Failed: " + t.getMessage());
                satResultList.setValue(null);
            }
        });
    }
}
