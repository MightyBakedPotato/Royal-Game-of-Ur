package GameOfUr;

import java.lang.reflect.Array;

class Board{

	private Tile[] whiteTiles;
	private Tile[] blackTiles;
	private int[] whiteGPs;
	private int[] blackGPs;

	public void getWhiteTiles(){
		for (Tile i : whiteTiles) {
            System.out.println(i);
        }
	}

	public Tile[] getBlackTiles(){
		return blackTiles;
	}

	public int[] getWhiteGPs(){
		return whiteGPs;
	}

	public int[] getBlackGPs(){
		return blackGPs;
	}

	private void setTiles(){

		Tile startTile_white = new Tile();
		whiteTiles[0] = startTile_white;
		Tile tile1_white = new Tile();
		whiteTiles[1] = tile1_white;
		Tile tile2_white = new Tile();
		whiteTiles[2] = tile2_white;
		Tile tile3_white = new Tile();
		whiteTiles[3] = tile3_white;
		Tile tile4_white = new Tile();
		whiteTiles[4] = tile4_white;

		Tile startTile_black = new Tile();
		blackTiles[0] = startTile_black;
		Tile tile1_black = new Tile();
		blackTiles[1] = tile1_black;
		Tile tile2_black = new Tile();
		blackTiles[2] = tile2_black;
		Tile tile3_black = new Tile();
		blackTiles[3] = tile3_black;
		Tile tile4_black = new Tile();
		blackTiles[4] = tile4_black;

		Tile midTile5 = new Tile();
		blackTiles[5] = midTile5;
		whiteTiles[5] = midTile5;
		Tile midTile6 = new Tile();
		blackTiles[6] = midTile6;
		whiteTiles[6] = midTile6;
		Tile midTile7 = new Tile();
		blackTiles[7] = midTile7;
		whiteTiles[7] = midTile7;
		Tile midTile8 = new Tile();
		blackTiles[8] = midTile8;
		whiteTiles[8] = midTile8;
		Tile midTile9 = new Tile();
		blackTiles[9] = midTile9;
		whiteTiles[9] = midTile9;
		Tile midTile10 = new Tile();
		blackTiles[10] = midTile10;
		whiteTiles[10] = midTile10;
	
		Tile tile11_white = new Tile();
		whiteTiles[11] = tile11_white;
		Tile tile12_white = new Tile();
		whiteTiles[12] = tile12_white;
		Tile endTile_white = new Tile();
		whiteTiles[13] = endTile_white;
	
		Tile tile11_black = new Tile();
		blackTiles[11] = tile11_black;
		Tile tile12_black = new Tile();
		blackTiles[12] = tile12_black;
		Tile endTile_black = new Tile();
		blackTiles[13] = endTile_black;
	}

	public void setGPs(){

		whiteGPs[0] = 0;
		whiteGPs[1] = 0;
		whiteGPs[2] = 0;
		whiteGPs[3] = 0;
		whiteGPs[4] = 0;
		whiteGPs[5] = 0;
		whiteGPs[6] = 0;

		blackGPs[0] = 0;
		blackGPs[1] = 0;
		blackGPs[2] = 0;
		blackGPs[3] = 0;
		blackGPs[4] = 0;
		blackGPs[5] = 0;
		blackGPs[6] = 0;
		
	}

	Board(){
		this.whiteTiles = new Tile[14];
		this.blackTiles = new Tile[14];

		this.whiteGPs = new int[7];
		this.blackGPs = new int[7];
		
		this.setTiles();
		this.setGPs();
		}

}