package com.example.sping_portfolio;

public class test {
    public static void main(String[] args) {
        Team team = new Team("Chargers", 11, false);
        Team team2 = new Team("Patriots", 14, true);

        System.out.println(team.runPlay("smoke screen"));
        System.out.println(team2.runPlay("hail mary"));
    }
}
