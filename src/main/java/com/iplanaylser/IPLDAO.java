package com.iplanaylser;

public class IPLDAO {
    public String playerName;
    public int matchPlayed;
    public double average;
    public double strikeRate;
    public int fours;
    public int sixes;
    public int five;
    public int runs;
    public int ballsFaced;
    public double overs;
    public int wickets;
    public double economy;

    public IPLDAO(IPLRuns next) {
        this.playerName = next.player;
        this.matchPlayed = next.match;
        this.average = next.avg;
        this.strikeRate = next.strikeRate;
        this.fours = next.fours;
        this.sixes = next.sixes;
        this.runs = next.runs;
        this.ballsFaced =  next.ballFaced;
    }

    public IPLDAO(IPLWickets next) {
        this.playerName = next.playerName;
        this.matchPlayed = next.matchesPlayed;
        this.average = next.average;
        this.strikeRate = next.strikeRate;
        this.fours = next.fourWickets;
        this.five = next.fiveWickets;
        this.runs = next.runs;
        this.overs =  next.overs;
        this.wickets = next.wickets;
        this.economy = next.economy;
    }

    public Object getIPLDTO(IPLAnalyser.Innings innings) {
        if (innings.equals(IPLAnalyser.Innings.BATTING))
            return new IPLRuns(this.playerName,this.matchPlayed,this.average,this.strikeRate,this.fours,this.sixes,
                    this.runs,this.ballsFaced);
        return new IPLWickets(this.playerName,this.matchPlayed,this.average,this.strikeRate,this.fours,this.five,
                this.runs,this.overs,this.wickets,this.economy);
    }}
