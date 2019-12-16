package com.iplanaylser;

public class IPLDAO {
    public String playerName;
    public int matchPlayed;
    public double average;
    public double strikeRate;
    public int numberOfFours;
    public int numberOfSixes;
    public int runs;
    public int ballsFaced;

    public IPLDAO(IPLRuns next) {
        this.playerName = next.player;
        this.matchPlayed = next.match;
        this.average = next.avg;
        this.strikeRate = next.strikeRate;
        this.numberOfFours = next.fours;
        this.numberOfSixes = next.sixes;
        this.runs = next.runs;
        this.ballsFaced =  next.ballFaced;
    }

    public Object getIPLDTO(IPLDAO censusDAO) {
        return new IPLRuns(censusDAO);
    }
}
