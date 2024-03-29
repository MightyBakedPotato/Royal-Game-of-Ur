public class GameOfUr {

	public static void main(String args[]){


		Tile thirdTile = new Tile();
		Tile secondTile = new Tile(thirdTile);
		Tile tile = new Tile(secondTile);

		GamePiece gp = new GamePiece(tile);

		System.out.println(gp.locateGP());

		gp.moveGP();

		System.out.println(gp.locateGP());

		gp.moveGP();

		System.out.println(gp.locateGP());
		
	}
}

class Tile {

	Tile nextTile;

	Tile(){}

	Tile(Tile nextTile){
		this.nextTile = nextTile;
	}

	Boolean isEmpty = true;

	public void setEmpty(){
		isEmpty = true;
	}

	public void setOccupied(){
		isEmpty = false;
	}

	public Tile getNextTile(){
		this.nextTile = nextTile;
		return nextTile;
	}

}

class GamePiece {


	Tile tile;

	GamePiece(Tile tile){
		this.tile = tile;
		this.setGP(tile);
	}

	public void setGP(Tile tile){
		tile.setOccupied();
	}

	public void moveGP(){
		Tile nextTile = tile.getNextTile();
		this.setGP(nextTile);
		tile.setEmpty();
		tile = nextTile;
	}

	public String locateGP(){
		return tile.toString();
	}

}