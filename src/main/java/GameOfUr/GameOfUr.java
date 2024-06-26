package GameOfUr;

import javax.swing.*;

public class GameOfUr {

    public static void main(String args[]){

        Player whitePlayer = new Player("white");
        Player blackPlayer = new Player("black");

        //FACTORY per GUI e Board

        GUI gui = new GUI();

        Board board = new Board();

        board.setPlayers(whitePlayer, blackPlayer);
        board.setGUI(gui);
        gui.setModel(board);

    }
}