package com.example.projetandroid_dg_ba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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