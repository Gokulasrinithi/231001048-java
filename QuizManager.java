import java.sql.*;
import java.util.Scanner;

public class QuizManager {

    // Method to view all questions from the database
    public static void viewQuestions() {
        String query = "SELECT * FROM questions";
        
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("QID: " + resultSet.getInt("id"));
                System.out.println("Question: " + resultSet.getString("question"));
                System.out.println("1. " + resultSet.getString("option1"));
                System.out.println("2. " + resultSet.getString("option2"));
                System.out.println("3. " + resultSet.getString("option3"));
                System.out.println("4. " + resultSet.getString("option4"));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new question to the database
    public static void addQuestion(String question, String option1, String option2, String option3, String option4, int correctOption) {
        String query = "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, question);
            preparedStatement.setString(2, option1);
            preparedStatement.setString(3, option2);
            preparedStatement.setString(4, option3);
            preparedStatement.setString(5, option4);
            preparedStatement.setInt(6, correctOption);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Question added successfully. Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to take the quiz and calculate score
    public static void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        String query = "SELECT * FROM questions";
        int score = 0;

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("Question: " + resultSet.getString("question"));
                System.out.println("1. " + resultSet.getString("option1"));
                System.out.println("2. " + resultSet.getString("option2"));
                System.out.println("3. " + resultSet.getString("option3"));
                System.out.println("4. " + resultSet.getString("option4"));
                System.out.print("Your answer (1-4): ");
                int userAnswer = scanner.nextInt();

                int correctAnswer = resultSet.getInt("correct_option");

                if (userAnswer == correctAnswer) {
                    score++;
                }
            }

            System.out.println("Quiz Over! Your score: " + score);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
