package com.iplanaylser;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class IPLAnalyserTest {
    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "/home/admin1/IPL-Analyser/IPL-analyser/src/test/resources" +
            "/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_WICKETS_DATA_CSV_PATH = "/home/admin1/IPL-Analyser/IPL-analyser/src/test/resources/" +
            "IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPLMostRunsData_ShouldReturnHighestThePlayerWithHighestBattingAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Innings.BATTING);
            iplAnalyser.setIPLAdapter(iplAnalyser.getAdapterObject(IPLAnalyser.Innings.BATTING));
            iplAnalyser.loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_CSV_FILE_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.BATTING_AVERAGE);
            IPLRuns[] iplRuns = new Gson().fromJson(sortByAverage, IPLRuns[].class);
            Assert.assertEquals("MS Dhoni",iplRuns[0].playerName);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostRunsData_ShouldReturnThePlayerWithHighestStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Innings.BATTING);
            iplAnalyser.setIPLAdapter(iplAnalyser.getAdapterObject(IPLAnalyser.Innings.BATTING));
            iplAnalyser.loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_CSV_FILE_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.STRIKING_RATE);
            IPLRuns[] iplRuns = new Gson().fromJson(sortByAverage, IPLRuns[].class);
            Assert.assertEquals("Ishant Sharma",iplRuns[0].playerName);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostRuns_ShouldReturnThePlayerWithHighest6sAnd4s() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Innings.BATTING);
            iplAnalyser.setIPLAdapter(iplAnalyser.getAdapterObject(IPLAnalyser.Innings.BATTING));
            iplAnalyser.loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_CSV_FILE_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.MAX_4s_AND_6s);
            IPLRuns[] iplRuns = new Gson().fromJson(sortByAverage, IPLRuns[].class);
            Assert.assertEquals("Andre Russell",iplRuns[0].playerName);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostRunsData_ShouldReturnThePlayerWithHighest6sAnd4s_WithBestStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Innings.BATTING);
            iplAnalyser.setIPLAdapter(iplAnalyser.getAdapterObject(IPLAnalyser.Innings.BATTING));
            iplAnalyser.loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_CSV_FILE_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.MAX_4s_AND_6s_WITH_BEST_STRIKING_RATE);
            IPLRuns[] iplRuns = new Gson().fromJson(sortByAverage, IPLRuns[].class);
            Assert.assertEquals("Ishant Sharma",iplRuns[0].playerName);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostRunsData_ShouldReturnThePlayerWithGreatAverage_WithBestStrikingRate() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Innings.BATTING);
            iplAnalyser.setIPLAdapter(iplAnalyser.getAdapterObject(IPLAnalyser.Innings.BATTING));
            iplAnalyser.loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_CSV_FILE_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.BEST_AVERAGE_WITH_STRIKE_RATE);
            IPLRuns[] iplRuns = new Gson().fromJson(sortByAverage, IPLRuns[].class);
            Assert.assertEquals("MS Dhoni",iplRuns[0].playerName);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostRunsData_ShouldReturnThePlayerWithMaxRuns_WithBestAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Innings.BATTING);
            iplAnalyser.setIPLAdapter(iplAnalyser.getAdapterObject(IPLAnalyser.Innings.BATTING));
            iplAnalyser.loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_CSV_FILE_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.MAX_RUNS_WITH_BEST_AVERAGE);
            IPLRuns[] iplRuns = new Gson().fromJson(sortByAverage, IPLRuns[].class);
            Assert.assertEquals("David Warner ",iplRuns[0].playerName);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostWicketsData_ShouldReturnThePlayerWithTopBowlingAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Innings.BOWLING);
            iplAnalyser.setIPLAdapter(iplAnalyser.getAdapterObject(IPLAnalyser.Innings.BOWLING));
            iplAnalyser.loadIPLData(IPLAnalyser.Innings.BOWLING,IPL_WICKETS_DATA_CSV_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.BOWLING_AVERAGE);
            IPLWickets[] iplWickets = new Gson().fromJson(sortByAverage, IPLWickets[].class);
            Assert.assertEquals("Suresh Raina",iplWickets[0].playerName);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostWicketsData_ShouldReturnThePlayerWithTopStrikingRatesBowler() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Innings.BOWLING);
            iplAnalyser.setIPLAdapter(iplAnalyser.getAdapterObject(IPLAnalyser.Innings.BOWLING));
            iplAnalyser.loadIPLData(IPLAnalyser.Innings.BOWLING,IPL_WICKETS_DATA_CSV_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.TOP_BOWLING_STRIKING_RATES);
            IPLWickets[] iplWickets = new Gson().fromJson(sortByAverage, IPLWickets[].class);
            Assert.assertEquals("Suresh Raina",iplWickets[0].playerName);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostWicketsData_ShouldReturnThePlayerWithTopBowlingEconomyRates() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Innings.BOWLING);
            iplAnalyser.setIPLAdapter(iplAnalyser.getAdapterObject(IPLAnalyser.Innings.BOWLING));
            iplAnalyser.loadIPLData(IPLAnalyser.Innings.BOWLING,IPL_WICKETS_DATA_CSV_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.TOP_BOWLING_ECONOMY_RATES);
            IPLWickets[] iplWickets = new Gson().fromJson(sortByAverage, IPLWickets[].class);
            Assert.assertEquals("Shivam Dube",iplWickets[0].playerName);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostWicketsData_ShouldReturnThePlayerWithTopStrikingRates_WithMost4wAnd5w() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Innings.BOWLING);
            iplAnalyser.setIPLAdapter(iplAnalyser.getAdapterObject(IPLAnalyser.Innings.BOWLING));
            iplAnalyser.loadIPLData(IPLAnalyser.Innings.BOWLING,IPL_WICKETS_DATA_CSV_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.TOP_BOWLING_STRIKING_RATES_WITH_MOST_4Ws_AND_5Ws);
            IPLWickets[] iplWickets = new Gson().fromJson(sortByAverage, IPLWickets[].class);
            Assert.assertEquals("Lasith Malinga",iplWickets[0].playerName);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostWicketsData_ShouldReturnThePlayerWithBestBowlingAndBattingAverage() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Innings.BATTING);
            iplAnalyser.setIPLAdapter(iplAnalyser.getAdapterObject(IPLAnalyser.Innings.BATTING));
            iplAnalyser.loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_CSV_FILE_PATH,IPL_WICKETS_DATA_CSV_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.BEST_BATTING_BOWLING_AVERAGE);
            IPLWickets[] iplWickets = new Gson().fromJson(sortByAverage, IPLWickets[].class);
            Assert.assertEquals("Andre Russell",iplWickets[0].playerName);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostWicketsData_ShouldReturnThePlayerWhoIsAllRounder() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Innings.BATTING);
            iplAnalyser.setIPLAdapter(iplAnalyser.getAdapterObject(IPLAnalyser.Innings.BATTING));
            iplAnalyser.loadIPLData(IPLAnalyser.Innings.BATTING,IPL_MOST_RUNS_CSV_FILE_PATH,
                    IPL_WICKETS_DATA_CSV_PATH);
            String sortByAverage = iplAnalyser.sortByFields(SortingFields.ALL_ROUNDER);
            IPLWickets[] iplWickets = new Gson().fromJson(sortByAverage, IPLWickets[].class);
            Assert.assertEquals("Hardik Pandya",iplWickets[0].playerName);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
}
