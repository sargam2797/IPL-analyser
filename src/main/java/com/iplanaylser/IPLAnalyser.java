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

public class IPLAnalyser {
    Map<String,IPLRuns> iplRunsMap = new HashMap<>();
    public Map loadIPLData(String csvFilePath) throws IPLAnalyserException {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSvBuilder csvBuilder = CSVBuilderFactory.createCsvBuilder();
            Iterator<IPLRuns> iplCSVIterator = csvBuilder.getFileByIterator(reader, IPLRuns.class);
            Iterable<IPLRuns> csvIterable = () -> iplCSVIterator;
            StreamSupport.stream(csvIterable.spliterator(),false)
                    .map(IPLRuns.class::cast)
                    .forEach(iplRuns -> iplRunsMap.put(iplRuns.player, new IPLRuns(iplRuns)));
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
