package org.example.tictactoe;

public class TicTacToeGame {
    private final int SIZE;
    private final Peg[][] grid;
    private Peg nextPegToPlay;

    public TicTacToeGame(int size) {
        this.SIZE = size;
        this.grid = new Peg[size][size];
        this.nextPegToPlay = Peg.FIRST;
        initialiseGrid();
    }

    private void initialiseGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = Peg.EMPTY;
            }
        }
    }

    public void placePegAt(int row, int column) {
        if (grid[row][column] != null) {
            throw new TicTacToeException(String.format("Cell (%s,%s) is already occupied", row, column));
        }
        grid[row][column] = nextPegToPlay;
        switchNextPegToPlay();
    }

    void switchNextPegToPlay() {
        nextPegToPlay = nextPegToPlay == Peg.FIRST ? Peg.SECOND : Peg.FIRST;
    }

    public Peg pegAt(int row, int column) {
        return grid[row][column];
    }
}
