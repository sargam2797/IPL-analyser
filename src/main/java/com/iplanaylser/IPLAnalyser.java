package com.iplanaylser;

import com.google.gson.Gson;
import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyser {
     Map<String,IPLDAO> iplMap;
     private Innings innings;
     SortingForIPL sortingForIPL;
     private IPLAdapter iplAdapter;

    public enum Innings {
        BATTING,BOWLING
    }

    public void setIPLAdapter(IPLAdapter adapter) {
        this.iplAdapter = adapter;
    }

    public IPLAnalyser(Innings innings) {
        this.innings = innings;
        sortingForIPL = new SortingForIPL();
    }

    public IPLAnalyser() {
    }

    public int loadIPLData(Innings innings, String... csvFilePath) throws IPLAnalyserException {
        this.iplMap = this.iplAdapter.loadIPLData(innings, csvFilePath);
        return this.iplMap.size();
    }

    public String sortByFields(SortingFields parameter) {
        Comparator<IPLDAO> iplComparator = sortingForIPL.setSortByFields(parameter);
        ArrayList getDTO = this.iplMap.values().stream()
                .sorted(iplComparator)
                .collect(Collectors.toCollection(ArrayList::new));
        String sortIplToJson = new Gson().toJson(getDTO);
        return sortIplToJson;
    }
}
