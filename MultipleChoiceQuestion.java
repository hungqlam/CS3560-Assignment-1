import java.util.List;

public class MultipleChoiceQuestion extends Question {

    public MultipleChoiceQuestion(String questionText, List<String> options) {
        super(questionText, options);
    }

    @Override
    public void displayQuestion() {
        System.out.println(getQuestionText());
        for (String option : getOptions()) {
            System.out.println(option);
        }
    }
}
