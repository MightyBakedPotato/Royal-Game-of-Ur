package GameOfUr;

import javax.swing.*;

public class GameOfUr {

    public static void main(String args[]){

        Player whitePlayer = new Player("whitePlayer");

        //FACTORY per GUI e Board

        GUI gui = new GUI();

        Board board = new Board();

        // set di GUI e Board nelle relative classi (per passare Gui a Board, e Board a GUI)
        // poi usare questi metodi in main

        board.moveGP(whitePlayer.getPlayerID(),0, 4);

        board.getWhiteGPs();
        board.getWhiteTiles();

        board.testPrint();

    }
}