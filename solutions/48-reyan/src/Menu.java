import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Menu {

    private Group buttonGroupForAI = new Group();
    private  Group radioButtonGroupForTheme = new Group();

    private Text textTheme;
    private Button buttonRandomAI;
    private Button buttonDefensiveAI;
    private RadioButton radioButtonClassic;
    private RadioButton radioButtonForest;
    private RadioButton radioButtonHighContrast;

    private GameStage gameStage;


    protected void createMenu(GameStage gameStage){
        this.gameStage = gameStage;
        textTheme = createText("Theme", 410, 30);
        createButtonGroupToSelectAIPlayer(410, 410, 280, 320);
        createRadioButtonGroupToCheckTheme(410, 40, 62, 84);
        buttonEventHandlerPerAIPlayer();
    }


    private Text createText(String string, double X, double Y){
        Text text = new Text(X, Y, string);
        text.setFont(Font.font("Aerial", FontWeight.BOLD, 30));
        return text;
    }

    private RadioButton createRadioButton(String string, ToggleGroup toggleGroup, double X, double Y){
        RadioButton radioButton = new RadioButton(string);
        radioButton.setFont(Font.font("Aerial", FontWeight.BOLD, 15));
        radioButton.setLayoutX(X);
        radioButton.setLayoutY(Y);
        radioButton.setToggleGroup(toggleGroup);
        return radioButton;
    }

    private Button createButton(String string, double X, double Y){
        Button button = new Button(string);
        button.setFont(Font.font("Aerial", FontWeight.BOLD, 15));
        button.setLayoutX(X);
        button.setLayoutY(Y);
        return button;
    }

    private void createRadioButtonGroupToCheckTheme(double X, double Y1, double Y2, double Y3){
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonClassic = createRadioButton("Classic", toggleGroup, X, Y1);
        radioButtonForest = createRadioButton("Forest", toggleGroup, X, Y2);
        radioButtonHighContrast = createRadioButton("High Contrast", toggleGroup, X, Y3);
        radioButtonGroupForTheme.getChildren().addAll(radioButtonClassic, radioButtonForest, radioButtonHighContrast);
    }

    private void createButtonGroupToSelectAIPlayer(double X1, double X2, double Y1, double Y2){
        buttonRandomAI = createButton("Play with Random AI",X1, Y1);
        buttonDefensiveAI = createButton("Play with Defensive AI", X2, Y2);
        buttonGroupForAI.getChildren().addAll(buttonRandomAI, buttonDefensiveAI);
    }

    private void buttonEventHandlerPerAIPlayer(){
        buttonRandomAI.setOnMouseClicked(e -> {
            RandomAIPlayer randomAIPlayer = new RandomAIPlayer();
            themeDeterminerFromRadioButtons(randomAIPlayer);
        });
        buttonDefensiveAI.setOnMouseClicked(e -> {
            DefensiveAIPlayer defensiveAIPlayer = new DefensiveAIPlayer();
            themeDeterminerFromRadioButtons(defensiveAIPlayer);
        });
    }

    private void themeDeterminerFromRadioButtons(AIPlayer aiPlayer){
        if(radioButtonClassic.isSelected()){
            ClassicTheme classicTheme = new ClassicTheme(gameStage, aiPlayer);
        }
        else if(radioButtonForest.isSelected()){
            ForestTheme forestTheme = new ForestTheme(gameStage, aiPlayer);
        }
        else if(radioButtonHighContrast.isSelected()){
            HighContrastTheme highContrastTheme = new HighContrastTheme(gameStage, aiPlayer);
        }
    }

    protected Text getTextTheme(){ return textTheme; }
    protected Group getRadioButtonGroupForTheme(){ return radioButtonGroupForTheme; }
    protected Group getButtonGroupForAI(){ return buttonGroupForAI; }
}
