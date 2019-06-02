package healthIQ.charts;

import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class PieCharts {
    
    private final PieChart chart;
    private Label percentageLabel;
    private double prefWidth = HealthIQ.primaryStage.getScene().getWidth(); //* 0.66;
    private double prefHeight = HealthIQ.primaryStage.getScene().getHeight(); //* 0.66;
    private double maxWidth = prefWidth;
    private double maxHeight = prefHeight;
    private ObservableList<PieChart.Data> data;
    
    public PieCharts(String title, ObservableList<PieChart.Data> data){
        this.data = data;
        chart = new PieChart(data);
        chart.setStyle("-fx-font-family: Cambria; ");
        chart.setTitle(title);
        chart.setLegendVisible(false);
        chart.setLegendSide(Side.BOTTOM);
        percentageLabel = new Label("");
        
        chart.setPrefSize(prefWidth, prefHeight);
        chart.setMaxSize(maxWidth, maxHeight);
       
    }//end constructor
    
    public PieChart getPieChart(){
        return chart;
    }//end getPieChart
    
    public Label getLabel(){
        return percentageLabel;
    }
    
    public void setLabelText(String text){
        percentageLabel.setText(text);
    }
    
    public ObservableList<PieChart.Data> getData(){
        return data;
    }
    
    
    
}//end PieCharts
