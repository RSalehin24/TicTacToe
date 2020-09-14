public class CurrentStateOfGame {

    private Tile[] tiles;

    protected CurrentStateOfGame(Tile[] tiles){
        this.tiles = tiles;
    }

    protected boolean[][] getOccupiedTiles(){

        boolean[][] occupiedTiles= new boolean[2][9];

        occupiedTiles[0] = getOccupiedTilesPerPlayer(true);
        occupiedTiles[1] = getOccupiedTilesPerPlayer(false);

        return occupiedTiles;
    }

    private boolean[] getOccupiedTilesPerPlayer(boolean isHuman){
        boolean[] occupiedTile = new boolean[9];
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(isHuman){
                    if(tiles[i].getIsHuman()) {
                        occupiedTile[i] = true;
                    }
                } else {
                    if(!tiles[i].getIsHuman()) {
                        occupiedTile[i] = true;
                    }
                }
            }
        }
        return occupiedTile;
    }
}
