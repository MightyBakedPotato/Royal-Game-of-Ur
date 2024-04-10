package GameOfUr;

class Tile {

    Tile nextTile;

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

    public Boolean isEmpty(){
        return isEmpty;
    }

    public Tile getNextTile(){
        this.nextTile = nextTile;
        return nextTile;
    }

    public Tile getTile(){
        return this;
    }

}