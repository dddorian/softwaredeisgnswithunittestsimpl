package org.example.gameoflife;

public class Cell {
    private  final int row;
    private final int column;
    private State cellState;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.cellState = State.DEAD;
    }

    public void setCellState(State cellState) {
        this.cellState = cellState;
    }

    public State getCellState() {
        return cellState;
    }

    static enum State {LIVE, DEAD};
}
