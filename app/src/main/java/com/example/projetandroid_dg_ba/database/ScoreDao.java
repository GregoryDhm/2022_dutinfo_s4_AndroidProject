package com.example.projetandroid_dg_ba.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.projetandroid_dg_ba.entity.Score;

import java.util.List;

public class ScoreDao extends BaseDao<Score>{
    static  String INDEX_PSEUDO = "pseudo";
    static String INDEX_SCORE = "score";

    public ScoreDao(DataBaseHelper helper){ super(helper); }

    @Override
    protected String getTableName(){ return "scores"; }

    @Override
    protected void putValues(ContentValues values, Score entity){
        values.put(INDEX_PSEUDO, entity.getPseudo());
        values.put(INDEX_SCORE, entity.getScore());
    }

    @Override
    protected Score getEntity(Cursor cursor){
        //cursor.moveToFirst();
        Score score = new Score();
        Integer indexScore = cursor.getColumnIndex(INDEX_SCORE);
        score.setScore(cursor.getInt(indexScore));
        Integer indexPseudo = cursor.getColumnIndex(INDEX_PSEUDO);
        score.setPseudo(cursor.getString(indexPseudo));
        return score;
    }

    public List<Score> query(){
        return super.query(null, null, "score DESC");
    }

}
