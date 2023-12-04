package Task1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    private Task1.DictionaryController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Task1.Dictionary dictionary = new Task1.Dictionary();
        controller = new Task1.DictionaryController(dictionary);

        TextField wordInput = new TextField();
        Button searchButton = new Button("Search");
        Label meaningLabel = new Label();

        searchButton.setOnAction(e -> {
            String word = wordInput.getText();
            String meaning = controller.searchWord(word);
            meaningLabel.setText(meaning);
        });

        FlowPane root = new FlowPane();
        root.getChildren().addAll(wordInput, searchButton, meaningLabel);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Virtual Dictionary");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

