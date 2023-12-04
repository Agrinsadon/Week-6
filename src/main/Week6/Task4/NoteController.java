package Task4;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class NoteController extends Application {
    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private Button addButton;

    @FXML
    private VBox notesContainer;

    private NoteBook notebook;

    public NoteController() {
        this.notebook = new NoteBook();
    }

    @FXML
    private void initialize() {
        addButton.setOnAction(event -> addNote());
    }

    private void addNote() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (!title.isEmpty() && !content.isEmpty()) {
            Note newNote = new Note(title, content);
            notebook.addNote(newNote);
            displayNotes();
        }
    }

    private void displayNotes() {
        notesContainer.getChildren().clear();

        for (Note note : notebook.getNotes()) {
            notesContainer.getChildren().add(new javafx.scene.control.Label(note.toString()));
        }
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("note_app.fxml"));
            VBox root = loader.load();

            Scene scene = new Scene(root, 400, 400);

            primaryStage.setTitle("Note Taking App");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
