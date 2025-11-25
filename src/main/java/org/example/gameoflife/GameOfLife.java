package org.example.gameoflife;

import java.util.ArrayList;
import java.util.List;

import static org.example.gameoflife.Cell.State.LIVE;

public class GameOfLife {
    private final Cell[][] grid;
    private final int size;

    GameOfLife(List<Cell> inputCells, int size) {
        this.grid = new Cell[size][size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
        for (Cell cell : inputCells) {
            getCellAt(cell.getRow(), cell.getColumn()).setCellState(LIVE);
        }
    }

    public Cell getCellAt(int row, int column) {
        if (row >= 0 && column < size) {
            return grid[row][column];
        }
        throw new GameOfLifeException(String.format("The cell %s, %s is outside the game range.", row, column));
    }

    List<Cell> getLiveNeighbours(int row, int column) {
        List<Cell> liveNeighbours = new ArrayList<>(8);
        for (int i = Math.max(0, row - 1); i <= Math.min(size - 1, row + 1); i++) {
            for (int j = Math.max(0, column - 1); j <= Math.min(size - 1, column + 1); j++) {
                if ((i != row || j != column) && getCellAt(i, j).getCellState() == LIVE) {
                    liveNeighbours.add(getCellAt(i, j));
                }
            }
        }
        return liveNeighbours;
    }
}
