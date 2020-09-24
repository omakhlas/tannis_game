package com.coding.backend.teniskata;

public enum PointScore {

    ZERO("Zero"),FIFTEEN("15"),THIRTY("30"),FORTY("40"),DEUCE("DEU"),ADV("ADV"),WIN("WIN");

    private String score;

    private PointScore(String o){
        this.score = o;
    }


    public String getScore(){
        return this.score;
    }
}
