package GameOfUr;

import java.util.ArrayList;

class Board{

	private ArrayList<Tile> whiteTiles;
	private ArrayList<Tile> blackTiles;
	private ArrayList<GamePiece> whiteGP;
	private ArrayList<GamePiece> blackGP;

	Board(){

		Tile startTile_white = new Tile();
		whiteTiles.add(startTile_white);
		Tile tile1_white = new Tile();
		whiteTiles.add(tile1_white);
		Tile tile2_white = new Tile();
		whiteTiles.add(tile2_white);
		Tile tile3_white = new Tile();
		whiteTiles.add(tile3_white);
		Tile tile4_white = new Tile();
		whiteTiles.add(tile4_white);

		Tile startTile_black = new Tile();
		blackTiles.add(startTile_black);
		Tile tile1_black = new Tile();
		blackTiles.add(tile1_black);
		Tile tile2_black = new Tile();
		blackTiles.add(tile2_black);
		Tile tile3_black = new Tile();
		blackTiles.add(tile3_black);
		Tile tile4_black = new Tile();
		blackTiles.add(tile4_black);

		Tile midTile5 = new Tile();
		blackTiles.add(midTile5);
		whiteTiles.add(midTile5);
		Tile midTile6 = new Tile();
		blackTiles.add(midTile6);
		whiteTiles.add(midTile6);
		Tile midTile7 = new Tile();
		blackTiles.add(midTile7);
		whiteTiles.add(midTile7);
		Tile midTile8 = new Tile();
		blackTiles.add(midTile8);
		whiteTiles.add(midTile8);
		Tile midTile9 = new Tile();
		blackTiles.add(midTile9);
		whiteTiles.add(midTile9);
		Tile midTile10 = new Tile();
		blackTiles.add(midTile10);
		whiteTiles.add(midTile10);
	
		Tile tile11_white = new Tile();
		whiteTiles.add(tile11_white);
		Tile tile12_white = new Tile();
		whiteTiles.add(tile12_white);
		Tile endTile_white = new Tile();
		whiteTiles.add(endTile_white);
	
		Tile tile11_black = new Tile();
		blackTiles.add(tile11_black);
		Tile tile12_black = new Tile();
		blackTiles.add(tile12_black);
		Tile endTile_black = new Tile();
		blackTiles.add(endTile_black);
	}

}