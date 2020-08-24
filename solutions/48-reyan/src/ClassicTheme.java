import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ClassicTheme implements Theme {

    private Tile[] tiles;
    private boolean isDefensivePlayerAI;

    private RandomAIPlayer randomAIPlayer;
    private DefensiveAIPlayer defensiveAIPlayer;
    private GameLogicForWinning gameLogicForWinning;

    protected ClassicTheme(GameStage gameStage, boolean isDefensivePlayerAI){
        this.isDefensivePlayerAI = isDefensivePlayerAI;
        randomAIPlayer = new RandomAIPlayer(gameStage.getTiles());
        defensiveAIPlayer = new DefensiveAIPlayer(gameStage);
        gameLogicForWinning = new GameLogicForWinning(gameStage);
        tiles = gameStage.getTiles();
        gameStage.thingsToChangeForTheme(gameStage.getPaneOfGame(), Color.WHITE, Color.BLACK);
        changePlayerSign();
        gameStage.setTheme(this);
    }

    private void changePlayerSign(){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getImageViewIdentifier()) { tiles[i].getChildren().remove(tiles[i].getImageView()); }
                if(tiles[i].getIsHuman()){
                    tiles[i].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                    tiles[i].setPlayerInClassicTheme("X");
                }
                else { tiles[i].setPlayerInClassicTheme("O");}
            }
        }
    }

    public void gameFunctionThemeBasedPlayer(Tile tile){
        occupiedTileCheckClassic(tile, "X", true);
        if(gameLogicForWinning.getEndFlag()) randomAIPlayerClassic();
    }

    private void randomAIPlayerClassic(){
        Tile tile;
        if(isDefensivePlayerAI) tile = defensiveAIPlayer.getPlayerTile();
        else tile = randomAIPlayer.getPlayerTile();
        occupiedTileCheckClassic(tile, "O", false);
    }

    private void occupiedTileCheckClassic(Tile tile,String playerSymbol, boolean isHuman){
        if(!tile.getIsOccupied()){
            tile.setPlayerInClassicTheme(playerSymbol);
            tile.setPlayerInClassicTheme(true);
            tile.setIsOccupied(true);
            tile.setIsHuman(isHuman);
            gameLogicForWinning.gameEndChecker(Color.BLACK);
        }
    }
}
