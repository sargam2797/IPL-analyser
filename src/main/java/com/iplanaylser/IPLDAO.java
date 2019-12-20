package com.iplanaylser;

public class IPLDAO {
    public double strikeRateBowler;
    public int foursWicketBowler;
    public int fiveWicketBowler;
    public int runsBowler;
    public double oversBowler;
   public double averageBowler;
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
        this.averageBowler = next.average;
        this.strikeRateBowler = next.strikeRate;
        this.foursWicketBowler = next.fourWickets;
        this.fiveWicketBowler = next.fiveWickets;
        this.runsBowler = next.runs;
        this.oversBowler =  next.overs;
        this.wickets = next.wickets;
        this.economy = next.economy;
    }

    public Object getIPLDTO(IPLAnalyser.Innings innings) {
        if (innings.equals(IPLAnalyser.Innings.BATTING))
            return new IPLRuns(this.playerName,this.matchPlayed,this.average,this.strikeRate,this.fours,this.sixes,
                    this.runs,this.ballsFaced);
        return new IPLWickets(this.playerName,this.matchPlayed,this.averageBowler,this.strikeRateBowler,
                this.foursWicketBowler,this.fiveWicketBowler,this.runsBowler,this.oversBowler,this.wickets,this.economy);
    }}
