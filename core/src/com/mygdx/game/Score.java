package com.mygdx.game;

public class Score {
    private int score;


    public Score() {
        this.score = 0;
    }


    public void addScore(int score){
        this.score += score;
    }


    public void decreaseScore(int score){
        this.score -= score;
    }


    public void setScore(int score){
        this.score = score;
    }


    public int getScore(){
        return score;
    }


    public String displayScoreasStr(){
        return "Score: " + score;
    }

}
