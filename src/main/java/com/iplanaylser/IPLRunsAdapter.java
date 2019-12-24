package com.iplanaylser;

import com.CSVBuilderFactory;
import com.CsvBuilderException;
import com.ICSvBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class IPLRunsAdapter extends IPLAdapter {

    @Override
    public Map loadIPLData(IPLAnalyser.Innings innings, String... csvFilePath) throws IPLAnalyserException {
        try {
            Map<String, IPLDAO> censusStateMap = super.loadIPLData(IPLRuns.class, csvFilePath[0]);
            if (csvFilePath.length == 2)
                this.loadBowlerData(censusStateMap, csvFilePath[1]);
            return censusStateMap;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IPLAnalyserException(e.getMessage(), IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    public int loadBowlerData(Map<String, IPLDAO> ipldaoMap, String csvFilePath) throws IPLAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSvBuilder csvBuilder = CSVBuilderFactory.createCsvBuilder();
            Iterator<IPLWickets> iplWicketsIterator = csvBuilder.getFileByIterator(reader, IPLWickets.class);
            Iterable<IPLWickets> iplWicketsIterable = () -> iplWicketsIterator;
            StreamSupport.stream(iplWicketsIterable.spliterator(), false)
                    .filter(iplWickets -> ipldaoMap.get(iplWickets.playerName) != null)
                    .forEach(iplData -> {
                        ipldaoMap.get(iplData.playerName).averageOfBowler = iplData.avgOfBowler;
                        ipldaoMap.get(iplData.playerName).wicketsTaken = iplData.wicketsTaken;
                    });
            return ipldaoMap.size();
        } catch (IOException | CsvBuilderException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new IPLAnalyserException(e.getMessage(), IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
}
