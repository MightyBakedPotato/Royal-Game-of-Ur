package GameOfUr;

import java.lang.reflect.Array;
import GameOfUr.BoardStatus;
import GameOfUr.BoardStatus.TileState;

class Board{

	private Tile[] whiteTiles;
	private Tile[] blackTiles;
	private int[] whiteGPs;
	private int[] blackGPs;
	private BoardStatus status;

	public void getWhiteTiles(){
		for (Tile i : whiteTiles) {
            System.out.println(i.isEmpty);
        }
	}

	public void getBlackTiles(){
			for (Tile i : blackTiles) {
            	System.out.println(i.isEmpty);
            }
	}

	public void getWhiteGPs(){
		for (int i: whiteGPs){
			System.out.println(i);
		}
	}

	public void getBlackGPs(){
		for (int i:blackGPs){
			System.out.println(i);
		}
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
		Tile midTile11 = new Tile();
		blackTiles[11] = midTile11;
		whiteTiles[11] = midTile11;
		Tile midTile12 = new Tile();
		blackTiles[12] = midTile12;
		whiteTiles[12] = midTile12;
	
		Tile tile13_white = new Tile();
		whiteTiles[13] = tile13_white;
		Tile tile14_white = new Tile();
		whiteTiles[14] = tile14_white;
		Tile endTile_white = new Tile();
		whiteTiles[15] = endTile_white;
	
		Tile tile13_black = new Tile();
		blackTiles[13] = tile13_black;
		Tile tile14_black = new Tile();
		blackTiles[14] = tile14_black;
		Tile endTile_black = new Tile();
		blackTiles[15] = endTile_black;
	}

	public void moveGP(String player, int gamePieceIndex, int diceRoll){
		int newGPposition = gamePieceIndex + diceRoll;
		Tile newTile = null;

		switch(player){
			case "whitePlayer":
				whiteGPs[gamePieceIndex] = newGPposition;
				newTile = (Tile)Array.get(whiteTiles, newGPposition);
				break;

			case "blackPlayer": 
				blackGPs[gamePieceIndex] = newGPposition;
				newTile = (Tile)Array.get(blackTiles, newGPposition);
				break;
		}

		newTile.setOccupied();

	}

	public void initGPs(){

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
		this.whiteTiles = new Tile[16];
		this.blackTiles = new Tile[16];

		this.whiteGPs = new int[7];
		this.blackGPs = new int[7];
		
		this.setTiles();
		this.initGPs();

		this.status = new BoardStatus();
		status.printStatus();

		}

		
		public BoardStatus getBoardStatus ()
		{
			BoardStatus status = new BoardStatus();

			///TEST///

			status.whiteStartGPsCount = 5;
			status.blackStartGPsCount = 6;
			status.tilesGrid[1][2] = TileState.WHITE_PIECE;
			status.tilesGrid[0][7] = TileState.WHITE_PIECE;
			status.tilesGrid[1][0] = TileState.BLACK_PIECE;

			return status;
		}
	

}