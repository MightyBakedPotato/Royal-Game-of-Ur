package GameOfUr;

class Player{

    String playerID; //change to enum

    Player(String playerID){
        this.playerID = playerID;
    }

    public String getPlayerID(){
        return playerID;
    }

}