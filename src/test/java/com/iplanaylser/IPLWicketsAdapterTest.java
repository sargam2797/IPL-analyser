package com.iplanaylser;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class IPLWicketsAdapterTest {
    private static final String IPL_MOST_WICKETS_CSV_FILE_PATH = "/home/admin1/IPL-Analyser/IPL-analyser/src/test/" +
            "resources/IPL2019FactsheetMostWkts.csv";
    private static final String IPL_MOST_WICKETS_WRONG_CSV_FILE_PATH = "/home/admin1/IPL-Analyser/IPL-analyser/src/test/" +
            "resources/IPL2019FactsheetMostWkts1.csv";
    private static final String IPL_MOST_WICKETS_WRONG_EXT_CSV_FILE_PATH = "/home/admin1/IPL-Analyser/IPL-analyser/src/test/" +
            "resources/IPL2019FactsheetMostWkts.txt";
    private static final String IPL_MOST_WICKETS_CSV_FILE_PATH_DELIMITER = "/home/admin1/IPL-Analyser/IPL-analyser/src/" +
            "test/resources/IPL2019FactsheetMostWktsDelimiter.csv";
    private static final String IPL_MOST_WICKETS_HEADER_CSV_FILE_PATH = "/home/admin1/IPL-Analyser/IPL-analyser/src/test/" +
            "resources/IPL2019FactsheetMostWktsHeader.csv";
    private static final String IPL_MOST_WICKETS_EMPTY_CSV_FILE_PATH = "/home/admin1/IPL-Analyser/IPL-analyser/src/test" +
            "/resources/IPL2019FactsheetMostWktsEmpty.csv";

    @Test
    public void givenIPLMostRunsData_ReturnsExactNoOfPlayersCount() {
        try {
            Map playerCount = new IPLWicketAdapter().loadIPLData(IPLAnalyser.Innings.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
            Assert.assertEquals(100,playerCount.size());
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenWrongIPLMostRunsCSVFile_ShouldThrowIPLAnalyserException() {
        try {
            new IPLWicketAdapter().loadIPLData(IPLAnalyser.Innings.BOWLING,IPL_MOST_WICKETS_WRONG_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenCorrectIPLMostRunsCSVFile_ButWrongExtension_ShouldThrowIPLAnalyserException() {
        try {
            new IPLWicketAdapter().loadIPLData(IPLAnalyser.Innings.BOWLING,IPL_MOST_WICKETS_WRONG_EXT_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenCorrectIPLMostRunsCSVFile_ButWrongDelimiter_ShouldThrowIPLAnalyserException() {
        try {
            new IPLWicketAdapter().loadIPLData(IPLAnalyser.Innings.BOWLING,IPL_MOST_WICKETS_CSV_FILE_PATH_DELIMITER);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.ISSUE_RELATED_TO_FILE, e.type);
        }
    }

    @Test
    public void givenCorrectIPLMostRunsCSVFile_ButMissingHeaders_ShouldThrowIPLAnalyserException() {
        try {
            new IPLWicketAdapter().loadIPLData(IPLAnalyser.Innings.BOWLING, IPL_MOST_WICKETS_HEADER_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.ISSUE_RELATED_TO_FILE, e.type);
        }
    }

    @Test
    public void givenEmptyIPLMostRunsCSVFile_ButMissingHeaders_ShouldThrowIPLAnalyserException() {
        try {
            new IPLWicketAdapter().loadIPLData(IPLAnalyser.Innings.BOWLING,IPL_MOST_WICKETS_EMPTY_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.ISSUE_RELATED_TO_FILE, e.type);
        }
    }
}
