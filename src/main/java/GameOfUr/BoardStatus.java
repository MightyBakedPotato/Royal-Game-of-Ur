package GameOfUr;

import java.lang.reflect.Array;


class BoardStatus{

	public TileState[][] tilesGrid;
	public int whiteStartGPsCount;
	public int blackStartGPsCount;
	public int whiteEndGPsCount;
	public int blackEndGPsCount;

	public enum TileState
	{	
		START,
		END,
		EMPTY,
		WHITE_PIECE,
		BLACK_PIECE;
	}

	BoardStatus(){
		this.tilesGrid = new TileState[3][8];

		for (int i = 0; i < tilesGrid.length; i++) {
       		for (int j = 0; j < tilesGrid[i].length; j++) {
            	tilesGrid[i][j] = TileState.EMPTY;
        		}
    		}

    		int iStartWhite = 0;
    		int jStartWhite = tilesGrid[0].length - 4;
			tilesGrid[iStartWhite][jStartWhite] = TileState.START;

			int iStartBlack = 2;
    		int jStartBlack = tilesGrid[0].length - 4; 
			tilesGrid[iStartBlack][jStartBlack] = TileState.START;

			int iEndWhite = 0;
    		int jEndWhite = tilesGrid[0].length - 3; 
			tilesGrid[iEndWhite][jEndWhite] = TileState.START;

			int iEndBlack = 2;
    		int jEndBlack = tilesGrid[0].length - 3; 
			tilesGrid[iEndBlack][jEndBlack] = TileState.START;
    }

    public void printStatus(){
    	for (int i = 0; i < tilesGrid.length; i++) {
       		for (int j = 0; j < tilesGrid[i].length; j++) {
            	System.out.print(tilesGrid[i][j] + " ");
        		}
        		System.out.println();
    		}
    }

}