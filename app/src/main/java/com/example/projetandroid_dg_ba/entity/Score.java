package com.example.projetandroid_dg_ba.entity;

public class Score extends BaseEntity{
    Integer score;
    String pseudo;

    public Integer getScore(){ return score; }
    public String getPseudo(){ return pseudo; }

    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
    }
    public void setScore(Integer score){
        this.score = score;
    }

}
