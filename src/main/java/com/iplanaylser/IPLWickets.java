package com.iplanaylser;

import com.opencsv.bean.CsvBindByName;

public class IPLWickets {
    public IPLWickets() {
    }

    //    POS,PLAYER,Mat,Inns,Ov,Runs,Wkts,BBI,Avg,Econ,SR,4w,5w
    @CsvBindByName(column = "POS")
    public int position;
    @CsvBindByName(column = "PLAYER")
    public String playerName;
    @CsvBindByName(column = "Mat")
    public int matchesPlayed;
    @CsvBindByName(column = "Inns")
    public int innings;
    @CsvBindByName(column = "Ov")
    public double overs;
    @CsvBindByName(column = "Runs")
    public int runs;
    @CsvBindByName(column = "BBI")
    public int bbi;
    @CsvBindByName(column = "Wkts")
    public int wickets;
    @CsvBindByName(column = "Econ")
    public double economy;
    @CsvBindByName(column = "Avg")
    public double average;
    @CsvBindByName(column = "SR")
    public double strikeRate;
    @CsvBindByName(column = "4w")
    public int fourWickets;
    @CsvBindByName(column = "5w")
    public int fiveWickets;

    public IPLWickets(String playerName, int matchPlayed, double average, double strikeRate, int fours, int five, int runs,
                      double overs, int wickets, double economy) {
        this.playerName = playerName;
        this.matchesPlayed = matchPlayed;
        this.average = average;
        this.strikeRate = strikeRate;
        this.fourWickets = fours;
        this.fiveWickets = five;
        this.runs = runs;
        this.overs = overs;
        this.wickets = wickets;
        this.economy = economy;
    }

    @Override
    public String toString() {
        return "Bowling{" +
                "position=" + position +
                ", playerName='" + playerName + '\'' +
                ", matchesPlayed=" + matchesPlayed +
                ", innings=" + innings +
                ", overs=" + overs +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", bbi=" +bbi+
                ", economy=" + economy +
                ", average=" + average +
                ", strikeRate=" + strikeRate +
                ", fourWickets=" + fourWickets +
                ", fiveWickets=" + fiveWickets +
                '}';
    }
}
