package com.example.projetandroid_dg_ba.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetandroid_dg_ba.R;
import com.example.projetandroid_dg_ba.database.ScoreBaseHelper;
import com.example.projetandroid_dg_ba.database.ScoreDao;
import com.example.projetandroid_dg_ba.entity.Score;
import com.example.projetandroid_dg_ba.service.ScoreService;

import java.util.List;

public class EndgameActivity extends AppCompatActivity {

    private Integer userScore;
    private ScoreService scoreService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endgame);

        scoreService = new ScoreService(new ScoreDao(new ScoreBaseHelper(this)));

        userScore = getIntent().getIntExtra("score",0);

        TextView score = findViewById(R.id.textViewScore);
        score.setText("score : " + userScore);

        Button boutonSave = findViewById(R.id.buttonSaveScore);
        boutonSave.setOnClickListener(view -> saveScore());
        Button boutonNoSave = findViewById(R.id.buttonNoSave);
        boutonNoSave.setOnClickListener(view -> exit());

    }

    private void exit() {
        Intent i = new Intent(this, activity_classement.class);
        startActivity(i);
    }

    private void saveScore() {
        EditText pseudo = findViewById(R.id.saisi);
        if(TextUtils.isEmpty(pseudo.getText().toString())) {
            Toast.makeText(this, getString(R.string.ERREUR_PSEUDONOTDEFINE), Toast.LENGTH_LONG).show();
            return;
        }

        Score score = new Score();
        score.setScore(userScore);
        score.setPseudo(pseudo.toString());
        scoreService.storeScoreInDataBase(score);
        exit();

    }


}
