import java.util.List;

public class SingleChoiceQuestion extends Question {

    public SingleChoiceQuestion(String questionText, List<String> options) {
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
