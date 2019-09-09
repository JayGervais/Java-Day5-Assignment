package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller
{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtText;

    @FXML
    private Button btnText;

    @FXML
    private TextField txtLines;

    @FXML
    private TextField txtWords;

    @FXML
    private TextField txtChars;

    @FXML
    void initialize() {
        assert txtText != null : "fx:id=\"txtText\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnText != null : "fx:id=\"btnText\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtLines != null : "fx:id=\"txtLines\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtWords != null : "fx:id=\"txtWords\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtChars != null : "fx:id=\"txtChars\" was not injected: check your FXML file 'sample.fxml'.";
    }

    @FXML
    void analyzeTextClicked(ActionEvent event)
    {
        int lineCount = getLines(txtText);
        txtLines.setText(String.valueOf(lineCount));

        int wordCount = getWords(txtText);
        txtWords.setText(String.valueOf(wordCount));

        int charCount = txtText.getText().length();
        txtChars.setText(String.valueOf(charCount));
    }

    private static int getWords(TextArea txtText)
    {
        if (txtText == null)
        {
            return 0;
        }

        String toCount = txtText.getText();

        String[] words = toCount.split("\\s+");
        return words.length;
    }

    private static int getLines(TextArea txtText)
    {
        if (txtText == null)
        {
            return 0;
        }
        return txtText.getText().split("\n").length;
    }

    public void resetFields(ActionEvent actionEvent)
    {
        txtText.clear();
        txtChars.clear();
        txtLines.clear();
        txtWords.clear();
    }

    public void exitApplication(ActionEvent actionEvent)
    {
        Platform.exit();
    }
}
