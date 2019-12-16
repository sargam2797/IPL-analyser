package com.iplanaylser;

import com.google.gson.Gson;
import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyser {
    Map<String,IPLDAO> iplRunsMap = null;
    Map<SortingFields, Comparator<IPLDAO>> fields ;

    public IPLAnalyser() {
        this.fields = new HashMap<>();
        this.fields.put(SortingFields.AVERAGE, Comparator.comparing(census ->
                census.average, Comparator.reverseOrder()));
        this.fields.put(SortingFields.STRIKING_RATE, Comparator.comparing(census ->
                census.strikeRate, Comparator.reverseOrder()));
        this.fields.put(SortingFields.MAX_4s_AND_6s, Comparator.comparing(census -> (census.numberOfFours*4+census
                .numberOfSixes*6), Comparator.reverseOrder()));
    }

    public int loadIPLData(String csvFilePath) throws IPLAnalyserException {
        IPLLoader iplLoader = LoadIPLDataProvider.getObject();
        iplRunsMap = iplLoader.loadIPLData(csvFilePath);
        return iplRunsMap.size();
    }

    public String sortByFields(SortingFields parameter) {
        ArrayList getDTO = this.iplRunsMap.values().stream()
                .sorted(this.fields.get(parameter))
                .map(censusDAO -> censusDAO.getIPLDTO(censusDAO))
                .collect(Collectors.toCollection(ArrayList::new));
        String sortIplToJson = new Gson().toJson(getDTO);
        return sortIplToJson;
    }
}
