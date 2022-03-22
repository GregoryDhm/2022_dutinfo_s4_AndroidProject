package com.example.projetandroid_dg_ba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

public class activity_classement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        Button boutonRetourClassement = findViewById(R.id.buttonRetourClassement);
        boutonRetourClassement.setOnClickListener(view -> RetourMenu());
    }

    private boolean RetourMenu() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        return true;
    }
}