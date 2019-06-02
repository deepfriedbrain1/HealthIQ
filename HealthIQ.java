package healthIQ.charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class HealthIQ extends Application {

    protected static Stage primaryStage;
    private final int DEFAULT_WIDTH = 1300;
    private final int DEFAULT_HEIGHT = 670;
    private final String TITLE = "HealthIQ";

    @Override
    public void start(Stage primaryStage) {
        HealthIQ.primaryStage = primaryStage;

        // Create main dashboard with login
        Dashboard d = new Dashboard();
        d.setCenter(new LogIn().getPane());
        
        Scene scene = new Scene(d.getPane(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
        HealthIQ.primaryStage.setScene(scene);
        HealthIQ.primaryStage.setTitle(TITLE);
        HealthIQ.primaryStage.show();
        
    }//end start

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }//end main

}//end HealthIQ
