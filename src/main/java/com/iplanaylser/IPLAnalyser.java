package com.iplanaylser;

import com.google.gson.Gson;
import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyser {
    private Map<String,IPLDAO> iplRunsMap = new HashMap<>();
    private Map<SortingFields, Comparator<IPLDAO>> sortByFields;

    public IPLAnalyser() {
        setSortByFields();
    }

    public void setSortByFields() {
        this.sortByFields = new HashMap<>();
        this.sortByFields.put(SortingFields.AVERAGE, Comparator.comparing(census ->
                census.average, Comparator.reverseOrder()));
        this.sortByFields.put(SortingFields.STRIKING_RATE, Comparator.comparing(census ->
                census.strikeRate, Comparator.reverseOrder()));
        this.sortByFields.put(SortingFields.MAX_4s_AND_6s, Comparator.comparing(census -> (census.numberOfFours*4+census
                .numberOfSixes*6), Comparator.reverseOrder()));
        this.sortByFields.put(SortingFields.MAX_4s_AND_6s_WITH_BEST_STRIKING_RATE, Comparator.comparing(census ->
                ((census.numberOfFours*4+census.numberOfSixes*6))/(census.ballsFaced), Comparator.reverseOrder()));
        Comparator<IPLDAO> comparatorForAverage = Comparator.comparing(compare -> compare.average);
        this.sortByFields.put(SortingFields.BEST_AVERAGE_WITH_STRIKE_RATE, comparatorForAverage.thenComparing(compare ->
                compare.strikeRate).reversed());
        Comparator<IPLDAO> comparatorForRuns = Comparator.comparing(compare -> compare.runs);
        this.sortByFields.put(SortingFields.MAX_RUNS_WITH_BEST_AVERAGE, comparatorForRuns.thenComparing(compare ->
                compare.average).reversed());
    }

    public void loadIPLData(String csvFilePath) throws IPLAnalyserException {
        iplRunsMap = new IPLLoader().loadIPLData(csvFilePath);
    }

    public String sortByFields(SortingFields parameter) {
        ArrayList getDTO = this.iplRunsMap.values().stream()
                .sorted(this.sortByFields.get(parameter))
                .map(censusDAO -> censusDAO.getIPLDTO(censusDAO))
                .collect(Collectors.toCollection(ArrayList::new));
        String sortIplToJson = new Gson().toJson(getDTO);
        return sortIplToJson;
    }
}
