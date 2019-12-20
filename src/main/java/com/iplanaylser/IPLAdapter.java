package com.iplanaylser;

import com.CSVBuilderFactory;
import com.CsvBuilderException;
import com.ICSvBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IPLAdapter {
    private Map<String,IPLDAO> iplRunsMap;

    public IPLAdapter() {
        this.iplRunsMap = new HashMap<>();
    }

    public abstract Map loadIPLData(IPLAnalyser.Innings innings, String csvFilePath) throws IPLAnalyserException;

    public <T>Map loadIPLData(Class<T> iplClass,String csvFilePath) throws IPLAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));){
            ICSvBuilder csvBuilder = CSVBuilderFactory.createCsvBuilder();
            Iterator<T> iplCSVIterator = csvBuilder.getFileByIterator(reader, iplClass);
            Iterable<T> csvIterable = () -> iplCSVIterator;
            if (iplClass.getName().equals("com.iplanaylser.IPLRuns")) {
                StreamSupport.stream(csvIterable.spliterator(),false)
                        .map(IPLRuns.class::cast)
                        .forEach(iplRuns -> this.iplRunsMap.put(iplRuns.player,  new IPLDAO(iplRuns)));
            }
            if (iplClass.getName().equals("com.iplanaylser.IPLWickets")) {
                StreamSupport.stream(csvIterable.spliterator(),false)
                        .map(IPLWickets.class::cast)
                        .forEach(iplWickets -> this.iplRunsMap.put(iplWickets.playerName,  new IPLDAO(iplWickets)));
            }
            return iplRunsMap;
        } catch (IOException e) {
            throw new IPLAnalyserException("invalid file path"+e.getMessage(),
                    IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (CsvBuilderException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.ISSUE_RELATED_TO_FILE);
        }
    }
}
