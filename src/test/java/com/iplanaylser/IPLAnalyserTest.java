package com.iplanaylser;

import org.junit.Assert;
import org.junit.Test;

public class IPLAnalyserTest {
    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/resources" +
            "/IPL2019FactsheetMostRuns.csv";

    private static final String IPL_MOST_RUNS_WRONG_CSV_FILE_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/resources" +
            "/IPL2019FactsheetMostRuns1.csv";

    private static final String IPL_MOST_RUNS_WRONG_EXT_CSV_FILE_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/resources" +
            "/IPL2019FactsheetMostRuns.txt";

    @Test
    public void givenIPLMostRunsData_ReturnsExactNoOfPlayersCount() {
        try {
            int playerCount = new IPLAnalyser().loadIPLData(IPL_MOST_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(101,playerCount);
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
}
