package com.iplanaylser;

public class IPLDAO {
    public String playerName;
    public int matchPlayed;
    public int runsScored;
    public double averageOfBatsmen;
    public double strikeRate;
    public int numberOf4sScored;
    public int numberOf6sScored;
    public double averageOfBowler;
    public double strikeRatesOfBowler;
    public double economyOfBowler;
    public int bowlersWith4Wickets;
    public int bowlersWith5Wickets;
    public int wicketsTaken;
    public int ballsFaced;

    public IPLDAO(IPLRuns next) {
        playerName = next.playerName;
        matchPlayed = next.matchPlayed;
        averageOfBatsmen = next.averageOfBatsmen;
        runsScored = next.runsScored;
        strikeRate = next.strikeRate;
        numberOf4sScored = next.numberOf4sScored;
        numberOf6sScored = next.numberOf6sScored;
        ballsFaced = next.ballFaced;
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

    public IPLDAO(IPLDAO iplCSV) {

    }

    public IPLDAO(String abc, int i, double v) {

    }

    public Object getStatsDTO(IPLAnalyser.Innings innings) {
        if (innings.equals(IPLAnalyser.Innings.BATTING)) return new IPLRuns(playerName, matchPlayed, averageOfBatsmen,
                runsScored, strikeRate, numberOf4sScored, numberOf6sScored);
        if (innings.equals(IPLAnalyser.Innings.BOWLING))
            return new IPLWickets(playerName, averageOfBowler, strikeRatesOfBowler, economyOfBowler,
                    bowlersWith4Wickets, bowlersWith5Wickets, wicketsTaken);
        return null;
    }

    @Override
    public String toString() {
        return "IPLDAO{" +
                "playerName='" + playerName + '\'' +
                ", matchPlayed=" + matchPlayed +
                ", runsScored=" + runsScored +
                ", averageOfBatsmen=" + averageOfBatsmen +
                ", strikeRate=" + strikeRate +
                ", numberOf4sScored=" + numberOf4sScored +
                ", numberOf6sScored=" + numberOf6sScored +
                ", averageOfBowler=" + averageOfBowler +
                ", strikeRatesOfBowler=" + strikeRatesOfBowler +
                ", economyOfBowler=" + economyOfBowler +
                ", bowlersWith4Wickets=" + bowlersWith4Wickets +
                ", bowlersWith5Wickets=" + bowlersWith5Wickets +
                ", wicketsTaken=" + wicketsTaken +
                ", ballsFaced=" + ballsFaced +
                '}';
    }
}
