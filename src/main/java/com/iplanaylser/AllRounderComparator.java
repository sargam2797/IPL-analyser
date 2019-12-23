package com.iplanaylser;

public class AllRounderComparator implements java.util.Comparator<IPLDAO> {
    @Override
    public int compare(IPLDAO ipldao1, IPLDAO ipldao2) {
        return ((ipldao1.runsScored*(ipldao1.wicketsTaken))-
                (ipldao2.runsScored*(ipldao2.wicketsTaken)));
    }
}
