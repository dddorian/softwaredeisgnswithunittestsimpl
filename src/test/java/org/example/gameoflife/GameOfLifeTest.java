package org.example.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.gameoflife.Cell.State.LIVE;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GameOfLifeTest {
    private GameOfLife gameOfLife;

    @BeforeEach
    void init(){
    }

    @Test
    void gameIsProperlyInitialisedBasedOnInput(){//the input cells are all live;
        gameOfLife = new GameOfLife(List.of(new Cell(1,0), new Cell(0,0), new Cell(0,1), new Cell(1,1)), 4);
        assertEquals(LIVE, gameOfLife.getCellAt(1,0).getCellState());
    }

    @Test
    void gameCanGetLiveNeighboursForCell(){
        gameOfLife = new GameOfLife(List.of(new Cell(1,0), new Cell(0,0), new Cell(0,1),
                new Cell(1,1)), 3);
        assertEquals(List.of(gameOfLife.getCellAt(0,1), gameOfLife.getCellAt(1,0),
                gameOfLife.getCellAt(1,1)), gameOfLife.getLiveNeighbours(0,0));
        assertEquals(List.of(gameOfLife.getCellAt(0,0), gameOfLife.getCellAt(0,1),
                gameOfLife.getCellAt(1,1)), gameOfLife.getLiveNeighbours(1,0));
        assertEquals(List.of(gameOfLife.getCellAt(0,0), gameOfLife.getCellAt(1,0),
                gameOfLife.getCellAt(1,1)), gameOfLife.getLiveNeighbours(0,1));
        assertEquals(List.of(gameOfLife.getCellAt(0,0), gameOfLife.getCellAt(0,1),
                gameOfLife.getCellAt(1,0)), gameOfLife.getLiveNeighbours(1,1));
    }
}