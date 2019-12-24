package com.iplanaylser;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPLAdapterTest {
    private static final String IPL_CSV_FILE = "/home/admin1/IPL-Analyser/IPL-analyser/src/test/resources/IPL2019Fact" +
            "sheetMostRuns.csv";
    private static final String IPL_WICKETS_CSV_FILE_PATH = "/home/admin1/IPL-Analyser/IPL-analyser/src/test/" +
            "resources/IPL2019FactsheetMostWkts.csv";
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    private HashMap<Object, Object> map;

    public void create() {
        this.map = new HashMap<>();
        this.map.put("perosn1", new IPLDAO("Abc", 123, 23.5));
        this.map.put("person2", new IPLDAO("def", 123, 23.5));
        this.map.put("person3", new IPLDAO("ghi", 123, 23.5));
    }

    @Test
    public void GivenIPLRunsData_WhenCorrect_ShouldReturnExactSize() {
        IPLAdapter iplAdapter = mock(IPLRunsAdapter.class);
        try {
            create();
            when(iplAdapter.loadIPLData(IPLAnalyser.Innings.BATTING,IPL_CSV_FILE)).thenReturn(this.map);
            iplAdapter.loadIPLData(IPLAnalyser.Innings.BATTING,IPL_CSV_FILE);
            Assert.assertEquals(3,map.size());
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void GivenIPLWicketsData_WhenCorrect_ShouldReturnExactSize() {
        IPLAdapter iplAdapter = mock(IPLWicketAdapter.class);
        try {
            create();
            when(iplAdapter.loadIPLData(IPLAnalyser.Innings.BOWLING,IPL_WICKETS_CSV_FILE_PATH)).thenReturn(this.map);
            iplAdapter.loadIPLData(IPLAnalyser.Innings.BOWLING,IPL_WICKETS_CSV_FILE_PATH);
            Assert.assertEquals(3,map.size());
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
}
