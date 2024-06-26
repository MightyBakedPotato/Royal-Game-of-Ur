package GameOfUr;

import javax.swing.*;

public class GameOfUr {

    public static void main(String args[]){

        Player whitePlayer = new Player("whitePlayer");
        Player blackPlayer = new Player("blackPlayer");

        //FACTORY per GUI e Board

        GUI gui = new GUI();

        Board board = new Board();

        board.setPlayers(whitePlayer, blackPlayer);
        board.setGUI(gui);
        gui.setModel(board);
        
        TurnManager turnManager = new TurnManager(whitePlayer, blackPlayer, board);

        board.setTurnManager(turnManager);

        //board.currentPlayer = whitePlayer;

        board.diceRoll = 3;

    }
}