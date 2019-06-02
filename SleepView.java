package healthIQ.charts;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class SleepView {
    StackPane spane;
    public SleepView() {
        // Create Bar Chart with dummy data
        BarCharts<String, Number> barChart = new BarCharts("My Sleep",
                "String", "Number", "Day", "Hours");
        barChart.addData(new ChartDummyData().getBarChartData());

        spane = new StackPane();
        spane.getChildren().addAll(barChart.getBarChart());
        
        Dashboard dashboard = new Dashboard();
        dashboard.setCenter(spane);

        Scene scene = new Scene(
                dashboard.getPane(),
                HealthIQ.primaryStage.getScene().getWidth(),
                HealthIQ.primaryStage.getScene().getHeight());

        HealthIQ.primaryStage.setScene(scene);
    }
}
