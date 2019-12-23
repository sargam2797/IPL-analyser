package com.iplanaylser;

import com.google.gson.Gson;
import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyser {
    private Map<String,IPLDAO> iplRunsMap;
    private Map<SortingFields, Comparator<IPLDAO>> sortByFields ;
    private Innings innings;

    public enum Innings {
        BATTING,BOWLING
    }

    public IPLAnalyser(Innings innings) {
        this.innings = innings;
        this.sortByFields = new HashMap<>();
        this.iplRunsMap = new HashMap<>();
        setSortByFields();
    }
    public IPLAnalyser() {}

    public void setSortByFields() {
        this.sortByFields.put(SortingFields.BATTING_AVERAGE,Comparator.comparing(census -> census.averageOfBatsmen,
                Comparator.reverseOrder()));
        this.sortByFields.put(SortingFields.STRIKING_RATE, Comparator.comparing(census ->
                census.strikeRate, Comparator.reverseOrder()));
        this.sortByFields.put(SortingFields.MAX_4s_AND_6s, Comparator.comparing(census -> (census.numberOf4sScored *4+census
                .numberOf6sScored *6), Comparator.reverseOrder()));
        this.sortByFields.put(SortingFields.MAX_4s_AND_6s_WITH_BEST_STRIKING_RATE, Comparator.comparing(census ->
                ((census.numberOf4sScored *4+census.numberOf6sScored *6))/(census.ballsFaced), Comparator.reverseOrder()));
        Comparator<IPLDAO> comparatorForBattingAverage = Comparator.comparing(compare -> compare.averageOfBatsmen);
        this.sortByFields.put(SortingFields.BEST_AVERAGE_WITH_STRIKE_RATE, comparatorForBattingAverage.thenComparing(compare ->
                compare.strikeRate).reversed());
        Comparator<IPLDAO> comparatorForRuns = Comparator.comparing(compare -> compare.runsScored);
        this.sortByFields.put(SortingFields.MAX_RUNS_WITH_BEST_AVERAGE, comparatorForRuns.thenComparing(compare ->
                compare.averageOfBatsmen).reversed());
        this.sortByFields.put(SortingFields.BOWLING_AVERAGE, Comparator.comparing(census -> census.averageOfBowler));
        this.sortByFields.put(SortingFields.TOP_BOWLING_STRIKING_RATES, Comparator.comparing(census ->
                census.strikeRatesOfBowler));
        this.sortByFields.put(SortingFields.TOP_BOWLING_ECONOMY_RATES, Comparator.comparing(census ->
                census.economyOfBowler));
        Comparator<IPLDAO> comparatorForBowler = Comparator.comparing(census -> census.bowlersWith4Wickets
                +census.bowlersWith5Wickets);
        this.sortByFields.put(SortingFields.TOP_BOWLING_STRIKING_RATES_WITH_MOST_4Ws_AND_5Ws,
                comparatorForBowler.thenComparing(compare -> compare.strikeRatesOfBowler).reversed());
        Comparator<IPLDAO> comparatorForBestAverageBowler = Comparator.comparing(compare -> compare.averageOfBowler);
        this.sortByFields.put(SortingFields.GREAT_AVERAGE_WITH_BEST_STRIKING_RATE,
                comparatorForBestAverageBowler.thenComparing(compare -> compare.strikeRatesOfBowler));
        this.sortByFields.put(SortingFields.BEST_BATTING_BOWLING_AVERAGE,
                new BestBattingAndBowlingComparator().reversed());
        this.sortByFields.put(SortingFields.ALL_ROUNDER,
                new AllRounderComparator().reversed());
    }

    public int loadIPLData(Innings innings,String... csvFilePath) throws IPLAnalyserException {
        IPLAdapter iplAdapter = IPLLoaderProvider.getIPLObject(innings);
        this.iplRunsMap = iplAdapter.loadIPLData(innings, csvFilePath);
        return this.iplRunsMap.size();
    }

    public String sortByFields(SortingFields parameter) {
        ArrayList getDTO = this.iplRunsMap.values().stream()
                .sorted(this.sortByFields.get(parameter))
                .collect(Collectors.toCollection(ArrayList::new));
        String sortIplToJson = new Gson().toJson(getDTO);
        return sortIplToJson;
    }
}
