package GameOfUr;

import javax.swing.*;

public class GameOfUr {

    public static void main(String args[]){

        Player whitePlayer = new Player("whitePlayer");

        GUI gui = new GUI();

        Board board = new Board();

        board.moveGP(whitePlayer.getPlayerID(),0, 4);

        board.getWhiteGPs();
        board.getWhiteTiles();


    }
}