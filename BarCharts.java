package healthIQ.charts;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Series;
/**
 *
 * @author Alberto Fernandez Saucedo
 * @param <V>
 * @param <K>
 */
public class BarCharts<V, K> {
    
    private final static Map<String, Axis> AXIS_TABLE;
    static {
        AXIS_TABLE = new HashMap();
        AXIS_TABLE.put("String", new CategoryAxis());
        AXIS_TABLE.put("Number", new NumberAxis());
    }
    
    private BarChart<V, K> barChart;
    private Axis xAxis;
    private Axis yAxis;
    
    /**
     * BarCharts Constructor
     * @param title The title of the Bar Chart
     * @param xAxisType Category or Number Type of x axis
     * @param yAxisType Category or Number Type of y axis
     * @param xAxisLabel Label for the x axis
     * @param yAxisLabel Label for the y axis
     */
    public BarCharts(String title, String xAxisType, String yAxisType, 
                     String xAxisLabel, String yAxisLabel){
        
        xAxis = getTypeOfAxis(xAxisType);
        yAxis = getTypeOfAxis(yAxisType);
        barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle(title);
        xAxis.setLabel(xAxisLabel);
        yAxis.setLabel(yAxisLabel);
    }//end constructor
    
    public void addData(Series series){
        barChart.getData().add(series);
    }
    
    public BarChart getBarChart(){
        return barChart;
    }
    private Axis getTypeOfAxis(String type){
        return AXIS_TABLE.get(type);
    }
    
}//end BarCharts
