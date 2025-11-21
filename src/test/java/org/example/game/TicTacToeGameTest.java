package org.example.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeGameTest {

    private TicTacToeGame game;

    @BeforeEach
    void init(){
        game  = new TicTacToeGame();
    }
    @Test
    void canary(){
        assertTrue(true);
    }

    @Test
    void firstPlayerPlacesFirstPeg(){
        //Arrange

        //Act
        game.placePegAt(1,2);
        //Assert
        assertEquals(Peg.FIRST, game.pegAt(1,2));
    }

    @Test
    void secondPlayerPlacesFirstPeg(){
        game.placePegAt(1,2);

        game.placePegAt(2,1);

        assertEquals(Peg.SECOND, game.pegAt(2,1));
    }
}
