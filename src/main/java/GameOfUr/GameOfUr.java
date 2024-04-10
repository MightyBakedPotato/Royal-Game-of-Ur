package GameOfUr;

import javax.swing.*;
import java.lang.reflect.Array; 



public class GameOfUr {

    public static void main(String args[]){

        Tile thirdTile = new Tile(null);
        Tile secondTile = new Tile(thirdTile);
        Tile tile = new Tile(secondTile);

        Player playerOne = new Player("playerOne");

        GamePiece gp = new GamePiece(tile, playerOne);

        System.out.println(gp.locateGP()+gp.getGPplayer());

        gp.moveGP();

        System.out.println(gp.locateGP()+gp.getGPplayer());

        gp.moveGP();

        System.out.println(gp.locateGP()+gp.getGPplayer());

        Tile[] tiles = {tile, secondTile, thirdTile};

        GUI gui = new GUI(tiles);
        
    }
}