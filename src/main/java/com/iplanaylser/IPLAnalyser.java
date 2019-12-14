package com.iplanaylser;

import com.CSVBuilderFactory;
import com.CsvBuilderException;
import com.ICSvBuilder;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IPLAnalyser {

    Map<String,IPLRuns> iplRunsMap;

    public IPLAnalyser() {
        this.iplRunsMap = new HashMap<>();
    }

    public Map loadIPLData(String csvFilePath) throws IPLAnalyserException {
        try ( Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));){
            ICSvBuilder csvBuilder = CSVBuilderFactory.createCsvBuilder();
            Iterator<IPLRuns> iplCSVIterator = csvBuilder.getFileByIterator(reader, IPLRuns.class);
            Iterable<IPLRuns> csvIterable = () -> iplCSVIterator;
            StreamSupport.stream(csvIterable.spliterator(),false)
                    .map(IPLRuns.class::cast)
                    .forEach(iplRuns -> this.iplRunsMap.put(iplRuns.player, iplRuns));
            return iplRunsMap;
        } catch (IOException e) {
            throw new IPLAnalyserException("invalid file path"+e.getMessage(),
                    IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (CsvBuilderException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.ISSUE_RELATED_TO_FILE);
        }
    }

    public String sortbyFields(SortingFields.Parameter parameter) {
        Comparator<IPLRuns> iplComparator = new SortingFields().getParameter(parameter);
        ArrayList<IPLRuns> list = this.iplRunsMap.values().stream()
                .sorted(iplComparator)
                .collect(Collectors.toCollection(ArrayList::new));
        String sortIplToJson = new Gson().toJson(list);
        return sortIplToJson;
    }
}
