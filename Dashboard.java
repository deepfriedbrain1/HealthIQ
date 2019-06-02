package healthIQ.charts;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class Dashboard {
    private BorderPane bpane; 
    private Label appTitle;
    private StackPane titlePane;
    
    public Dashboard() {
        // Create title
        appTitle = new Label("HealthIQ");
        appTitle.setFont(new Font("Cambria", 40));
        appTitle.setTextFill(Paint.valueOf("#ffffff"));
        titlePane = new StackPane();
        titlePane.setStyle("-fx-background-color: rgb(58, 59, 61);");
        titlePane.getChildren().add(appTitle);        

        // Render main dashboard view
        bpane = new BorderPane();
        bpane.setTop(titlePane);
        bpane.setLeft(new SideNav().getSideNav());
    }//end constructor
    
    // set the center view of the dashboard
    protected void setCenter(Pane pane){
        bpane.setCenter(pane);
    }
    
    protected Pane getPane(){
        return bpane;
    }
}
