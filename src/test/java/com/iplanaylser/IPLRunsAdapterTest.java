package com.iplanaylser;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class IPLRunsAdapterTest {
    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "/home/admin1/IPL-Analyser/IPL-analyser/src/test/" +
            "resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_MOST_RUNS_WRONG_CSV_FILE_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/" +
            "resources/IPL2019FactsheetMostRuns1.csv";
    private static final String IPL_MOST_RUNS_WRONG_EXT_CSV_FILE_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/" +
            "resources/IPL2019FactsheetMostRuns.txt";
    private static final String IPL_MOST_RUNS_DELIMITER_CSV_FILE_PATH = "/home/admin1/Downloads/IPL-analyser-master/src/" +
            "test/resources/IPL2019FactsheetMostRunsDelimiter.csv";
    private static final String IPL_MOST_RUNS_HEADER_CSV_FILE_PATH = "/home/admin1/Downloads/IPL-analyser-master/src/" +
            "test/resources/IPL2019FactsheetMostRunsHeader.csv";
    private static final String IPL_MOST_RUNS_EMPTY_CSV_FILE_PATH = "/home/admin1/Downloads/IPL-analyser-master/src/" +
            "test/resources/IPL2019FactsheetMostRunsEmpty.csv";

    @Test
    public void givenIPLMostRunsData_ReturnsExactNoOfPlayersCount() {
        try {
            Map playerCount = new IPLRunsAdapter().loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(100,playerCount.size());
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenWrongIPLMostRunsCSVFile_ShouldThrowIPLAnalyserException() {
        try {
            new IPLRunsAdapter().loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_WRONG_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenCorrectIPLMostRunsCSVFile_ButWrongExtension_ShouldThrowIPLAnalyserException() {
        try {
            new IPLRunsAdapter().loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_WRONG_EXT_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenCorrectIPLMostRunsCSVFile_ButWrongDelimiter_ShouldThrowIPLAnalyserException() {
        try {
            new IPLRunsAdapter().loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_DELIMITER_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.ISSUE_RELATED_TO_FILE, e.type);
        }
    }

    @Test
    public void givenCorrectIPLMostRunsCSVFile_ButMissingHeaders_ShouldThrowIPLAnalyserException() {
        try {
            new IPLRunsAdapter().loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_HEADER_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.ISSUE_RELATED_TO_FILE, e.type);
        }
    }

    @Test
    public void givenEmptyIPLMostRunsCSVFile_ButMissingHeaders_ShouldThrowIPLAnalyserException() {
        try {
            new IPLRunsAdapter().loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_EMPTY_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.ISSUE_RELATED_TO_FILE, e.type);
        }
    }
}
