package com.iplanaylser;

public class IPLAnalyserException extends Exception {
    public enum ExceptionType {
        CENSUS_FILE_PROBLEM, ISSUE_RELATED_TO_FILE, NO_DATA;
    }
    ExceptionType type;

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
