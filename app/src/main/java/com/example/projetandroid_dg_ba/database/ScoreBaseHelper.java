package com.example.projetandroid_dg_ba.database;

import android.content.Context;

import com.example.projetandroid_dg_ba.entity.Score;

public class ScoreBaseHelper extends DataBaseHelper{

    public ScoreBaseHelper(Context context){
        super(context, "Scores",1);
    }

    @Override
    protected String getCreationSql(){
        String script = "CREATE TABLE IF NOT EXISTS scores ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                ScoreDao.INDEX_SCORE + " INTEGER NOT NULL," +
                ScoreDao.INDEX_PSEUDO + " VARCHAR(255) NOT NULL " +
                ")";
        return script;
    }

    @Override
    protected String getDeleteSql() { return null; }

}
