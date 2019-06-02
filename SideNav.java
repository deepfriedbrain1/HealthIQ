package healthIQ.charts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class SideNav {
    
    protected static boolean isLocked = true;
    private VBox vbox;
    private final int SPACING = 10;
    private Button profileButton = new Button("Profile");
    private Button macrosButton = new Button("Macros");
    private Button bloodGlucoseButton = new Button("Blood Glucose");
    private Button bodyMeasurementsButton = new Button("Body Measurments");
    private Button ketoneLevelsButton = new Button("Ketone Levels");
    private Button sleepButton = new Button("Sleep");
    private Button exerciseButton = new Button("Exercise");
    private Button bloodPressureButton = new Button("Blood Pressure");
    private Button signOutButton = new Button("Sign Out");

    private final Button[] buttons = new Button[]{
        profileButton, macrosButton, bloodGlucoseButton, bodyMeasurementsButton,
        ketoneLevelsButton, sleepButton, exerciseButton, bloodPressureButton,
        signOutButton
    };

    private final String style = "-fx-background-color: rgb(58, 59, 61);";

    SideNav() {
        profileButton.setId("Profile");
        macrosButton.setId("Macros");
        bloodGlucoseButton.setId("BloodGlucose");
        bodyMeasurementsButton.setId("Body");
        ketoneLevelsButton.setId("Ketone");
        sleepButton.setId("Sleep");
        exerciseButton.setId("Exercise");
        bloodPressureButton.setId("BloodPressure");
        signOutButton.setId("SignOut");
        
        vbox = new VBox(SPACING);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle(style);

        for (Button button : buttons) {
            button.setDisable(isLocked);
            button.setMaxWidth(Double.MAX_VALUE);
            button.setFont(new Font("Cambria", 22));
            button.setStyle("-fx-background-color: #f2621f; "
                    + "-fx-text-fill: #ffffff; -fx-background-radius: 5em;");

            button.setOnMouseEntered((event) -> {
                button.setStyle("-fx-background-color: #dd991a; "
                        + "-fx-text-fill: #ffffff; -fx-background-radius: 5em;");

            });

            button.setOnMouseExited(event -> {
                button.setStyle("-fx-background-color: #f2621f; "
                        + "-fx-text-fill: #ffffff; -fx-background-radius: 5em;");
            });

            button.setOnMousePressed((MouseEvent event) -> {
                button.setStyle("-fx-background-color: #dd991a;"
                        + "-fx-text-fill: #ffffff; "
                        + "-fx-background-radius: 5em;");

                if (button.getId().equalsIgnoreCase("Profile")){
                    new ProfileView();
                }
                else if (button.getId().equalsIgnoreCase("Macros")) {
                    new MacrosView();
                }//end if (Macros)             
                else if (button.getId().equalsIgnoreCase("BloodGlucose")){
                    new BloodGlucoseView();
                }//end else if (BloodGlucose)
                else if (button.getId().equalsIgnoreCase("Body")){
                    new BodyMeasurementView();
                }//end else if (Body)
                else if (button.getId().equalsIgnoreCase("Ketone")){
                    
                }//end else if (Ketone)
                else if (button.getId().equalsIgnoreCase("Sleep")){
                    new SleepView();
                }//end else if (Sleep)
                else if (button.getId().equalsIgnoreCase("Exercise")){
                    
                }//end else if (Exercise)
                else if (button.getId().equalsIgnoreCase("BloodPressure")){
                    
                }//end else if (BloodPressure)
                
                else if (button.getId().equalsIgnoreCase("SignOut")) {
                    isLocked = true;
                    Dashboard dashboard = new Dashboard();
                    dashboard.setCenter(new LogIn().getPane());

                    Scene scene = new Scene(
                            dashboard.getPane(),
                            HealthIQ.primaryStage.getScene().getWidth(),
                            HealthIQ.primaryStage.getScene().getHeight());
                    
                    HealthIQ.primaryStage.setScene(scene);
                    
                }//end if (SignOut)
                
            });//end setOnMousePressed

            button.setOnMouseReleased(event -> {
                button.setStyle("-fx-background-color: #f2621f; "
                        + "-fx-text-fill: #ffffff; -fx-background-radius: 5em;");
            });

            VBox.setMargin(button, new Insets(6, 6, 6, 10));
            vbox.getChildren().add(button);
        }//end for-loop

    }//end constuctor

    public VBox getSideNav() {
        return vbox;
    }
    
}//end SideNav
