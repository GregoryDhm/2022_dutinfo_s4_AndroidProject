package com.example.projetandroid_dg_ba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Jouer_Activity extends AppCompatActivity {

    private Integer BORNE_HAUTE = 999;
    private Integer reponseElement;
    private Integer premierElement;
    private Integer deuxiemeElement;
    private TextView textViewReponse;
    private TypeOperationEnum typeOperation;
    private TextView textViewEnigme;
    private Integer score;
    private Integer vie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jouer);
        textViewReponse = findViewById(R.id.textViewReponse);
        textViewEnigme = findViewById(R.id.textViewEnigme);
        textViewReponse.setText("0");
        score = 0;
        vie = 3;
        GenerateRandomEnigme();
        Button bouton1 = findViewById(R.id.bouton_1);
        bouton1.setOnClickListener(view -> ajouteValeur(1));
        Button bouton2 = findViewById(R.id.bouton_2);
        bouton2.setOnClickListener(view -> ajouteValeur(2));
        Button bouton3 = findViewById(R.id.bouton_3);
        bouton3.setOnClickListener(view -> ajouteValeur(3));
        Button bouton4 = findViewById(R.id.bouton_4);
        bouton4.setOnClickListener(view -> ajouteValeur(4));
        Button bouton5 = findViewById(R.id.bouton_5);
        bouton5.setOnClickListener(view -> ajouteValeur(5));
        Button bouton6 = findViewById(R.id.bouton_6);
        bouton6.setOnClickListener(view -> ajouteValeur(6));
        Button bouton7 = findViewById(R.id.bouton_7);
        bouton7.setOnClickListener(view -> ajouteValeur(7));
        Button bouton8 = findViewById(R.id.bouton_8);
        bouton8.setOnClickListener(view -> ajouteValeur(8));
        Button bouton9 = findViewById(R.id.bouton_9);
        bouton9.setOnClickListener(view -> ajouteValeur(9));
        Button bouton0 = findViewById(R.id.bouton_0);
        bouton0.setOnClickListener(view -> ajouteValeur(0));
        Button boutonDel = findViewById(R.id.DelButton);
        boutonDel.setOnClickListener(view -> removeValeur());
        Button boutonMoins = findViewById(R.id.MoinsButton);
        boutonMoins.setOnClickListener(view -> Moins());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);
        MenuItem toolbarRepondre = menu.findItem(R.id.toolbar_repondre);
        MenuItem toolbarNettoyer = menu.findItem(R.id.toolbar_nettoyer);
        MenuItem toolbarRetour = menu.findItem(R.id.toolbar_retour);
        toolbarRepondre.setOnMenuItemClickListener(menuItem -> calculResultat());
        toolbarNettoyer.setOnMenuItemClickListener(menuItem -> Clear());
        toolbarRetour.setOnMenuItemClickListener(menuItem -> RetourMenu());
        return true;
    }

    private boolean calculResultat() {
        int reponseUser=0;
        try{
            reponseUser = Integer.parseInt(textViewReponse.getText().toString());
        }catch (Exception e){
            return false;
        }
        if (reponseElement == reponseUser) {
            score++;
            GenerateRandomEnigme();
        }else{
            vie--;
            if(vie < 0)
                fini();
            else
                textViewReponse.setText(vie +" vies restantes");
        }
        return true;
    }

    private boolean RetourMenu() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        return true;
    }

    private void GenerateRandomEnigme(){
        int randomNumber1,randomNumber2;
        int Rand = new Random().nextInt(3);
        switch (Rand){
            case 0:
                this.typeOperation=TypeOperationEnum.ADD;
                break;
            case 1:
                this.typeOperation=TypeOperationEnum.SUBSTRACT;
                break;
            case 2:
                this.typeOperation=TypeOperationEnum.MULTIPLY;
                break;
        }
        if(this.typeOperation == TypeOperationEnum.MULTIPLY){
            randomNumber1 = new Random().nextInt(11);
            randomNumber2 = new Random().nextInt(11);
            setElements(randomNumber1,randomNumber2);
            reponseElement = premierElement * deuxiemeElement;
        }else{
            randomNumber1 = new Random().nextInt(200)-100;
            randomNumber2 = new Random().nextInt(200)-100;
            setElements(randomNumber1,randomNumber2);
            if (this.typeOperation == TypeOperationEnum.SUBSTRACT)
                reponseElement = premierElement - deuxiemeElement;
            else if (this.typeOperation == TypeOperationEnum.ADD)
                reponseElement = premierElement + deuxiemeElement;
        }
        majTextView();
    }
    public void setElements(int premierElement, int deuxiemeElement){
        this.premierElement = premierElement;
        this.deuxiemeElement = deuxiemeElement;
    }

    private void majTextView() {
        String textAAfficher="";
        if(typeOperation == null)
            textAAfficher = premierElement.toString();
        else
            textAAfficher = premierElement.toString() + " "+this.typeOperation.getSymbol()+" "+deuxiemeElement;
        textViewEnigme.setText(textAAfficher);
    }

    private void ajouteValeur(Integer valeur){
        Integer reponseUser;
        try{
            reponseUser = Integer.parseInt(textViewReponse.getText().toString());
        }catch (Exception e){
            textViewReponse.setText(valeur.toString());
            return;
        }
        if(10*reponseUser+valeur > BORNE_HAUTE)
            Toast.makeText(this,getString(R.string.ERREUR_TROP_GRAND),Toast.LENGTH_LONG).show();
        else
            reponseUser = 10*reponseUser+valeur;
        textViewReponse.setText(reponseUser.toString());
    }

    private void removeValeur(){
        Integer reponseUser;
        try{
            reponseUser = Integer.parseInt(textViewReponse.getText().toString());
        }catch (Exception e){
            return;
        }
        reponseUser = (int) reponseUser / 10;
        textViewReponse.setText(reponseUser.toString());
    }

    private void Moins(){
        Integer reponseUser;
        try{
            reponseUser = Integer.parseInt(textViewReponse.getText().toString());
        }catch (Exception e){
            return;
        }
        reponseUser = - reponseUser;
        textViewReponse.setText(reponseUser.toString());
    }

    private boolean Clear() {
        textViewReponse.setText("");
        return true;
    }

    private void fini() {
        Intent i = new Intent(this, activity_classement.class);
        startActivity(i);
    }

}