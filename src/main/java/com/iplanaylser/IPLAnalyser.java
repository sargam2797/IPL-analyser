package com.iplanaylser;

import com.google.gson.Gson;
import java.util.*;
import java.util.stream.Collectors;

public class IPLAnalyser {

    Map<String,IPLRuns> iplRunsMap = null;

    public int loadIPLData(String csvFilePath) throws IPLAnalyserException {
        IPLLoader iplLoader = LoadIPLDataProvider.getObject();
        iplRunsMap = iplLoader.loadIPLData(csvFilePath);
        return iplRunsMap.size();
    }

    public String sortByFields(SortingFields.Parameter parameter) {
        Comparator<IPLRuns> iplComparator = new SortingFields().getParameter(parameter);
        ArrayList<IPLRuns> list = this.iplRunsMap.values().stream()
                .sorted(iplComparator)
                .collect(Collectors.toCollection(ArrayList::new));
        String sortIplToJson = new Gson().toJson(list);
        return sortIplToJson;
    }
}
