import java.util.List;

public abstract class Question {
    private String questionText;
    private List<String> options;

    // Constructor
    public Question(String questionText, List<String> options) {
        this.questionText = questionText;
        this.options = options;
    }

    // Getter for questionText
    public String getQuestionText() {
        return questionText;
    }

    // Getter for options
    public List<String> getOptions() {
        return options;
    }

    // Abstract method to display the question and its options
    public abstract void displayQuestion();
}
