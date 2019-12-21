package com.iplanaylser;

public class IPLDAO {
    public String playerName;
    public int matchPlayed;
    public int runsScored;
    public double average;
    public int ballFaced;
    public double strikeRate;
    public int numberOf4sScored;
    public int numberOf6sScored;
    public double averageOfBowler;
    public double strikeRatesOfBowler;
    public double economyOfBowler;
    public int bowlersWith4Wickets;
    public int bowlersWith5Wickets;
    public int wicketsTaken;

    public IPLDAO(IPLRuns next) {
        playerName = next.playerName;
        matchPlayed = next.matchPlayed;
        average = next.average;
        runsScored = next.runsScored;
        strikeRate = next.strikeRate;
        numberOf4sScored = next.numberOf4sScored;
        numberOf6sScored = next.numberOf6sScored;
        ballFaced = next.ballFaced;
    }

    public IPLDAO(IPLWickets next) {
        playerName = next.playerName;
        averageOfBowler = next.avgOfBowler;
        strikeRatesOfBowler = next.strikeRateOfBowler;
        economyOfBowler = next.economyOfBowler;
        bowlersWith4Wickets = next.wickets4Taken;
        bowlersWith5Wickets = next.wickets5Taken;
        wicketsTaken = next.wicketsTaken;
    }

    public Object getIPLDTO(IPLAnalyser.Innings innings) {
        if (innings.equals(IPLAnalyser.Innings.BATTING)) {
            return new IPLRuns(playerName, matchPlayed, average,
                    runsScored, strikeRate, numberOf4sScored, numberOf6sScored);
        }
        return new IPLWickets(playerName, averageOfBowler, strikeRatesOfBowler, economyOfBowler,
                bowlersWith4Wickets, bowlersWith5Wickets, wicketsTaken);
       }
}
