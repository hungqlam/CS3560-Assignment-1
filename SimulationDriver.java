import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SimulationDriver {

    public static void main(String[] args) {
        // Create an instance of VotingService
        VotingService votingService = new VotingService();

        // Define multiple choice questions
        List<MultipleChoiceQuestion> mcQuestions = Arrays.asList(
                new MultipleChoiceQuestion("Which of the following are programming languages?",
                        Arrays.asList("A. Java", "B. Python", "C. HTML", "D. C++")),
                new MultipleChoiceQuestion("Which of these are not database management systems?",
                        Arrays.asList("A. Oracle", "B. MySQL", "C. Photoshop", "D. PostgreSQL")),
                new MultipleChoiceQuestion("Which of these are fruits?",
                        Arrays.asList("A. Apple", "B. Broccoli", "C. Banana", "D. Carrot")),
                new MultipleChoiceQuestion("Which of these are not planets?",
                        Arrays.asList("A. Mars", "B. Venus", "C. Pluto", "D. Neptune")),
                new MultipleChoiceQuestion("Which of these are not programming paradigms?",
                        Arrays.asList("A. OOP", "B. Procedural", "C. Declarative", "D. Illustrative"))
        );

        // Define single choice questions
        List<SingleChoiceQuestion> scQuestions = Arrays.asList(
                new SingleChoiceQuestion("Which language is primarily used for web styling?",
                        Arrays.asList("A. Java", "B. Python", "C. CSS", "D. C++")),
                new SingleChoiceQuestion("Which is the largest planet in our solar system?",
                        Arrays.asList("A. Mars", "B. Earth", "C. Jupiter", "D. Venus")),
                new SingleChoiceQuestion("Which of these is not a prime number?",
                        Arrays.asList("A. 7", "B. 11", "C. 15", "D. 3")),
                new SingleChoiceQuestion("Which animal is known as the king of the jungle?",
                        Arrays.asList("A. Tiger", "B. Lion", "C. Cheetah", "D. Leopard")),
                new SingleChoiceQuestion("Which of these is not a continent?",
                        Arrays.asList("A. Africa", "B. Europe", "C. Greenland", "D. Asia"))
        );

        // Simulate the process for multiple choice questions
        for (Question mcQuestion : mcQuestions) {
            simulateVotingProcess(votingService, mcQuestion);
        }

        // Simulate the process for single choice questions
        for (Question scQuestion : scQuestions) {
            simulateVotingProcess(votingService, scQuestion);
        }
    }

    // ... (previous code with the list of questions and main method)

    private static void simulateVotingProcess(VotingService votingService, Question question) {
        // Configure the question in VotingService
        votingService.configureQuestion(question);

        // Randomly generate students and their answers
        List<Student> students = generateRandomStudents(50, question);

        // Submit all the students' answers to iVote Service
        for (Student student : students) {
            votingService.acceptSubmission(student);
        }

        // Display the voting result
        System.out.println("Results for question: " + question.getQuestionText());
        votingService.outputStatistics();
        System.out.println("--------------------------------------------------");
    }

    // Method to generate random students with random answers
    private static List<Student> generateRandomStudents(int numStudents, Question question) {
        List<Student> students = new ArrayList<>();
        Random rand = new Random();

        for (int i = 1; i <= numStudents; i++) {
            Student student = new Student("student" + i);
            List<String> answers = new ArrayList<>(question.getOptions());

            if (question instanceof SingleChoiceQuestion) {
                // Randomly select one option for single choice questions
                student.submitAnswer(answers.get(rand.nextInt(answers.size())));
            } else {
                List<String> selectedAnswers = new ArrayList<>();
                int numAnswers = rand.nextInt(4) + 1; // Randomly select 1 to 4 options
                for (int j = 0; j < numAnswers; j++) {
                    int randomIndex = rand.nextInt(answers.size());
                    selectedAnswers.add(answers.remove(randomIndex));
                }
                student.submitAnswer(selectedAnswers);
            }

            students.add(student);
        }
        return students;
    }
}


