package healthIQ.charts;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class ProfileView {
    private final Image DEFAULT_PROFILE_IMAGE;
    private String toggleStatus = "Unlocked";
    private GridPane gpane; 
    private VBox leftVBox;
    private HBox hbox;
    private Image profileImage;
    private ImageView avatar;
    
    private Label firstNameLabel, 
                  middleNameLabel,
                  lastNameLabel,
                  genderLabel,
                  heightLabel,
                  weightLabel,
                  yearOfBirthLabel,
                  activityLabel,
                  calorieGoalLabel,
                  carbsProteinFatRatioLabel;
    
    private TextField firstNameTextField,
                      middleNameTextField,
                      lastNameTextField,
                      weightTextField,
                      heightFeetTextField,
                      heightInchTextField,
                      calorieGoalTextField,
                      ratioTextField;
    
    private ToggleButton editButton;
    
    private ComboBox yearBox;
    private ObservableList<String> years;
    private List<String> yearsList;
    
    private ComboBox genderBox;
    private ObservableList<String> gender;
    private List<String> genderList;
    
    private ComboBox activityLevelBox;
    private ObservableList<String> activity;
    private List<String> activityList;
    
    public ProfileView(){
        DEFAULT_PROFILE_IMAGE = new Image("file:///C:\\Users\\deepf\\Documents\\NetBeansProjects\\HealthApp\\src\\healthIQ\\charts\\profilePlaceholder.png");
        avatar = new ImageView(DEFAULT_PROFILE_IMAGE);
        yearsList = new ArrayList<>();
        genderList = new ArrayList<>();
        
        for(int i = 1900; i < Year.now().getValue(); i++){
            yearsList.add(i + "");
        }
        
        genderList.add("Male");
        genderList.add("Female");
        
        years = FXCollections.observableList(yearsList);
        gender = FXCollections.observableList(genderList);
        
        activityList = new ArrayList<>();
        activityList.add("Sedentary");
        activityList.add("Lightly Active");
        activityList.add("Moderately Active");
        activityList.add("Very Active");
        activityList.add("Extra Active");
        
        activity = FXCollections.observableList(activityList);
        

        
        gpane = new GridPane();
        leftVBox = new VBox();
        leftVBox.setSpacing(5);
        hbox = new HBox();
        hbox.setPadding(new Insets(8, 5, 5, 8));
        gpane.setVgap(10);
        gpane.setHgap(10);
        gpane.setStyle("-fx-font-family: Cambria; "
                + "-fx-font-size: 20px;");
        hbox.setStyle("-fx-font-family: Cambria; "
                + "-fx-font-size: 20px;");
        
        editButton = new ToggleButton(toggleStatus);
        editButton.setMaxWidth(300);
        editButton.setMinHeight(20);
        editButton.setOnAction(event-> {
            if(editButton.isSelected()){
                
            }
        });
        
        firstNameLabel = new Label("First: ");
        firstNameTextField = new TextField();
        firstNameTextField.setPromptText("First Name");
        
        middleNameLabel = new Label("Middle: ");
        middleNameTextField = new TextField();
        middleNameTextField.setPromptText("Middle");
        
        lastNameLabel = new Label("Last Name: ");
        lastNameTextField = new TextField();
        lastNameTextField.setPromptText("Last Name");
        
        yearOfBirthLabel = new Label("Year of Birth:");
        yearBox = new ComboBox(years);
        
        genderLabel = new Label("Gender: ");
        genderBox = new ComboBox(gender);
        
        heightLabel = new Label("Height: ");
        weightLabel = new Label("Weight: ");
        
        heightInchTextField = new TextField();
        heightFeetTextField = new TextField();
        heightInchTextField.setPromptText("Inches");
        heightFeetTextField.setPromptText("Feet");
        
        weightTextField = new TextField();
        weightTextField.setPromptText("Weight");
        
        activityLabel = new Label("Activity Level: ");
        activityLevelBox = new ComboBox(activity);
        
        calorieGoalLabel = new Label("Daily Calorie Goal: ");
        calorieGoalTextField = new TextField();
        calorieGoalTextField.setPromptText("####");
        
        carbsProteinFatRatioLabel = new Label("Carbs:Protein:Fat Ratio");
        ratioTextField = new TextField();
        ratioTextField.setPromptText("carbs:protein:fat");
        
        leftVBox.getChildren().addAll(avatar, editButton);
        
        gpane.add(firstNameLabel, 1, 0);
        gpane.add(firstNameTextField, 2, 0);
        gpane.add(middleNameLabel, 1, 1);
        gpane.add(middleNameTextField, 2, 1);
        gpane.add(lastNameLabel, 1, 3);
        gpane.add(lastNameTextField, 2, 3);
        gpane.add(yearOfBirthLabel, 1, 4);
        gpane.add(yearBox, 2, 4);
        gpane.add(genderLabel, 1, 5);
        gpane.add(genderBox, 2, 5);
        gpane.add(heightLabel, 1, 6);
        gpane.add(heightFeetTextField, 2, 6);
        gpane.add(heightInchTextField, 3, 6);
        gpane.add(weightLabel, 1, 7);
        gpane.add(weightTextField, 2, 7);
        gpane.add(activityLabel, 1, 8);
        gpane.add(activityLevelBox, 2, 8);
        gpane.add(calorieGoalLabel, 1, 9);
        gpane.add(calorieGoalTextField, 2, 9);
        gpane.add(carbsProteinFatRatioLabel, 1, 10);
        gpane.add(ratioTextField, 2, 10);
        
        hbox.getChildren().addAll(leftVBox, gpane);
        Dashboard dashboard = new Dashboard();
        dashboard.setCenter(hbox);

        Scene scene = new Scene(
                dashboard.getPane(),
                HealthIQ.primaryStage.getScene().getWidth(),
                HealthIQ.primaryStage.getScene().getHeight());

        HealthIQ.primaryStage.setScene(scene);
    }
    
    public Pane getPane(){
        return gpane;
    }
    
    
}//end Profile
