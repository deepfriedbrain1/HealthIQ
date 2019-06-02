package healthIQ.charts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class FoodTable {

    private TableView table;
    private final TableColumn mealTypeCol,
            foodDescCol,
            numOfServingsCol,
            servingSizeCol,
            proteinCol,
            fatCol,
            carbsCol,
            sugarCol,
            fiberCol, 
            calorieCol,
            dateCol;

    private final ObservableList<FoodItem> data
            = FXCollections.observableArrayList(
                    new FoodItem(MealType.LUNCH, "Cheese", 8.0f, 4.0f, 4.5f, 7.5f, 0.0f, java.time.LocalDate.now())
            );

    public FoodTable() {
        table = new TableView();
        table.setEditable(true);

        mealTypeCol = new TableColumn("Meal Type");
        foodDescCol = new TableColumn("Food / Drink"); 
        numOfServingsCol = new TableColumn("# of \n servings"); 
        servingSizeCol = new TableColumn("Serving \n size");
        proteinCol = new TableColumn("Protein \n (g)");
        fatCol = new TableColumn("Fat \n (g)");
        carbsCol = new TableColumn("Carbs \n (g)");
        sugarCol = new TableColumn("Sugar \n (g)");
        fiberCol = new TableColumn("Fiber \n (g)"); 
        calorieCol = new TableColumn("Calories");
        dateCol = new TableColumn("Date");

        mealTypeCol.setCellValueFactory(new PropertyValueFactory<>("mealType")); 
        numOfServingsCol.setCellValueFactory(new PropertyValueFactory<>("numOfServings")); 
        servingSizeCol.setCellValueFactory(new PropertyValueFactory<>("servingSize"));
        foodDescCol.setCellValueFactory(new PropertyValueFactory<>("foodDesc"));
        proteinCol.setCellValueFactory(new PropertyValueFactory<>("protein"));
        fatCol.setCellValueFactory(new PropertyValueFactory<>("fat"));
        carbsCol.setCellValueFactory(new PropertyValueFactory<>("carbs"));
        sugarCol.setCellValueFactory(new PropertyValueFactory<>("sugar"));
        fiberCol.setCellValueFactory(new PropertyValueFactory<>("fiber"));
        calorieCol.setCellValueFactory(new PropertyValueFactory<>("calories"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
                
        table.setItems(data);
        table.getColumns().addAll(mealTypeCol, foodDescCol, numOfServingsCol, 
                servingSizeCol, proteinCol, fatCol, carbsCol, sugarCol, 
                fiberCol, calorieCol, dateCol);

    }//end constructor

    public TableView getTable() {
        return table;
    }
}//end FoodTable
