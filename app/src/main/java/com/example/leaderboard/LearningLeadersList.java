package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeadersList extends AppCompatActivity {

    RecyclerView leaderListRecyclerView;
    LearnerRecyclerAdapter adapter;
    private static final String TAG = "LearningLeadersList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_leaders_list);

        leaderListRecyclerView = findViewById(R.id.rv_learners);

        Log.d(TAG, "onCreate: Calling leaders");
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetroLeader>> call = service.getAllLeaders();
        call.enqueue(new Callback<List<RetroLeader>>() {
            @Override
            public void onResponse(Call<List<RetroLeader>> call, Response<List<RetroLeader>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroLeader>> call, Throwable t) {
                Toast.makeText(LearningLeadersList.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void generateDataList(List<RetroLeader> retroLeader) {
        adapter = new LearnerRecyclerAdapter(LearningLeadersList.this,retroLeader);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LearningLeadersList.this);
        leaderListRecyclerView.setLayoutManager(layoutManager);
        leaderListRecyclerView.setAdapter(adapter);
    }
}