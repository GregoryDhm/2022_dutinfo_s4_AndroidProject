package com.example.projetandroid_dg_ba.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.projetandroid_dg_ba.R;
import com.example.projetandroid_dg_ba.view.Jouer_Activity;
import com.example.projetandroid_dg_ba.view.activity_classement;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boutonJouer = findViewById(R.id.boutonJouer);
        Button boutonClassement = findViewById(R.id.boutonClassement);
        boutonJouer.setOnClickListener(view -> lanceJouer_Activity());
        boutonClassement.setOnClickListener(view -> lanceActivity_classement() );
    }

    private void lanceJouer_Activity() {
        Intent i = new Intent(this, Jouer_Activity.class);
        startActivity(i);
    }

    private void lanceActivity_classement() {
        Intent i = new Intent(this, activity_classement.class);
        startActivity(i);
    }
}