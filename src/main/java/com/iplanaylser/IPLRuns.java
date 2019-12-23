package com.iplanaylser;

import com.opencsv.bean.CsvBindByName;

public class IPLRuns {

    @CsvBindByName(column = "POS")
    public int position;

    @CsvBindByName(column = "PLAYER")
    public String playerName;

    @CsvBindByName(column = "Mat")
    public int matchPlayed;

    @CsvBindByName(column = "Inns")
    public int inningsPlayed;

    @CsvBindByName(column = "NO")
    public int notOut;

    @CsvBindByName(column = "Runs")
    public int runsScored;

    @CsvBindByName(column = "HS")
    public String highestScored;

    @CsvBindByName(column = "Avg")
    public double averageOfBatsmen;

    @CsvBindByName(column = "BF")
    public int ballFaced;

    @CsvBindByName(column = "SR")
    public double strikeRate;

    @CsvBindByName(column = "100")
    public int numberOfHundredScored;

    @CsvBindByName(column = "50")
    public int numberOfFiftyScored;

    @CsvBindByName(column = "4s")
    public int numberOf4sScored;

    @CsvBindByName(column = "6s")
    public int numberOf6sScored;

    public IPLRuns() {
    }

    public IPLRuns(String playerName, int matchPlayed, double averageOfBatsmen, int runsScored, double strikeRate, int numberOf4sScored, int numberOf6sScored) {
        this.playerName = playerName;
        this.matchPlayed = matchPlayed;
        this.averageOfBatsmen = averageOfBatsmen;
        this.runsScored = runsScored;
        this.strikeRate = strikeRate;
        this.numberOf4sScored = numberOf4sScored;
        this.numberOf6sScored = numberOf6sScored;
    }
}
