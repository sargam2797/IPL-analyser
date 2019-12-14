package com.iplanaylser;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class IPLAnalyserTest {
    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/resources" +
            "/IPL2019FactsheetMostRuns.csv";

    private static final String IPL_MOST_RUNS_WRONG_CSV_FILE_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/" +
            "resources/IPL2019FactsheetMostRuns1.csv";

    private static final String IPL_MOST_RUNS_WRONG_EXT_CSV_FILE_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/" +
            "resources/IPL2019FactsheetMostRuns.txt";
    private static final String IPL_MOST_RUNS_DELIMITER_CSV_FILE_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/" +
            "resources/IPL2019FactsheetMostRunsDelimiter.csv";
    private static final String IPL_MOST_RUNS_HEADER_CSV_FILE_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/" +
            "resources/IPL2019FactsheetMostRunsHeader.csv";
    private static final String IPL_MOST_RUNS_EMPTY_CSV_FILE_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/" +
            "resources/IPL2019FactsheetMostRunsEmpty.csv";
    private static final String SAMPLE_IPL_DATA_CSV_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/resources/" +
            "sampleIPLData.csv";

    @Test
    public void givenIPLMostRunsData_ReturnsExactNoOfPlayersCount() {
        try {
            Map playerCount = new IPLAnalyser().loadIPLData(SAMPLE_IPL_DATA_CSV_PATH);
            Assert.assertEquals(8,playerCount.size());
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenWrongIPLMostRunsCSVFile_ShouldThrowIPLAnalyserException() {
        try {
            new IPLAnalyser().loadIPLData(IPL_MOST_RUNS_WRONG_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenCorrectIPLMostRunsCSVFile_ButWrongExtension_ShouldThrowIPLAnalyserException() {
        try {
            new IPLAnalyser().loadIPLData(IPL_MOST_RUNS_WRONG_EXT_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenCorrectIPLMostRunsCSVFile_ButWrongDelimiter_ShouldThrowIPLAnalyserException() {
        try {
            new IPLAnalyser().loadIPLData(IPL_MOST_RUNS_DELIMITER_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.ISSUE_RELATED_TO_FILE, e.type);
        }
    }

    @Test
    public void givenCorrectIPLMostRunsCSVFile_ButMissingHeaders_ShouldThrowIPLAnalyserException() {
        try {
            new IPLAnalyser().loadIPLData(IPL_MOST_RUNS_HEADER_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.ISSUE_RELATED_TO_FILE, e.type);
        }
    }

    @Test
    public void givenEmptyIPLMostRunsCSVFile_ButMissingHeaders_ShouldThrowIPLAnalyserException() {
        try {
            new IPLAnalyser().loadIPLData(IPL_MOST_RUNS_EMPTY_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.ISSUE_RELATED_TO_FILE, e.type);
        }
    }

    @Test
    public void givenIPLMostRunsSampleData_ShouldReturnHighestThePlayerWithHighestBattingAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLData(SAMPLE_IPL_DATA_CSV_PATH);
            String sortbyBattingAverage = iplAnalyser.sortbyFields(SortingFields.Parameter.AVERAGE);
            IPLRuns[] iplRuns = new Gson().fromJson(sortbyBattingAverage, IPLRuns[].class);
            Assert.assertEquals("MS Dhoni",iplRuns[0].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

}
