
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class LineCharts {
    
    private final CategoryAxis xAxis;
    private final NumberAxis yAxis;
    private final LineChart<String, Number> lineChart;
    
    public LineCharts(String title, String xAxisLabel){
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        xAxis.setLabel(xAxisLabel);
        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle(title);    
    }//end constructor
    
    public void addData(XYChart.Series data){
        lineChart.getData().add(data);
    }
    
    public LineChart getLineChart(){
        return lineChart;
    }
    
}//end LineCharts
