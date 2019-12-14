package com.iplanaylser;

import com.opencsv.bean.CsvBindByName;

import java.util.stream.Stream;

public class IPLRuns {
    public IPLRuns() {
    }

    @CsvBindByName(column = "POS")
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int match;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "NO", required = true)
    public int no;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public String highScore;

    @CsvBindByName(column = "Avg", required = true)
    public double avg;

    @CsvBindByName(column = "BF", required = true)
    public int ballFaced;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "100", required = true)
    public int hundreds;

    @CsvBindByName(column = "50", required = true)
    public int fiftys;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

    @CsvBindByName(column = "6s", required = true)
    public int sixes;

    public IPLRuns(IPLRuns iplRuns) {
        this.pos = iplRuns.pos;
        this.avg = iplRuns.avg;
        this.player =iplRuns.player;
        this.match = iplRuns.match;
        this.innings = iplRuns.innings;
        this.no = iplRuns.no;
        this.runs = iplRuns.runs;
        this.highScore = iplRuns.highScore;
        this.ballFaced = iplRuns.ballFaced;
        this.strikeRate = iplRuns.strikeRate;
        this.hundreds = iplRuns.hundreds;
        this.fiftys = iplRuns.fiftys;
        this.fours = iplRuns.fours;
        this.sixes = iplRuns.sixes;
    }
}
