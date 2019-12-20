package com.iplanaylser;

import java.util.Map;

public class IPLRunsAdapter extends IPLAdapter {

    @Override
    public Map loadIPLData(IPLAnalyser.Innings innings, String csvFilePath) throws IPLAnalyserException {
        return this.loadIPLData(IPLRuns.class,csvFilePath);
    }
}
