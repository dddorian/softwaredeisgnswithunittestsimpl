package org.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeGameTest {

    private TicTacToeGame game;

    @BeforeEach
    void init() {
        game = new TicTacToeGame(3);
    }

    @Test
    void canary() {
        assertTrue(true);
    }

    @Test
    void firstPlayerPlacesFirstPeg() {
        //Arrange

        //Act
        game.placePegAt(1, 2);
        //Assert
        assertEquals(Peg.FIRST, game.pegAt(1, 2));
    }

    @Test
    void secondPlayerPlacesFirstPeg() {
        game.placePegAt(1, 2);

        game.placePegAt(2, 1);

        assertEquals(Peg.SECOND, game.pegAt(2, 1));
    }

    @Test
    void firstPlayerPlaysSecondPeg() {
        //arrange
        game.placePegAt(1, 2);
        game.placePegAt(2, 1);
        //act
        game.placePegAt(1, 0);
        //assert
        assertEquals(Peg.FIRST, game.pegAt(1, 0));
    }

    @Test
    void secondPlayerPlaysSecondPeg() {
        //arrange
        game.placePegAt(1, 2);
        game.placePegAt(2, 1);
        game.placePegAt(1, 0);

        //act
        game.placePegAt(0, 1);
        //assert
        assertEquals(Peg.SECOND, game.pegAt(0, 1));
    }

    @Test
    void placePegAtOccupiedPosition() {
        TicTacToeException ticTacToeException = assertThrows(TicTacToeException.class,
                () -> game.placePegAt(1, 0));

        assertEquals("Cell (1,0) is already occupied", ticTacToeException.getMessage());
    }
}
