package com.iplanaylser;

import java.util.Map;

public class IPLWicketAdapter extends IPLAdapter {
    @Override
    public Map loadIPLData(IPLAnalyser.Innings innings, String csvFilePath) throws IPLAnalyserException {
        return this.loadIPLData(IPLWickets.class,csvFilePath);
    }
}
