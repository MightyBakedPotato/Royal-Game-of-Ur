package GameOfUr;

class Tile {

    Tile(){
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

    public Tile getTile(){
        return this;
    }

}