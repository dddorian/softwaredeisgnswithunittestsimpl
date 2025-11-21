package org.example.game;

public class TicTacToeGame {
    private final int size;
    private final Peg[][] grid;

    public TicTacToeGame(int size) {
        this.size = size;
        this.grid = new Peg[size][size];;
    }

    public void placePegAt(int row , int column) {
    }

    public Peg pegAt(int row, int column) {
        return this.lastPeg == Peg.FIRST ? Peg.SECOND : Peg.FIRST;
    }
}
