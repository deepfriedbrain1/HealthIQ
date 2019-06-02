package healthIQ.charts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.text.Font;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class LogIn {
    private GridPane pane;
    private Label userNameLabel;
    private TextField userNameTextField;
    private Label passwordLabel;
    private PasswordField passwordField;
    private Button loginButton;
    private Label title;
    
    public LogIn(){
        title = new Label("Sign In");
        title.setFont(new Font("Cambria", 34));
        title.setMinWidth(260);
        title.setAlignment(Pos.CENTER);
        title.setTranslateX(25);
        title.setTextFill(Paint.valueOf("#ffffff"));
        
        pane = new GridPane();
        userNameLabel = new Label("Username: ");
        userNameLabel.setFont(new Font("Cambria", 20));
        userNameLabel.setTextFill(Paint.valueOf("#ffffff"));
        
        passwordLabel = new Label("Password: ");
        passwordLabel.setFont(new Font("Cambria", 20));
        passwordLabel.setTextFill(Paint.valueOf("#ffffff"));
        
        userNameTextField = new TextField();
        userNameTextField.setPromptText("username");
        userNameTextField.setFont(new Font("Cambria", 18));
        
        passwordField = new PasswordField();
        passwordField.setPromptText("password");
        passwordField.setFont(new Font("Cambria", 16));
        
        loginButton = new Button();
        loginButton.setText("Log In");
        loginButton.setMinWidth(330);
        loginButton.setMinHeight(60);
        loginButton.setPrefWidth(330);
        loginButton.setMaxWidth(330);
        loginButton.setStyle(
                "-fx-background-radius: 5em; " + 
                "-fx-text-fill: #ffffff;" +
                "-fx-background-color: #3a3b3d;" + 
                "-fx-font-family: cambria;" + 
                "-fx-font: 22px cambria;");
 
        pane.add(title, 1, 1, 2, 1);
        pane.add(userNameLabel, 1, 2);
        pane.add(passwordLabel, 1, 3); 
        pane.add(userNameTextField, 2, 2);
        pane.add(passwordField, 2, 3);
        pane.add(loginButton, 1, 4, 3, 1);
        
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10.0);
        pane.setVgap(10.0);
        pane.setMaxHeight(300);
        pane.setMaxWidth(300);
        String colorValue = "radial-gradient(focus-angle 45deg, focus-distance 50%, " +
                            "center 50% 50%, radius 50%, #dd991a 0%, #f2621f 100%)";
        RadialGradient gradient = RadialGradient.valueOf(colorValue);
        
        
        pane.setBackground(
                new Background(
                        new BackgroundFill(
                                Paint.valueOf(colorValue),
                                new CornerRadii(100),
                                Insets.EMPTY
                )));
        
        loginButton.setOnMouseClicked(event -> {
            SideNav.isLocked = false;
            Dashboard dashboard = new Dashboard();
            dashboard.setCenter(new StackPane());
            Scene scene = new Scene(
                    dashboard.getPane(), 
                    HealthIQ.primaryStage.getWidth(), 
                    HealthIQ.primaryStage.getHeight());
            HealthIQ.primaryStage.setScene(scene);
        });
        
        loginButton.setOnMouseEntered(event -> {
            loginButton.setStyle(
                    "-fx-background-radius: 5em; " + 
                    "-fx-text-fill: #ffffff;" +
                    "-fx-background-color: #585a5e;" + 
                    "-fx-font-family: cambria;" + 
                    "-fx-font: 20px cambria;");
        });
        
        loginButton.setOnMouseExited(event -> {
            loginButton.setStyle(
                    "-fx-background-radius: 5em; " + 
                    "-fx-text-fill: #ffffff;" +
                    "-fx-background-color: #3a3b3d;" + 
                    "-fx-font-family: cambria;" + 
                    "-fx-font: 20px cambria;");
        });
        
    }
    
    public Pane getPane(){
        return pane;
    }
}
