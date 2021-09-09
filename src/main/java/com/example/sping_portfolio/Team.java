package com.example.sping_portfolio;

public class Team {
    String name;
    int numPlayers;
    boolean isOffense;

    public Team(String name, int numPlayers, boolean isOffense){
        this.name = name;
        this.numPlayers = numPlayers;
        this.isOffense = isOffense;
    }

    public String runPlay(String play) {
        if(numPlayers > 11)return ("PENALTY on the " + name + ". " + numPlayers + " men on the field. 10 yard penalty.");
        else return ("The " + name + " are running the play " + play + ".");
    }

}
