package Task2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CurrencyConverterView extends Application {
    private CurrencyConverterController controller;

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) {
        CurrencyConverterModel model = new CurrencyConverterModel();
        controller = new CurrencyConverterController(model);

        primaryStage.setTitle("Currency Converter");

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();
        Label sourceLabel = new Label("Source Currency:");
        ChoiceBox<String> sourceCurrencyChoiceBox = new ChoiceBox<>();
        Label targetLabel = new Label("Target Currency:");
        ChoiceBox<String> targetCurrencyChoiceBox = new ChoiceBox<>();
        Button convertButton = new Button("Convert");
        Label resultLabel = new Label("Result:");

        sourceCurrencyChoiceBox.getItems().addAll(controller.getAvailableCurrencies());
        targetCurrencyChoiceBox.getItems().addAll(controller.getAvailableCurrencies());

        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String sourceCurrency = sourceCurrencyChoiceBox.getValue();
                String targetCurrency = targetCurrencyChoiceBox.getValue();

                double result = controller.convert(amount, sourceCurrency, targetCurrency);

                resultLabel.setText("Result: " + result + " " + targetCurrency);
            } catch (NumberFormatException | NullPointerException ex) {
                // Handle invalid input
                resultLabel.setText("Result: Invalid input");
            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(amountLabel, 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(sourceLabel, 0, 1);
        grid.add(sourceCurrencyChoiceBox, 1, 1);
        grid.add(targetLabel, 0, 2);
        grid.add(targetCurrencyChoiceBox, 1, 2);
        grid.add(convertButton, 0, 3, 2, 1);
        grid.add(resultLabel, 0, 4, 2, 1);

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);

// Use ClassLoader to load CSS file
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.show();
    }
}
