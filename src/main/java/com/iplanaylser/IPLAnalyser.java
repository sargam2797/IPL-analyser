package com.iplanaylser;

import com.google.gson.Gson;
import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyser {

    Map<String,IPLRuns> iplRunsMap = null;
    Map<SortingFields, Comparator<IPLRuns>> fields = new HashMap<>();

    public IPLAnalyser() {
        this.fields.put(SortingFields.AVERAGE, Comparator.comparing(census ->
                census.avg, Comparator.reverseOrder()));
    }

    public int loadIPLData(String csvFilePath) throws IPLAnalyserException {
        IPLLoader iplLoader = LoadIPLDataProvider.getObject();
        iplRunsMap = iplLoader.loadIPLData(csvFilePath);
        return iplRunsMap.size();
    }

    public String sortByFields(SortingFields parameter) {
        ArrayList<IPLRuns> list = this.iplRunsMap.values().stream()
                .sorted(this.fields.get(parameter))
                .collect(Collectors.toCollection(ArrayList::new));
        String sortIplToJson = new Gson().toJson(list);
        return sortIplToJson;
    }
}
