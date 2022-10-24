package com.example.a20221024_carlosmendez_nycschools.presentation.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20221024_carlosmendez_nycschools.R;
import com.example.a20221024_carlosmendez_nycschools.domain.model.School;
import com.example.a20221024_carlosmendez_nycschools.presentation.FragmentSchoolDetail;
import com.example.a20221024_carlosmendez_nycschools.presentation.SchoolListActivity;
import com.example.a20221024_carlosmendez_nycschools.presentation.viewmodel.SchoolViewModel;

import java.util.List;

public class SchoolListAdapter extends RecyclerView.Adapter<SchoolListAdapter.SchoolViewHolder> {
    private Context context;
    private List<School> schoolList;

    public SchoolListAdapter(Context context, List<School> schoolList) {
        this.context = context;
        this.schoolList = schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_school_list, parent, false);
        return new SchoolViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolViewHolder holder, int position) {
        holder.tvSchoolName.setText(schoolList.get(position).getSchool_name());
        holder.tvSchoolOverview.setText(schoolList.get(position).getOverview_paragraph());
    }

    @Override
    public int getItemCount() {
        if(this.schoolList != null) {
            return this.schoolList.size();
        }
        return 0;
    }

    public class SchoolViewHolder extends RecyclerView.ViewHolder {
        TextView tvSchoolName;
        TextView tvSchoolOverview;

        public SchoolViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSchoolName = itemView.findViewById(R.id.tv_school_name);
            tvSchoolOverview = itemView.findViewById(R.id.tv_school_overview);

            // onClickListener for each item in the list
            itemView.setOnClickListener(view -> {

                // get the position of the item that was clicked
                int position = getAdapterPosition();

                // get the school object at that position
                School school = schoolList.get(position);

                // get the school's dbn
                String dbn = school.getDbn();

                FragmentSchoolDetail fragmentSchoolDetail = new FragmentSchoolDetail();

                Bundle args = new Bundle();
                args.putString("dbn", dbn);
                fragmentSchoolDetail.setArguments(args);

                // Show dialog fragment
                fragmentSchoolDetail.show(((SchoolListActivity) context).getSupportFragmentManager(), "School Detail");
            });
        }
    }
}
