import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Online Quiz App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Main container panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Title of the app
        JLabel titleLabel = new JLabel("Online Quiz App", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Border line (using a JSeparator)
        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(600, 2));
        mainPanel.add(separator, BorderLayout.CENTER);

        // Panel for user selection
        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.Y_AXIS));
        selectionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Heading
        JLabel selectLabel = new JLabel("Select user type");
        selectLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        selectionPanel.add(selectLabel);
        selectionPanel.add(Box.createVerticalStrut(20)); // Spacer

        // Button Panel for Student and Teacher
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton studentButton = new JButton("Student");
        studentButton.setPreferredSize(new Dimension(150, 40));
        studentButton.setBackground(Color.BLUE);
        studentButton.setForeground(Color.WHITE);
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the Student page when Student button is clicked
                frame.setVisible(false); // Hide the LoginPage
                new Student(); // Open the Student quiz page
            }
        });

        JButton teacherButton = new JButton("Teacher");
        teacherButton.setPreferredSize(new Dimension(150, 40));
        teacherButton.setBackground(Color.GREEN);
        teacherButton.setForeground(Color.WHITE);
        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open TeacherPage when Teacher button is clicked
                frame.setVisible(false); // Hide the LoginPage
                new TeacherPage(); // Open TeacherPage
            }
        });

        buttonPanel.add(studentButton);
        buttonPanel.add(teacherButton);

        // Add the button panel to the selection panel
        selectionPanel.add(buttonPanel);

        // Add the selection panel to the main panel
        mainPanel.add(selectionPanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Display the frame
        frame.setVisible(true);
    }
}
