import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameStage {

    private Text textTheme;
    private Pane paneOfGame;
    private Stage stageOfGame;

    private Group tileGroup = new Group();
    private Group lineGroup = new Group();
    private Group radioButtonGroupForTheme = new Group();
    private Group buttonGroupForAI = new Group();

    private Tile[] tiles = new Tile[9];
    private Line[] lines = new Line[9];

    private Menu menu;

    protected void createShowGameStage(){
        menu = new Menu();
        menu.createMenu(this);
        stageOfGame = new Stage();
        stageOfGame.setScene(createGameScene());
        stageOfGame.show();
    }

    private Scene createGameScene(){
        return new Scene(createGamePane());
    }

    private Pane createGamePane(){
        paneOfGame = new Pane();
        paneOfGame.setPrefSize(600, 380);

        createTileGroup();
        createLineGroup();

        textTheme = menu.getTextTheme();
        buttonGroupForAI = menu.getButtonGroupForAI();
        radioButtonGroupForTheme = menu.getRadioButtonGroupForTheme();

        paneOfGame.getChildren().addAll(tileGroup, lineGroup, textTheme, buttonGroupForAI, radioButtonGroupForTheme);
        return paneOfGame;
    }

    protected void createTileGroup(){
        for(int i=0, l=0; i<3; i++){
            for(int j=0; j<3; j++){
                Tile tile = new Tile();
                createTile(tile, j, i);
                tiles[l] = tile;
                tileGroup.getChildren().add(tiles[l]);
                l++;
            }
        }
    }

    private void createLineGroup(){
        int l=0;
        lines[l] = drawLine(158, 30, 158, 350);
        l++;
        lines[l] = drawLine(267, 30, 267, 350);
        l++;
        lines[l] = drawLine(53, 135, 373, 135);
        l++;
        lines[l] = drawLine(53, 244, 373, 244);
        l++;
        lines[l] = drawLine(400, 30, 400, 348);

        lineGroup.getChildren().addAll(lines[0], lines[1], lines[2], lines[3], lines[4]);
    }

    private Tile createTile(Tile tile, int X, int Y){
        tile.setMinSize(100, 100);
        tile.setTranslateX(X*109+53);
        tile.setTranslateY(Y*109+30);
        return tile;
    }

    protected Line drawLine(double x1, double y1, double x2, double y2){
        Line line = new Line(x1, y1, x2, y2);
        line.setStrokeWidth(9);
        return line;
    }

    protected Pane getPaneOfGame(){ return paneOfGame; }
    protected Stage getStageOfGame(){ return stageOfGame; }
    protected Tile[] getTiles(){ return tiles; }
    protected Line[] getLines(){ return lines; }
}
