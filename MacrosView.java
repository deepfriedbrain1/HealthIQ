package healthIQ.charts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Alberto Fernandez Saucedo
 */
public class MacrosView {
    private Text netCarbsText;
    private Text proteinText;
    private Text fatText;
    private Label percentageLabel;
    
    public MacrosView() {

        netCarbsText = new Text("NA");
        proteinText = new Text("NA");
        fatText = new Text("NA");
        percentageLabel = new Label("");
        percentageLabel.setTextFill(Color.BLACK);
        percentageLabel.setStyle("-fx-font: 22 cambria;");

        // Create Pie Chart with dummy data  
        PieCharts pChart = new PieCharts("My Macros", new ChartDummyData().getPieChartData());
        
        pChart.getPieChart().getData().stream().map((slice) -> {
            slice.getNode().setOnMousePressed((MouseEvent e) -> {
                percentageLabel.setTranslateX(e.getSceneX() - (percentageLabel.getLayoutX() + 220));
                percentageLabel.setTranslateY(e.getSceneY() - (percentageLabel.getLayoutY() + 75));
                percentageLabel.setText(slice.getPieValue() + "%");

            });
            return slice;
        }).forEachOrdered((slice) -> {
            slice.getNode().setOnMouseReleased((MouseEvent e) -> {
                percentageLabel.setText("");
            });
        });

        pChart.getData().forEach((data) -> {
            if (data.getName().equalsIgnoreCase("carbs")) {
                netCarbsText.setText(data.getPieValue() + "% Net Carbs");
            } else if (data.getName().equalsIgnoreCase("fat")) {
                fatText.setText(data.getPieValue() + "% Fat");
            } else if (data.getName().equalsIgnoreCase("protein")) {
                proteinText.setText(data.getPieValue() + "% Protein");
            }
        });

        StackPane spane = new StackPane();
        spane.setAlignment(Pos.CENTER);
        spane.setPadding(new Insets(0, 0, 0, 0));
        spane.getChildren().addAll(pChart.getPieChart(), percentageLabel);
        spane.setMaxWidth(pChart.getPieChart().getMaxWidth() / 1.5);
        spane.setMaxHeight(pChart.getPieChart().getMaxHeight());

        VBox statsVBox = new VBox();
        statsVBox.setSpacing(0);
        statsVBox.setAlignment(Pos.CENTER);

        netCarbsText.setFont(new Font("Cambria", 25));
        netCarbsText.setFill(Paint.valueOf("white"));
        StackPane netCarbsPane = new StackPane();
        netCarbsPane.getChildren().add(netCarbsText);
        netCarbsPane.setBackground(
                new Background(
                        new BackgroundFill(
                                Paint.valueOf("#c62e65"),
                                new CornerRadii(20.0),
                                Insets.EMPTY)));

        proteinText.setFont(new Font("Cambria", 25));
        proteinText.setFill(Paint.valueOf("white"));
        StackPane proteinPane = new StackPane();
        proteinPane.getChildren().add(proteinText);
        proteinPane.setBackground(
                new Background(
                        new BackgroundFill(
                                Paint.valueOf("#094074"),
                                new CornerRadii(20.0),
                                Insets.EMPTY)));

        fatText.setFont(new Font("Cambria", 25));
        fatText.setFill(Paint.valueOf("white"));
        StackPane fatPane = new StackPane();
        fatPane.getChildren().add(fatText);
        fatPane.setBackground(
                new Background(
                        new BackgroundFill(
                                Paint.valueOf("#f7cb15"),
                                new CornerRadii(20.0),
                                Insets.EMPTY)));

        netCarbsPane.setMaxWidth(200);
        proteinPane.setMaxWidth(200);
        fatPane.setMaxWidth(200);

        VBox.setMargin(netCarbsPane, new Insets(5, 5, 5, 5));
        VBox.setMargin(proteinPane, new Insets(5, 5, 5, 5));
        VBox.setMargin(fatPane, new Insets(5, 5, 5, 5));
        statsVBox.getChildren().addAll(pChart.getPieChart(), percentageLabel, netCarbsPane, proteinPane, fatPane);
        statsVBox.setMaxWidth(pChart.getPieChart().getMaxWidth());
        statsVBox.setBackground(new Background(new BackgroundFill(
            null,
            CornerRadii.EMPTY,
            Insets.EMPTY)));
        spane.setBackground(new Background(new BackgroundFill(
            null,
            CornerRadii.EMPTY,
            new Insets(0, 0, 0, 0))));
        MacrosController macControl = new MacrosController();

        BorderPane bpane = new BorderPane();
        bpane.setPadding(new Insets(20, 20, 20, 20));
        bpane.setLeft(new StackPane(new FoodTable().getTable()));
        bpane.setCenter(statsVBox);

        bpane.setBottom(macControl.getPane());

        Dashboard dashboard = new Dashboard();
        dashboard.setCenter(bpane);

        Scene scene = new Scene(
                dashboard.getPane(),
                HealthIQ.primaryStage.getScene().getWidth(),
                HealthIQ.primaryStage.getScene().getHeight());

        HealthIQ.primaryStage.setScene(scene);

        // This procedure must be implemented after chart has been drawn 
        pChart.getData().forEach((slice) -> {
            if (slice.getName().equalsIgnoreCase("fat")) {
                slice.getNode().setStyle("-fx-pie-color: #f7cb15;");          
            } else if (slice.getName().equalsIgnoreCase("protein")) {
                slice.getNode().setStyle("-fx-pie-color: #094074;");
            } else if (slice.getName().equalsIgnoreCase("carbs")) {
                slice.getNode().setStyle("-fx-pie-color: #c62e65;");
            }
        });
    }//end constructor
}//end MacrosView
