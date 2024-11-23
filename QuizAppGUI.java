import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class QuizAppGUI {

    // JDBC connection variables
    private static final String DB_URL = "jdbc:mysql://localhost:3306/quiz_app"; // Change the URL, username, and password as needed
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";  // Update your DB password
    
    public static void main(String[] args) {
        // Creating the JFrame for the GUI
        JFrame frame = new JFrame("Online Quiz App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        
        // Create main panel and set layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // Add title
        JLabel titleLabel = new JLabel("Select User Type", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);
        
        // Create buttons for user selection
        JPanel buttonPanel = new JPanel();
        JButton studentButton = new JButton("Student");
        JButton teacherButton = new JButton("Teacher");
        
        // Add buttons to button panel
        buttonPanel.add(studentButton);
        buttonPanel.add(teacherButton);
        
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        // Add action listeners to buttons
        studentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openStudentPage();
            }
        });
        
        teacherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openTeacherPage();
            }
        });

        // Add panel to frame
        frame.add(panel);
        
        // Display the GUI
        frame.setVisible(true);
    }

    // Method to open the Student page
    private static void openStudentPage() {
        JFrame studentFrame = new JFrame("Student Area");
        studentFrame.setSize(400, 300);
        studentFrame.setLocationRelativeTo(null);
        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel welcomeLabel = new JLabel("Welcome Student!", JLabel.CENTER);
        studentFrame.add(welcomeLabel, BorderLayout.CENTER);
        
        JButton takeQuizButton = new JButton("Take Quiz");
        takeQuizButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open quiz page (can be another JFrame or a different function)
                JOptionPane.showMessageDialog(studentFrame, "Redirecting to quiz page...");
            }
        });
        
        studentFrame.add(takeQuizButton, BorderLayout.SOUTH);
        studentFrame.setVisible(true);
    }

    // Method to open the Teacher page (you can customize this as well)
    private static void openTeacherPage() {
        JFrame teacherFrame = new JFrame("Teacher Area");
        teacherFrame.setSize(400, 300);
        teacherFrame.setLocationRelativeTo(null);
        teacherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel welcomeLabel = new JLabel("Welcome Teacher!", JLabel.CENTER);
        teacherFrame.add(welcomeLabel, BorderLayout.CENTER);
        
        teacherFrame.setVisible(true);
    }

    // Method to connect to the database using JDBC
    private static Connection connectToDatabase() {
        try {
            // Establishing the connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Example function to fetch user data (can be extended for more queries)
    private static void fetchDataFromDatabase() {
        try (Connection conn = connectToDatabase()) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM users");
                
                while (rs.next()) {
                    String username = rs.getString("username");
                    System.out.println("Username: " + username);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
