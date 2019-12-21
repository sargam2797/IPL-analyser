package com.iplanaylser;

import com.opencsv.bean.CsvBindByName;

public class IPLRuns {

    @CsvBindByName(column = "POS")
    public int position;

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "Mat", required = true)
    public int matchPlayed;

    @CsvBindByName(column = "Inns", required = true)
    public int inningsPlayed;

    @CsvBindByName(column = "NO", required = true)
    public int notOut;

    @CsvBindByName(column = "Runs", required = true)
    public int runsScored;

    @CsvBindByName(column = "HS", required = true)
    public String highestScored;

    @CsvBindByName(column = "Avg", required = true)
    public double average;

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


    public IPLRuns(String playerName, int matchPlayed, double average, int runsScored, double strikeRate, int numberOf4sScored, int numberOf6sScored) {
        this.playerName=playerName;
        this.matchPlayed=matchPlayed;
        this.average=average;
        this.runsScored=runsScored;
        this.strikeRate=strikeRate;
        this.numberOf4sScored=numberOf4sScored;
        this.numberOf6sScored=numberOf6sScored;
    }
}
