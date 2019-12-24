package com.iplanaylser;

public class IPLLoaderProvider {
    public static IPLAdapter getClassAdapterObject(IPLAnalyser.Innings innings) {
        if (innings.equals(innings.BATTING)) {
            return new IPLRunsAdapter();
        }
        return new IPLWicketAdapter();
    }
}
