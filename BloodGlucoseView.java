package healthIQ.charts;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class BloodGlucoseView {

    private final String DEFAULT_TIMESPAN = "Hourly";
    private final String DEFAULT_CHART_TITLE_TIMESPAN = "Today";
    private final String CHART_TITLE = "My Blood Glucose";

    public BloodGlucoseView() {

        // Create Line Chart with dummy data
        LineCharts lineChart = new LineCharts(
                CHART_TITLE + ", " + DEFAULT_CHART_TITLE_TIMESPAN, DEFAULT_TIMESPAN);
        lineChart.addData(new ChartDummyData().getLineChartData());
        
        BorderPane bpane = new BorderPane();
        bpane.setCenter(lineChart.getLineChart());
        Dashboard dashboard = new Dashboard();
        dashboard.setCenter(bpane);

        Scene scene = new Scene(
                dashboard.getPane(),
                HealthIQ.primaryStage.getScene().getWidth(),
                HealthIQ.primaryStage.getScene().getHeight());

        HealthIQ.primaryStage.setScene(scene);

    }//end constructor

}//end BloodGlucoseView
