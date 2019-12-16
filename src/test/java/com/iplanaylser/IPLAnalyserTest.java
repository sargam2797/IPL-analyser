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

    @Test
    public void givenIPLMostRunsSampleData_ShouldReturnThePlayerWithHighestStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLData(SAMPLE_IPL_DATA_CSV_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.STRIKING_RATE);
            IPLRuns[] iplRuns = new Gson().fromJson(sortByAverage, IPLRuns[].class);
            Assert.assertEquals("Ishant Sharma",iplRuns[0].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostRunsSampleData_ShouldReturnThePlayerWithHighest6sAnd4s() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLData(SAMPLE_IPL_DATA_CSV_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.MAX_4s_AND_6s);
            IPLRuns[] iplRuns = new Gson().fromJson(sortByAverage, IPLRuns[].class);
            Assert.assertEquals("Andre Russell",iplRuns[0].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostRunsSampleData_ShouldReturnThePlayerWithHighest6sAnd4s_WithBestStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLData(SAMPLE_IPL_DATA_CSV_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.MAX_4s_AND_6s_WITH_BEST_STRIKING_RATE);
            IPLRuns[] iplRuns = new Gson().fromJson(sortByAverage, IPLRuns[].class);
            Assert.assertEquals("Jonny Bairstow",iplRuns[0].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostRunsSampleData_ShouldReturnThePlayerWithGreatAverage_WithBestStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLData(SAMPLE_IPL_DATA_CSV_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.BEST_AVERAGE_WITH_STRIKE_RATE);
            IPLRuns[] iplRuns = new Gson().fromJson(sortByAverage, IPLRuns[].class);
            Assert.assertEquals("MS Dhoni",iplRuns[0].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostRunsSampleData_ShouldReturnThePlayerWithMaxRuns_WithBestAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLData(SAMPLE_IPL_DATA_CSV_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.MAX_RUNS_WITH_BEST_AVERAGE);
            IPLRuns[] iplRuns = new Gson().fromJson(sortByAverage, IPLRuns[].class);
            Assert.assertEquals("David Warner ",iplRuns[0].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
}
