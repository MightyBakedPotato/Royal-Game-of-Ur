package GameOfUr;

import javax.swing.*;

public class GameOfUr {

    public static void main(String args[]){

        Player whitePlayer = new Player("whitePlayer");

        //FACTORY per GUI e Board

        GUI gui = new GUI();

        Board board = new Board();

        board.setGUI(gui);
        gui.setModel(board);

        board.moveGP(whitePlayer.getPlayerID(),0, 4);

    }
}