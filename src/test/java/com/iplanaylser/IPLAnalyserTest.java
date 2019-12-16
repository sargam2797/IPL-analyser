package com.iplanaylser;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class IPLAnalyserTest {

    private static final String SAMPLE_IPL_DATA_CSV_PATH = "/home/user/IdeaProjects/IPL-analyser/src/test/resources/" +
            "sampleIPLData.csv";

    @Test
    public void givenIPLMostRunsSampleData_ShouldReturnHighestThePlayerWithHighestBattingAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLData(SAMPLE_IPL_DATA_CSV_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.AVERAGE);
            IPLRuns[] iplRuns = new Gson().fromJson(sortByAverage, IPLRuns[].class);
            Assert.assertEquals("MS Dhoni",iplRuns[0].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
}
