package healthIQ.charts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class BodyMeasurementView {

    private ImageView bodyDiagram;
    private Image image;
    private Button saveButton;

    public BodyMeasurementView() {

        BorderPane bpane = new BorderPane();
        StackPane spane = new StackPane();
        saveButton = new Button("Save");

        image = new Image("file:///C:\\Users\\deepf\\Documents\\NetBeansProjects\\HealthApp\\src\\healthIQ\\charts\\bodyMeasurements.png");
        bodyDiagram = new ImageView(image);
        bodyDiagram.setFitHeight(HealthIQ.primaryStage.getHeight() / 1.5);
        bodyDiagram.setPreserveRatio(true);

        saveButton.setMinHeight(95);
        saveButton.setMinWidth(344);
        saveButton.setTranslateX(0);
        saveButton.setTranslateY(195);

        saveButton.setFont(new Font("Cambria", 32));
        saveButton.setStyle("-fx-background-color: #39a316;"
                + "-fx-text-fill: #ffffff; "
                + "-fx-background-radius: 2em;");

        saveButton.setOnMouseEntered(event -> {
            saveButton.setStyle(
                    "-fx-background-color: #4ddb1e;"
                    + "-fx-text-fill: #ffffff; "
                    + "-fx-background-radius: 2em;");
        });

        saveButton.setOnMouseExited(event -> {
            saveButton.setStyle("-fx-background-color: #39a316;"
                    + "-fx-text-fill: #ffffff; "
                    + "-fx-background-radius: 2em;");
        });

        spane.getChildren().addAll(bodyDiagram, saveButton);

        // Left side
        Text leftText = new Text("Left       ");
        leftText.setFont(new Font("cambria", 22));
        TextField chestTextField = new TextField("");
        chestTextField.setPromptText("Chest");
        TextField rightArmTextField = new TextField("");
        rightArmTextField.setPromptText("Right Arm");
        TextField rightForearmTextField = new TextField("");
        rightForearmTextField.setPromptText("Right Forearm");
        TextField rightHipTextField = new TextField("");
        rightHipTextField.setPromptText("Right Hip");
        TextField rightThighTextField = new TextField("");
        rightThighTextField.setPromptText("Right Thigh");
        TextField rightCalfTextField = new TextField("");
        rightCalfTextField.setPromptText("Right Calf");

        chestTextField.setMaxWidth(110);
        rightArmTextField.setMaxWidth(110);
        rightForearmTextField.setMaxWidth(110);
        rightHipTextField.setMaxWidth(110);
        rightThighTextField.setMaxWidth(110);
        rightCalfTextField.setMaxWidth(110);

        VBox leftVBox = new VBox(15);
        leftVBox.setSpacing(15);
        leftVBox.setPadding(new Insets(0, 0, 0, 0));
        leftVBox.setMaxWidth(100);
        leftVBox.setAlignment(Pos.CENTER_RIGHT);
        leftVBox.getChildren().addAll(leftText, chestTextField, rightArmTextField,
                rightForearmTextField, rightHipTextField, rightThighTextField,
                rightCalfTextField);

        // Right side
        Text rightText = new Text("       Right");
        rightText.setFont(new Font("cambria", 22));
        TextField neckTextField = new TextField("");
        neckTextField.setPromptText("Neck");
        TextField leftArmTextField = new TextField("");
        leftArmTextField.setPromptText("Left Arm");
        TextField leftForearmTextField = new TextField("");
        leftForearmTextField.setPromptText("Left Forearm");
        TextField leftHipTextField = new TextField("");
        leftHipTextField.setPromptText("Left Hip");
        TextField leftThighTextField = new TextField("");
        leftThighTextField.setPromptText("Left Thigh");
        TextField leftCalfTextField = new TextField("");
        leftCalfTextField.setPromptText("Left Calf");

        neckTextField.setMaxWidth(110);
        leftArmTextField.setMaxWidth(110);
        leftForearmTextField.setMaxWidth(110);
        leftHipTextField.setMaxWidth(110);
        leftThighTextField.setMaxWidth(110);
        leftCalfTextField.setMaxWidth(110);

        VBox rightVBox = new VBox(15);
        rightVBox.setAlignment(Pos.CENTER_LEFT);
        rightVBox.getChildren().addAll(rightText, neckTextField, leftArmTextField,
                leftForearmTextField, leftHipTextField, leftThighTextField,
                leftCalfTextField);

        leftVBox.setMinWidth(350);
        rightVBox.setMinWidth(350);
        spane.setMaxWidth(bodyDiagram.getFitWidth());

        BorderPane.setMargin(spane, new Insets(0, 0, 0, 0));
        BorderPane.setMargin(rightVBox, new Insets(0, 0, 0, 0));
        BorderPane.setMargin(leftVBox, new Insets(0, 0, 0, 0));

        // set sections
        bpane.setLeft(leftVBox);
        bpane.setCenter(spane);
        bpane.setRight(rightVBox);

        Dashboard dashboard = new Dashboard();
        dashboard.setCenter(bpane);

        Scene scene = new Scene(
                dashboard.getPane(),
                HealthIQ.primaryStage.getScene().getWidth(),
                HealthIQ.primaryStage.getScene().getHeight());

        HealthIQ.primaryStage.setScene(scene);

    }

}
