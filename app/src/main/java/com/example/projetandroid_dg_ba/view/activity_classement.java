package com.example.projetandroid_dg_ba.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetandroid_dg_ba.R;
import com.example.projetandroid_dg_ba.database.ScoreBaseHelper;
import com.example.projetandroid_dg_ba.database.ScoreDao;
import com.example.projetandroid_dg_ba.entity.Score;
import com.example.projetandroid_dg_ba.service.ScoreService;

import java.util.List;

public class activity_classement extends AppCompatActivity {

    private ScoreService scoreService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);
        scoreService = new ScoreService(new ScoreDao(new ScoreBaseHelper(this)));
        Button boutonRetourClassement = findViewById(R.id.buttonRetourClassement);
        boutonRetourClassement.setOnClickListener(view -> RetourMenu());

        TextView classement1 = findViewById(R.id.textview_classement_1);
        classement1.setText(scoreService.query().get(1).toString());

    }

    private boolean RetourMenu() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        return true;
    }
}