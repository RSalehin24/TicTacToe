import javafx.scene.paint.Color;

public interface Theme {

    void makeMoveInATile(Tile tile);
    void aiPlayer();
    void setPlayerInTile(Tile tile, String string, Color color, boolean isHuman);

}

