package healthIQ.charts;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class MacrosController {

    private final GridPane gpane;
    private final HBox dateSelectionBox;
    private final VBox container;

    private Button addButton;
    private Button removeButton;
    private DatePicker fromDatePicker;
    private DatePicker toDatePicker;
    private Label fromLabel;
    private Label toLabel;
    private DatePicker datePicker;
    
    private Label mealTypeLabel;
    private Label foodLabel;
    private Label numOfServings;
    private Label servingSize;
    private Label proteinLabel;
    private Label fatLabel;
    private Label carbsLabel;
    private Label sugarLabel;
    private Label fiberLabel;
    private Label caloriesLabel;
    private Label dateLabel;
    
    private TextField foodTextField;
    private TextField numOfServingTextField;
    private TextField servingSizeTextField;
    private TextField proteinTextField;
    private TextField fatTextField;
    private TextField carbsTextField;
    private TextField sugarTextField;
    private TextField fiberTextField;
    private TextField caloriesTextField;
    
    private ObservableList<MealType> meals;
    private ComboBox mealComboBox;
    private List<MealType> mealList;

    protected MacrosController() {
        gpane = new GridPane();
        dateSelectionBox = new HBox();
        container = new VBox();
        container.setStyle("-fx-font-family: Cambria;"
                + "-fx-font-size: 14px;");

        fromLabel = new Label("From");
        toLabel = new Label("To");
        addButton = new Button("ADD");
        removeButton = new Button("REMOVE");

        datePicker = new DatePicker(java.time.LocalDate.now());
        fromDatePicker = new DatePicker(java.time.LocalDate.now());
        toDatePicker = new DatePicker(java.time.LocalDate.now());

        // from and to calendars 
        dateSelectionBox.setAlignment(Pos.CENTER);

        HBox.setMargin(fromLabel, new Insets(20, 10, 10, 10));
        HBox.setMargin(toLabel, new Insets(20, 10, 10, 10));
        HBox.setMargin(fromDatePicker, new Insets(20, 10, 10, 10));
        HBox.setMargin(toDatePicker, new Insets(20, 10, 10, 10));

        // macros controls
        mealTypeLabel = new Label("Meal Type:");
        foodLabel = new Label("Food / Drink:");
        dateLabel = new Label("Date:");
        numOfServings = new Label("# of sevings:");
        servingSize = new Label("Serving Size:");
        proteinLabel = new Label("Protein (g):");
        fatLabel = new Label("Fat (g):");
        carbsLabel = new Label("Carbs (g):");
        sugarLabel = new Label("Sugar (g):");
        fiberLabel = new Label("Fiber (g):");
        caloriesLabel = new Label("Calories:");
        dateLabel = new Label("Date:");
        
        mealTypeLabel.setStyle("-fx-font-family: Cambria; -fx-text-fill: #ffffff;");
        foodLabel.setStyle("-fx-font-family: Cambria; -fx-text-fill: #ffffff;");
        dateLabel.setStyle("-fx-font-family: Cambria; -fx-text-fill: #ffffff;");
        numOfServings.setStyle("-fx-font-family: Cambria; -fx-text-fill: #ffffff;");
        servingSize.setStyle("-fx-font-family: Cambria; -fx-text-fill: #ffffff;");
        proteinLabel.setStyle("-fx-font-family: Cambria; -fx-text-fill: #ffffff;");
        fatLabel.setStyle("-fx-font-family: Cambria; -fx-text-fill: #ffffff;");
        carbsLabel.setStyle("-fx-font-family: Cambria; -fx-text-fill: #ffffff;");
        sugarLabel.setStyle("-fx-font-family: Cambria; -fx-text-fill: #ffffff;");
        fiberLabel.setStyle("-fx-font-family: Cambria; -fx-text-fill: #ffffff;");
        caloriesLabel.setStyle("-fx-font-family: Cambria; -fx-text-fill: #ffffff;");
        fiberLabel.setStyle("-fx-font-family: Cambria; -fx-text-fill: #ffffff;");
        caloriesLabel.setStyle("-fx-font-family: Cambria; -fx-text-fill: #ffffff;");
        
        foodTextField = new TextField();
        foodTextField.setPromptText("Food / Drink");
        
        mealList = new ArrayList<>();
        mealList.add(MealType.BREAFAST);
        mealList.add(MealType.SNACK);
        mealList.add(MealType.LUNCH);
        mealList.add(MealType.DINNER);
        
        meals = FXCollections.observableList(mealList);
        
        mealComboBox = new ComboBox(meals);
        
        gpane.add(mealTypeLabel, 0, 0);
        gpane.add(mealComboBox, 1, 0);
        gpane.add(foodLabel, 2, 0);
        gpane.add(foodTextField, 3, 0, 2, 1);
        gpane.add(dateLabel, 5, 0);
        gpane.add(datePicker, 6, 0);
        gpane.add(numOfServings, 0, 1);
        gpane.add(servingSize, 2, 1);
        gpane.add(proteinLabel, 4, 1);
        gpane.add(fatLabel, 6, 1);
        gpane.add(addButton, 7, 1);
        gpane.add(removeButton, 7, 2);
        gpane.add(carbsLabel, 0, 2);
        gpane.add(sugarLabel, 2, 2);
        gpane.add(fiberLabel, 4, 2);
        gpane.add(caloriesLabel, 6, 2);
      
        gpane.setAlignment(Pos.CENTER);
        gpane.setPadding(new Insets(7, 0, 7, 0));
        gpane.setHgap(7);
        gpane.setVgap(7);
        
        // add button styles
        addButton.setStyle(
                "-fx-background-color: #39a316;"
                + "-fx-background-radius: 30;"
                + "-fx-text-fill: white;"
                + "-fx-font-size: 14px;"
        );

        removeButton.setStyle(
                "-fx-background-color: #c11f1f;"
                + "-fx-background-radius: 30;"
                + "-fx-text-fill: white;"
                + "-fx-font-size: 14px;"
        );

        addButton.setOnMouseEntered(event -> {
            addButton.setStyle(
                    "-fx-background-color: #4ddb1e;"
                    + "-fx-background-radius: 30;"
                    + "-fx-text-fill: white;"
                    + "-fx-font-size: 14px;"
            );
        });

        addButton.setOnMouseExited(event -> {
            addButton.setStyle(
                    "-fx-background-color: #39a316;"
                    + "-fx-background-radius: 30;"
                    + "-fx-text-fill: white;"
                    + "-fx-font-size: 14px;"
            );
        });

        removeButton.setOnMouseEntered(event -> {
            removeButton.setStyle(
                    "-fx-background-color: #e83535;"
                    + "-fx-background-radius: 30;"
                    + "-fx-text-fill: white;"
                    + "-fx-font-size: 14px;"
            );
        });

        removeButton.setOnMouseExited(event -> {
            removeButton.setStyle(
                    "-fx-background-color: #c11f1f;"
                    + "-fx-background-radius: 30;"
                    + "-fx-text-fill: white;"
                    + "-fx-font-size: 14px;"
            );
        });

        dateSelectionBox.getChildren().addAll(fromLabel, fromDatePicker, toLabel, toDatePicker);

        gpane.setBackground(
                new Background(
                        new BackgroundFill(
                                Paint.valueOf("#3a3b3d"),
                                CornerRadii.EMPTY,
                                Insets.EMPTY)));

        container.getChildren().addAll(dateSelectionBox, gpane);

    }//end default constructor

    public Pane getPane() {
        return container;
    }
}//end MacrosController
