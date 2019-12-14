package com.iplanaylser;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortingFields {
    public Map<Parameter, Comparator> sortByFields = new HashMap<>();

    public enum Parameter {
        AVERAGE
    }

    public SortingFields() {
        sortByFields.put(Parameter.AVERAGE, Comparator.<IPLRuns,Double>comparing(iplRuns ->
                Double.valueOf(iplRuns.avg),Comparator.reverseOrder()));
    }

    public Comparator getParameter(Parameter fields) {
        Comparator<IPLRuns> comparator = sortByFields.get(fields);
        return comparator;
    }
}
