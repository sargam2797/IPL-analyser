package com.iplanaylser;

import com.opencsv.bean.CsvBindByName;

public class IPLWickets {
    @CsvBindByName(column = "POS")
    public int position;

    @CsvBindByName(column = "PLAYER")
    public String playerName;

    @CsvBindByName(column = "Mat")
    public int matchesPlayed;

    @CsvBindByName(column = "Inns")
    public int inningsPlayed;

    @CsvBindByName(column = "Ov")
    public double oversThrown;

    @CsvBindByName(column = "Runs")
    public int runsGiven;

    @CsvBindByName(column = "Wkts")
    public int wicketsTaken;

    @CsvBindByName(column = "BBI")
    public String bbI;

    @CsvBindByName(column = "Avg")
    public double avgOfBowler;

    @CsvBindByName(column = "Econ")
    public double economyOfBowler;

    @CsvBindByName(column = "SR")
    public double strikeRateOfBowler;

    @CsvBindByName(column = "4w")
    public int wickets4Taken;

    @CsvBindByName(column = "5w")
    public int wickets5Taken;

    public IPLWickets() {
    }

    public IPLWickets(String playerName, double averageOfBowler, double strikeRateOfBowler,
                         double economyOfBowler, int bowlersWith4Wickets, int bowlersWith5Wickets,
                         int wicketsTaken) {
        this.playerName = playerName;
        this.avgOfBowler = averageOfBowler;
        this.strikeRateOfBowler = strikeRateOfBowler;
        this.economyOfBowler = economyOfBowler;
        this.wickets4Taken = bowlersWith4Wickets;
        this.wickets5Taken = bowlersWith5Wickets;
        this.wicketsTaken = wicketsTaken;
    }
}
