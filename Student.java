public class Student {
    private String studentID;
    private Object answer; // Can be a String (for single choice) or List<String> (for multiple choices)

    // Constructor to initialize the student with a unique ID
    public Student(String studentID) {
        this.studentID = studentID;
    }

    // Method for the student to submit an answer
    public void submitAnswer(Object answer) {
        this.answer = answer;
    }

    // Getter method to retrieve the student's ID
    public String getStudentID() {
        return studentID;
    }

    // Getter method to retrieve the student's answer
    public Object getAnswer() {
        return answer;
    }
}
