import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ClassicTheme implements Theme {

    private Tile[] tiles;
    private RandomAIPlayer randomAIPlayer;

    protected ClassicTheme(GameStage gameStage){
        this.tiles = gameStage.getTiles();
        randomAIPlayer = new RandomAIPlayer(gameStage.getTiles());
        gameStage.thingsToChangeForTheme(gameStage.getGamePane(), Color.WHITE, Color.BLACK);
        changePlayerSign();
        gameStage.setTheme(this);
    }

    private void changePlayerSign(){
        for(int i=0; i<9; i++){
            if(tiles[i].getIsOccupied()){
                if(tiles[i].getImageViewIdentifier()) { tiles[i].getChildren().remove(tiles[i].getImageView()); }
                if(tiles[i].getIsHuman()){
                    tiles[i].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                    tiles[i].setText("X"); }
                else { tiles[i].setText("O");}
            }
        }
    }

    public void gameFunctionThemeBasedPlayer(Tile tile){
        if(!tile.getIsOccupied()){
            tile.setText("X");
            tile.setIsOccupied(true);
            tile.setIsHuman(true);
        }
        randomAIPlayerClassic();
    }

    private void randomAIPlayerClassic(){
        Tile tile;
        tile = randomAIPlayer.getPlayerTile();
        if(!tile.getIsOccupied()) {
            tile.setText("O");
            tile.setTextIdetifier(true);
            tile.setIsOccupied(true);
        }
    }
}
