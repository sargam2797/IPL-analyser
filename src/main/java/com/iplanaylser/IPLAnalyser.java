package com.iplanaylser;

import com.CSVBuilderFactory;
import com.CsvBuilderException;
import com.ICSvBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class IPLAnalyser {

    public int loadIPLData(String csvFilePath) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSvBuilder csvBuilder = CSVBuilderFactory.createCsvBuilder();
            Iterator<IPLRuns> iplCSVIterator = csvBuilder.getFileByIterator(reader, IPLRuns.class);
            int playerCount = 0;
            while (iplCSVIterator.hasNext()) {
                playerCount++;
                IPLRuns iplRuns = iplCSVIterator.next();
            }
            return playerCount;
        } catch (CsvBuilderException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
