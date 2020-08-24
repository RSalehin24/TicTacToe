import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameEndingScene {

    public Scene makeGameOverScene(int winPlayerIndicator) {

        String stringForLabelOne = determineString(winPlayerIndicator, "Yahoo!!!", "Sorry!", "Hmm!");
        String stringForLabelTwo = determineString(winPlayerIndicator, "You have won the game!!","You have lost the game", "Game Has Drawn");

        Label labelOne = createLabel(stringForLabelOne,"#ff0000");
        Label labelTwo = createLabel(stringForLabelTwo, "#228b22");

        VBox vBox = creatVBox(labelOne, labelTwo);

        Scene scene = new Scene(vBox, 420, 380);

        return scene;
    }

    protected Label createLabel(String string, String color){
        Label label = new Label(string);
        label.setFont(new Font("Arial", 30));
        label.setTextFill(Color.web(color, 1.0));
        return label;
    }

    protected VBox creatVBox(Label labelOne, Label labelTwo){
        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(labelOne, labelTwo);

        return vBox;
    }

    protected String determineString(int winPlayerIndicator, String setStringOne, String setStringTwo, String setStringThree){
        String string;
        if (winPlayerIndicator == 0) {
            string = setStringOne;
        } else if(winPlayerIndicator == 1) {
            string = setStringTwo;
        } else {
            string = setStringThree;
        }
        return string;
    }
}