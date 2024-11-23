import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizAppInterface {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Online Quiz App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Main panel for the app content
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Title label
        JLabel titleLabel = new JLabel("Online Quiz App", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Divider (Border Line)
        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(600, 2));
        mainPanel.add(separator, BorderLayout.CENTER);

        // Selection Panel for user type (Student or Teacher)
        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.Y_AXIS));
        selectionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Heading
        JLabel selectLabel = new JLabel("Select user type");
        selectLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        selectionPanel.add(selectLabel);
        selectionPanel.add(Box.createVerticalStrut(20)); // Spacer

        // Panel for the buttons (Student and Teacher)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Button for Student
        JButton studentButton = new JButton("Student");
        studentButton.setPreferredSize(new Dimension(150, 40));
        studentButton.setBackground(Color.BLUE);
        studentButton.setForeground(Color.WHITE);
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a message that the Student option was selected
                JOptionPane.showMessageDialog(frame, "Student selected.");
                // Here, you could navigate to another screen for the student (e.g., a quiz screen).
            }
        });

        // Button for Teacher
        JButton teacherButton = new JButton("Teacher");
        teacherButton.setPreferredSize(new Dimension(150, 40));
        teacherButton.setBackground(Color.GREEN);
        teacherButton.setForeground(Color.WHITE);
        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a message that the Teacher option was selected
                JOptionPane.showMessageDialog(frame, "Teacher selected.");
                // Here, you could navigate to another screen for the teacher (e.g., a quiz management screen).
            }
        });

        // Add buttons to button panel
        buttonPanel.add(studentButton);
        buttonPanel.add(teacherButton);

        // Add button panel to the selection panel
        selectionPanel.add(buttonPanel);

        // Add the selection panel to the main panel
        mainPanel.add(selectionPanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Display the frame
        frame.setVisible(true);
    }
}
