import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class VotingService {
    private Question question;
    private Map<String, Object> studentSubmissions = new HashMap<>(); // Map studentID to their answer

    // Configure the question for voting
    public void configureQuestion(Question question) {
        this.question = question;
        studentSubmissions.clear(); // Clear previous submissions if any
    }

    // Accept student's answer submission
    public void acceptSubmission(Student student) {
        studentSubmissions.put(student.getStudentID(), student.getAnswer());
    }

    // Display the voting statistics
    public void outputStatistics() {
        Map<Object, Integer> answerCounts = new HashMap<>(); // Map each answer to its count

        for (Object answer : studentSubmissions.values()) {
            if (question instanceof SingleChoiceQuestion) {
                answerCounts.put(answer, answerCounts.getOrDefault(answer, 0) + 1);
            } else if (question instanceof MultipleChoiceQuestion && answer instanceof List) {
                List<String> answers = (List<String>) answer;
                for (String ans : answers) {
                    answerCounts.put(ans, answerCounts.getOrDefault(ans, 0) + 1);
                }
            }
        }

        // Print the results
        for (Map.Entry<Object, Integer> entry : answerCounts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
