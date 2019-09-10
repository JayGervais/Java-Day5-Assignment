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
    private TextArea txtText;

    @FXML
    private Button btnText;

    @FXML
    private TextField txtSentence;

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
        assert txtSentence != null : "fx:id=\"txtSentence\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtLines != null : "fx:id=\"txtLines\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtWords != null : "fx:id=\"txtWords\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtChars != null : "fx:id=\"txtChars\" was not injected: check your FXML file 'sample.fxml'.";
    }

    @FXML
    void analyzeTextClicked(ActionEvent event)
    {
        // get sentences
        int sentenceCount = getSentences(txtText);
        txtSentence.setText((String.valueOf(sentenceCount)));

        // get line number
        int lineCount = getLines(txtText);
        txtLines.setText(String.valueOf(lineCount));

        // get word count
        int wordCount = getWords(txtText);
        txtWords.setText(String.valueOf(wordCount));

        // get character count
        int charCount = getChars(txtText);
        txtChars.setText(String.valueOf(charCount));
    }

    private static int getSentences(TextArea txtText)
    {
        if (txtText.getText().isEmpty())
        {
            return 0;
        }
        else
        {
            String[] sentences = txtText.getText().split("[.]+");
            return sentences.length;
        }
    }

    private static int getWords(TextArea txtText)
    {
        String toCount = txtText.getText();
        if (toCount.isEmpty())
        {
            return 0;
        }
        else
        {
            String[] words = toCount.split("[\\s]+");
            return words.length;
        }
    }

    private static int getLines(TextArea txtText)
    {
        if (txtText.getText().isEmpty())
        {
            return 0;
        }
        else
        {
            String[] lines = txtText.getText().split("[\n]+");
            return lines.length;
        }
    }

    private static int getChars(TextArea txtText)
    {
        String chars = txtText.getText().replaceAll("[ \t\n]+", "");
        return chars.length();
    }

    public void resetFields(ActionEvent actionEvent)
    {
        // clear fields
        txtText.clear();
        txtChars.clear();
        txtLines.clear();
        txtWords.clear();
    }

    public void exitApplication(ActionEvent actionEvent)
    {
        // exit application
        System.exit(0);
    }
}
