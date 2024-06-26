package GameOfUr;

import java.lang.reflect.Array;
import org.apache.commons.lang3.ArrayUtils;
import GameOfUr.BoardStatus;
import GameOfUr.BoardStatus.TileState;
import GameOfUr.Player;

class Board{

	private int[] whiteGPs;
	private int[] blackGPs;
	public GUI _gui;
	private Player _whitePlayer;
	private Player _blackPlayer;
	public Player currentPlayer;
	public TurnManager _turnManager;
	public int diceRoll;

	public void setGUI(GUI gui){
		_gui = gui;
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

	public void setPlayers(Player whitePlayer, Player blackPlayer){
		_whitePlayer = whitePlayer;
		_blackPlayer = blackPlayer;
	}

	public void setTurnManager(TurnManager turnManager){
		_turnManager = turnManager;
	}

	Board(){
		//this.whiteTiles = new Tile[16];
		//this.blackTiles = new Tile[16];

		this.whiteGPs = new int[7];
		this.blackGPs = new int[7];
		
		//this.setTiles();
		this.initGPs();

		this.currentPlayer = new Player("fakePlayer");
		}

	private int[] getPlayerGPs(Player player){
		if(player.equals(_whitePlayer)){
			return whiteGPs;
		}else{
			return blackGPs;
		}
	}

	private int[] getOpponentGPs(Player player){
		if(player.equals(_whitePlayer)){
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

		if(currentPlayer == _whitePlayer){
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
		} // because player gamepieces cannot ever be found on the clicked tile's row

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

		if(newGPposition > 4 && newGPposition < 13 && ArrayUtils.contains(opponentGPs, newGPposition)){
			int index = ArrayUtils.indexOf(opponentGPs, newGPposition);
			opponentGPs[index] = 0;
		}

		playerGPs[gamePieceIndex] = newGPposition;

		_gui.updateView();

		if(newGPposition != 4 || newGPposition != 8 || newGPposition != 14){
			_turnManager.endTurn();
		}

	}


	////////// METHODS NEEDED TO CREATE THE STATUS /////////

	private final int colSwitchTiles(int indexValue){

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

		j = colSwitchTiles(indexValue);

		if(indexValue <= 4){
			i = 0;
		}else if(indexValue >= 5 && indexValue <= 12){
			i = 1;
		}else if(indexValue >= 13 && indexValue <= 16){
			i = 0;
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

		j = colSwitchTiles(indexValue);

		if(indexValue <= 4){
			i = 2;
		}else if(indexValue >= 5 && indexValue <= 12){
			i = 1;
		}else if(indexValue >= 13 && indexValue <= 16){
			i = 2;
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