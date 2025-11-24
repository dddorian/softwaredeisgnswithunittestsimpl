package org.example.gameoflife;

import java.util.List;

import static org.example.gameoflife.Cell.State.LIVE;

public class GameOfLife {
    private final Cell[][] grid;
    private final int size;

     GameOfLife(List<Cell> inputCells, int size) {
        this.grid = new Cell[size][size];
        this.size = size;
        for (int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                grid[i][j] = new Cell(i,j);
            }
        }
        for(Cell cell : inputCells){
            getCellAt(cell.getRow(), cell.getColumn()).setCellState(LIVE);
        }
    }

    public Cell getCellAt(int row, int column) {
         return grid[row][column];
    }
}
