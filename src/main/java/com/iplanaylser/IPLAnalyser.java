package com.iplanaylser;

import com.CSVBuilderFactory;
import com.CsvBuilderException;
import com.ICSvBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class IPLAnalyser {

    public int loadIPLData(String csvFilePath) throws IPLAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSvBuilder csvBuilder = CSVBuilderFactory.createCsvBuilder();
            Iterator<IPLRuns> iplCSVIterator = csvBuilder.getFileByIterator(reader, IPLRuns.class);
            Iterable<IPLRuns> csvIterable = () -> iplCSVIterator;
            int playerCount = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return playerCount;
        } catch (IOException e) {
            throw new IPLAnalyserException("invalid file path",
                    IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (CsvBuilderException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
