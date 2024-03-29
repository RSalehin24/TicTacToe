public class DefensiveAIPlayer implements AIPlayer{

    private RandomAIPlayer randomAIPlayer;

    protected DefensiveAIPlayer(){
        randomAIPlayer = new RandomAIPlayer();
    }

    public int getAIPlayerTileNo(boolean[][] occupiedTiles){
        int tileNo = -1;
        tileNo = checkTileNoFour(tileNo, occupiedTiles);
        tileNo = checkRowTiles(tileNo, occupiedTiles);
        tileNo = checkColumnTiles(tileNo, occupiedTiles);
        tileNo = checkMainDiagonalTiles(tileNo, occupiedTiles);
        tileNo = checkAuxiliaryDiagonalTiles(tileNo, occupiedTiles);
        tileNo = returnRandomTileNo(tileNo, occupiedTiles);
        return tileNo;
    }

    protected int checkTileNoFour(int tileNo, boolean[][] occupiedTiles){
        if(!(occupiedTiles[0][4]||occupiedTiles[1][4])) {
            tileNo = 4;
        }
        return tileNo;
    }

    protected int checkRowTiles(int tileNo, boolean[][] occupiedTiles){
        for (int i=0; i<9; i += 3) {
            tileNo = checkIfTwoTilesHaveMatched(tileNo, occupiedTiles, i, i+1, i+2);
            tileNo = checkIfTwoTilesHaveMatched(tileNo, occupiedTiles, i, i+2, i+1);
            tileNo = checkIfTwoTilesHaveMatched(tileNo, occupiedTiles, i+1,i+2, i);
        }
        return tileNo;
    }

    protected  int checkColumnTiles(int tileNo, boolean[][] occupiedTiles){
        for(int i=0; i<3; i++){
            tileNo = checkIfTwoTilesHaveMatched(tileNo, occupiedTiles, i, i+3, i+6);
            tileNo = checkIfTwoTilesHaveMatched(tileNo, occupiedTiles, i, i+6, i+3);
            tileNo = checkIfTwoTilesHaveMatched(tileNo, occupiedTiles, i+3,i+6, i);
        }
        return tileNo;
    }

    protected int checkMainDiagonalTiles(int tileNo, boolean[][] occupiedTiles){
        for(int i=0; i<3; i++){
            tileNo = checkIfTwoTilesHaveMatched(tileNo, occupiedTiles, 0, 4, 8);
            tileNo = checkIfTwoTilesHaveMatched(tileNo, occupiedTiles, 0, 8, 4);
            tileNo = checkIfTwoTilesHaveMatched(tileNo, occupiedTiles, 4,8, 0);
        }
        return tileNo;
    }

    protected int checkAuxiliaryDiagonalTiles(int tileNo, boolean[][] occupiedTiles){
        for(int i=0; i<3; i++){
            tileNo = checkIfTwoTilesHaveMatched(tileNo, occupiedTiles, 2, 4, 6);
            tileNo = checkIfTwoTilesHaveMatched(tileNo, occupiedTiles, 2, 6, 4);
            tileNo = checkIfTwoTilesHaveMatched(tileNo, occupiedTiles, 4,6, 2);
        }
        return tileNo;
    }

    protected int checkIfTwoTilesHaveMatched(int tileNo, boolean[][] occupiedTiles, int tileOne, int tileTwo, int tileThree){
        if(tileNo == -1) {
            if (occupiedTiles[0][tileOne] && occupiedTiles[0][tileTwo]) {
                if (!(occupiedTiles[0][tileThree] || occupiedTiles[1][tileThree])) tileNo = tileThree;
            }
        }
        return  tileNo;
    }

    protected int returnRandomTileNo(int tileNo, boolean[][] occupiedTiles){
        if(tileNo == -1){
            tileNo = randomAIPlayer.getAIPlayerTileNo(occupiedTiles);
        }
        return tileNo;
    }

}
