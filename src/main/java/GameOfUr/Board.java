package GameOfUr;

import java.lang.reflect.Array;
import org.apache.commons.lang3.ArrayUtils;
import GameOfUr.BoardStatus;
import GameOfUr.BoardStatus.TileState;
import GameOfUr.Player;

class Board{

	//private Tile[] whiteTiles;
	//private Tile[] blackTiles;
	private int[] whiteGPs;
	private int[] blackGPs;
	public GUI _gui;
	private Player _player1;
	private Player _player2;
	public Player currentPlayer;
	public int diceRoll;

	public void setGUI(GUI gui){
		_gui = gui;
	}

	/*private void setTiles(){

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
	}*/

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
		//this.whiteTiles = new Tile[16];
		//this.blackTiles = new Tile[16];

		this.whiteGPs = new int[7];
		this.blackGPs = new int[7];
		
		//this.setTiles();
		this.initGPs();
		}

	public void setPlayers(Player player1, Player player2){
		_player1 = player1;
		_player2 = player2;
	}

	private int[] getPlayerGPs(Player player){
		if(player.equals(_player1)){
			return whiteGPs;
		}else{
			return blackGPs;
		}
	}

	private int[] getOpponentGPs(Player player){
		if(player.equals(_player1)){
			return blackGPs;
		}else{
			return whiteGPs;
		}
	}

	private Boolean canMoveTo(Player player, int newGPposition){

		int[] playerGPs = this.getPlayerGPs(player);
		int[] opponentGPs = this.getOpponentGPs(player);

		// MOVE IS OUT OF BOARD BOUNDS
		if(newGPposition > 15){
			return false;
		}
		// NEW TILE ALREADY HAS A PLAYER TILE
		if(newGPposition < 15 && ArrayUtils.contains(playerGPs, newGPposition)){
			return false;
		}
		// TILE IS A FLOWER TILE ALREADY OCCUPIED BY OPPONENT
		if(newGPposition == 8 && ArrayUtils.contains(opponentGPs, 8)){
			return false;
		}

		return true;

	}

	private Boolean canCurrentPlayerBeOnRow(int y){

		Boolean isWhitePlayerCurrentPlayer;

		if(currentPlayer == _player1){
			isWhitePlayerCurrentPlayer = true;
		}else{
			isWhitePlayerCurrentPlayer = false;
		}

		if(isWhitePlayerCurrentPlayer && y == 0){
			return true;
		}else if(! isWhitePlayerCurrentPlayer && y == 2){
			return true;
		}

		if(isWhitePlayerCurrentPlayer && y == 2){
			return false;
		}else if(! isWhitePlayerCurrentPlayer && y == 0){
			return false;
		}else{
			return true;
		}

	}

	private int getGPsIndexValuefromTileCoords(int coordsY, int coordsX){
        int indexValue = -1;

        if(coordsY == 0 || coordsY == 2){
                switch(coordsX){
                case 0 :
                    indexValue = 4;
                    break;
                case 1 :
                    indexValue = 3;
                    break;
                case 2 :
                    indexValue = 2;
                    break;
                case 3 :
                    indexValue = 1;
                    break;
                case 4 :
                    indexValue = 0;
                    break;
                case 5 :
                    indexValue = 15;
                    break;
                case 6 :
                    indexValue = 14;
                    break;
                case 7 :
                    indexValue = 13;
                    break;
                }
            }else if(coordsY == 1){
                switch(coordsX){
                case 0 :
                    indexValue = 5;
                    break;
                case 1 :
                    indexValue = 6;
                    break;
                case 2 :
                    indexValue = 7;
                    break;
                case 3 :
                    indexValue = 8;
                    break;
                case 4 :
                    indexValue = 9;
                    break;
                case 5 :
                    indexValue = 10;
                    break;
                case 6 :
                    indexValue = 11;
                    break;
                case 7 :
                    indexValue = 12;
                    break;
                }
            }

        return indexValue;
                
        }

	public void moveGP(int y, int x){

		if(! canCurrentPlayerBeOnRow(y)){
			System.out.println("Clicked tile has no current player's gamepiece on it");
			return;
		}

		int[] playerGPs = this.getPlayerGPs(currentPlayer); // NOT a copy, but a reference

		int gamePieceValue = getGPsIndexValuefromTileCoords(y, x);

		int gamePieceIndex = -1;

		if(ArrayUtils.contains(playerGPs, gamePieceValue)){
			gamePieceIndex = ArrayUtils.indexOf(playerGPs, gamePieceValue);
		}else{
			System.out.println("Clicked tile has no current player's gamepiece on it");
			return;
		}

		int newGPposition = gamePieceValue + diceRoll;

		if(! canMoveTo(currentPlayer, newGPposition)){
			System.out.println("move is not allowed");
			return;
		}

		int[] opponentGPs = this.getOpponentGPs(currentPlayer); // NOT a copy, but a reference

		if(ArrayUtils.contains(opponentGPs, newGPposition)){

			int index = ArrayUtils.indexOf(opponentGPs, newGPposition);
			opponentGPs[index] = 0;

		}

		playerGPs[gamePieceIndex] = newGPposition;

		_gui.updateView();

	}

	/*
	public void moveGP(int gamePieceIndex){
		int newGPposition = gamePieceIndex + diceRoll;

		if(! canMoveTo(currentPlayer, newGPposition)){
			System.out.println("move is not allowed");
			return;
		}

		//add if "player has no gamepiece in the selected tile"

		int[] playerGPs = this.getPlayerGPs(currentPlayer); // NOT a copy, but a reference
		int[] opponentGPs = this.getOpponentGPs(currentPlayer); // NOT a copy, but a reference


		if(ArrayUtils.contains(opponentGPs, newGPposition)){

			int index = ArrayUtils.indexOf(opponentGPs, newGPposition);
			opponentGPs[index] = 0;

		}

		playerGPs[gamePieceIndex] = newGPposition;

		_gui.updateView();

	}*/


	////////// METHODS NEEDED TO CREATE THE STATUS /////////

	private final int colSwitchFirstTiles(int indexValue){

		int j = -1;

		switch(indexValue){
			case 0 :
				j = 4;
				break;
			case 1 :
				j = 3;
				break;
			case 2 :
				j = 2;
				break;
			case 3 :
				j = 1;
				break;
			case 4 :
				j = 0;
				break;
		}

		return j;
	}

	private final int colSwitchMiddleTiles(int indexValue){

		int j = -1;

		switch(indexValue){
			case 5 :
				j = 0;
				break;
			case 6 :
				j = 1;
				break;
			case 7 :
				j = 2;
				break;
			case 8 :
				j = 3;
				break;
			case 9 :
				j = 4;
				break;
			case 10 :
				j = 5;
				break;
			case 11 :
				j = 6;
				break;
			case 12 :
				j = 7;
				break;
			}

		return j;
		
		}

	private final int colSwitchLastTiles(int indexValue){

		int j = -1;

		switch(indexValue){
			case 13 :
				j = 7;
				break;
			case 14 :
				j = 6;
				break;
			case 15 :
				j = 5;
				break;
		}

		return j;
	}

	private int[] getWhiteGPCoords(int indexValue){

		int i = -1;
		int j = -1;

		if(indexValue <= 4){
			i = 0;
			j = colSwitchFirstTiles(indexValue);
		}else if(indexValue >= 5 && indexValue <= 12){
			i = 1;
			j = colSwitchMiddleTiles(indexValue);
		}else if(indexValue >= 13 && indexValue <= 16){
			i = 0;
			j = colSwitchLastTiles(indexValue);
		}else{
			//there's smthg wrong here, log error :(
		}

		int [] coords = new int[2];
		coords[0] = i;
		coords[1] = j;

		return coords;
	}

	private int[] getBlackGPCoords(int indexValue){

		int i = -1;
		int j = -1;

		if(indexValue <= 4){
			i = 2;
			j = colSwitchFirstTiles(indexValue);
		}else if(indexValue >= 5 && indexValue <= 12){
			i = 1;
			j = colSwitchMiddleTiles(indexValue);
		}else if(indexValue >= 13 && indexValue <= 16){
			i = 2;
			j = colSwitchLastTiles(indexValue);
		}else{
			//there's smthg wrong here, log error :(
		}

		int [] coords = new int[2];
		coords[0] = i;
		coords[1] = j;

		return coords;
	}


	///////// STATUS //////////


	public BoardStatus getStatus(){

		BoardStatus status = new BoardStatus();

		for (int i = 0; i < whiteGPs.length; i++) {
				if(whiteGPs[i] == 0){
					status.whiteStartGPsCount ++;
				}else if(whiteGPs[i] == 15){
					status.whiteEndGPsCount ++;
				}else{
				int z = whiteGPs[i];
				int [] coords = getWhiteGPCoords(z);
				status.tilesGrid [coords[0]] [coords[1]] = TileState.WHITE_PIECE;
                }
            }

        for (int i = 0; i < blackGPs.length; i++) {
        		if(blackGPs[i] == 0){
					status.blackStartGPsCount ++;
				}else if(blackGPs[i] == 15){
					status.blackEndGPsCount ++;
				}else{
				int z = blackGPs[i];
				int [] coords = getBlackGPCoords(z);
				status.tilesGrid [coords[0]] [coords[1]] = TileState.BLACK_PIECE;
				}            
            }

        return status;

	}
	

}