package com.example.projetandroid_dg_ba.service;

import com.example.projetandroid_dg_ba.database.ScoreDao;
import com.example.projetandroid_dg_ba.entity.Score;

import java.util.List;

public class ScoreService {

    private ScoreDao scoreDao;

    public  ScoreService(ScoreDao scoreDao){this.scoreDao=scoreDao;}

    public long getScoreNumber(){return scoreDao.count();}

    public void storeScoreInDataBase(Score score){ scoreDao.create(score);}

    public List<Score> query() {
        return scoreDao.query();
    }

}
