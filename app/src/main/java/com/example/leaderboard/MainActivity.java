package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLeaders, btnSkills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeaders = findViewById(R.id.btn_leader);
        btnLeaders.setOnClickListener(this);

        btnSkills = findViewById(R.id.btn_skills);
        btnSkills.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_leader:
                gotoLeaderActivity();
                break;
            case R.id.btn_skills:
                gotoSkills();
                break;
            default:
        }

    }

    private void gotoSkills() {
        Intent intent = new Intent(this, SkillsActivity.class);
        startActivity(intent);
    }

    private void gotoLeaderActivity() {
        Intent intent = new Intent(this, LearningLeadersList.class);
        startActivity(intent);
    }
}