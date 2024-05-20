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

        board.moveGP(whitePlayer,0, 6);
        board.moveGP(blackPlayer,0, 6);

        board.moveGP(whitePlayer,0, 8);
        board.moveGP(blackPlayer,0, 8);

    }
}