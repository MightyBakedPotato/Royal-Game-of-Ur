package GameOfUr;

class GamePiece {


    Tile tile;
    Player player;

    GamePiece(Tile tile, Player player){
        this.tile = tile;
        this.player = player;
        this.setGP(tile);
    }

    public String getGPplayer(){
        return player.getPlayerID();
    }

    public void setGP(Tile tile){
        tile.setOccupied();
    }

    /*
    public void moveGP(){
        Tile nextTile = tile.getNextTile();
        this.setGP(nextTile);
        tile.setEmpty();
        tile = nextTile;
    }*/

    public String locateGP(){
        return tile.toString();
    }

}