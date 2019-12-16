package com.iplanaylser;

public class IPLDAO {
    public String playerName;
    public int matchPlayed;
    public double average;
    public double strikeRate;
    public int numberOfFours;
    public int numberOfSixes;

    public IPLDAO(IPLRuns next) {
        this.playerName = next.player;
        this.matchPlayed = next.match;
        this.average = next.avg;
        this.strikeRate = next.strikeRate;
        this.numberOfFours=next.fours;
        this.numberOfSixes=next.sixes;
    }

    public Object getIPLDTO(IPLDAO censusDAO) {
        return new IPLRuns(censusDAO);
    }
}
