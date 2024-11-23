import java.util.Scanner;

public class QuizApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizManager quizManager = new QuizManager();

        while (true) {
            System.out.println("Welcome to the Quiz Management System");
            System.out.println("1. View All Questions");
            System.out.println("2. Add New Question");
            System.out.println("3. Take the Quiz");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    quizManager.viewQuestions();
                    break;
                case 2:
                    System.out.print("Enter the question: ");
                    String question = scanner.nextLine();

                    System.out.print("Enter option 1: ");
                    String option1 = scanner.nextLine();

                    System.out.print("Enter option 2: ");
                    String option2 = scanner.nextLine();

                    System.out.print("Enter option 3: ");
                    String option3 = scanner.nextLine();

                    System.out.print("Enter option 4: ");
                    String option4 = scanner.nextLine();

                    System.out.print("Enter correct option number (1-4): ");
                    int correctOption = scanner.nextInt();

                    quizManager.addQuestion(question, option1, option2, option3, option4, correctOption);
                    break;
                case 3:
                    quizManager.takeQuiz();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
