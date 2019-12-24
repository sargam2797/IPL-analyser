package com.iplanaylser;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortingForIPL {
    static Map<SortingFields, Comparator<IPLDAO>> iplMap = new HashMap<>();

    public SortingForIPL() {
    }

    public Comparator<IPLDAO> setSortByFields(SortingFields sortByFields) {
        this.iplMap.put(SortingFields.BATTING_AVERAGE, Comparator.comparing(census -> census.averageOfBatsmen,
                Comparator.reverseOrder()));
        this.iplMap.put(SortingFields.STRIKING_RATE, Comparator.comparing(census ->
                census.strikeRate, Comparator.reverseOrder()));
        this.iplMap.put(SortingFields.MAX_4s_AND_6s, Comparator.comparing(census -> (census.numberOf4sScored *4+census
                .numberOf6sScored *6), Comparator.reverseOrder()));
        this.iplMap.put(SortingFields.MAX_4s_AND_6s_WITH_BEST_STRIKING_RATE, Comparator.comparing(census ->
                ((census.numberOf4sScored *4+census.numberOf6sScored *6))/(census.ballsFaced), Comparator.reverseOrder()));
        Comparator<IPLDAO> comparatorForBattingAverage = Comparator.comparing(compare -> compare.averageOfBatsmen);
        this.iplMap.put(SortingFields.BEST_AVERAGE_WITH_STRIKE_RATE, comparatorForBattingAverage.thenComparing(compare ->
                compare.strikeRate).reversed());
        Comparator<IPLDAO> comparatorForRuns = Comparator.comparing(compare -> compare.runsScored);
        this.iplMap.put(SortingFields.MAX_RUNS_WITH_BEST_AVERAGE, comparatorForRuns.thenComparing(compare ->
                compare.averageOfBatsmen).reversed());
        this.iplMap.put(SortingFields.BOWLING_AVERAGE, Comparator.comparing(census -> census.averageOfBowler));
        this.iplMap.put(SortingFields.TOP_BOWLING_STRIKING_RATES, Comparator.comparing(census ->
                census.strikeRatesOfBowler));
        this.iplMap.put(SortingFields.TOP_BOWLING_ECONOMY_RATES, Comparator.comparing(census ->
                census.economyOfBowler));
        Comparator<IPLDAO> comparatorForBowler = Comparator.comparing(census -> census.bowlersWith4Wickets
                +census.bowlersWith5Wickets);
        this.iplMap.put(SortingFields.TOP_BOWLING_STRIKING_RATES_WITH_MOST_4Ws_AND_5Ws,
                comparatorForBowler.thenComparing(compare -> compare.strikeRatesOfBowler).reversed());
        Comparator<IPLDAO> comparatorForBestAverageBowler = Comparator.comparing(compare -> compare.averageOfBowler);
        this.iplMap.put(SortingFields.GREAT_AVERAGE_WITH_BEST_STRIKING_RATE,
                comparatorForBestAverageBowler.thenComparing(compare -> compare.strikeRatesOfBowler));

        this.iplMap.put(SortingFields.BEST_BATTING_BOWLING_AVERAGE,
                new BestBattingAndBowlingComparator().reversed());

        this.iplMap.put(SortingFields.ALL_ROUNDER,
                new AllRounderComparator().reversed());
        Comparator<IPLDAO> comparator = iplMap.get(sortByFields);
        return comparator;
    }

}
