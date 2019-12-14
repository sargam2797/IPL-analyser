package com.iplanaylser;

import org.junit.Assert;
import org.junit.Test;

public class IPLAnalyserTest {
    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/resources" +
            "/IPL2019FactsheetMostRuns.csv";
    @Test
    public void givenIPLMostRunsData_ReturnsExactNoOfPlayersCount() {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        int playerCount = iplAnalyser.loadIPLData(IPL_MOST_RUNS_CSV_FILE_PATH);
        Assert.assertEquals(101,playerCount);
    }
}
