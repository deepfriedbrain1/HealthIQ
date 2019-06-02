package healthIQ.charts;

import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class ChartDummyData {

    private final static ObservableList<PieChart.Data> DATA; // Pie Chart data
    private final static XYChart.Series SERIES;              // Line Chart data
    private final static XYChart.Series SERIES_2;            // Bar Chart data

    static {
        Random random = new Random();
        int number;

        // Create Pie Chart data
        DATA = FXCollections.observableArrayList(
                new PieChart.Data("Carbs", 33.33),
                new PieChart.Data("Protein", 33.33),
                new PieChart.Data("Fat", 33.33)
        );

        // Create Line Chart data
        SERIES = new XYChart.Series();
        SERIES.setName("March, 2019");

        for (int i = 1; i < 32; i++) {
            number = random.nextInt(121-90) + 90;
            SERIES.getData().add(new XYChart.Data( i + "", number));  
        }

        // Create Bar Chart data 
        SERIES_2 = new XYChart.Series();
        SERIES_2.setName("Hours for March, 2019");

        for (int i = 1; i < 32; i++) {
            number = random.nextInt(12) + 1;
            SERIES_2.getData().add(new XYChart.Data(i + "", number));
        }

    }//end static

    public ObservableList<PieChart.Data> getPieChartData() {
        return DATA;
    }

    public XYChart.Series getLineChartData() {
        return SERIES;
    }

    public XYChart.Series getBarChartData() {
        return SERIES_2;
    }

}
