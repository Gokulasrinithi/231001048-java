import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherPage {

    public TeacherPage() {
        // Create a JFrame (the main window)
        JFrame frame = new JFrame("Online Quiz System - Teacher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.DARK_GRAY);
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel headerLabel = new JLabel("Online Quiz System");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        // Add the header panel to the main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Navigation Panel (replicating the navbar)
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton homeButton = new JButton("Home");
        JButton quizButton = new JButton("Quiz");
        JButton logoutButton = new JButton("Log out");

        homeButton.setPreferredSize(new Dimension(100, 40));
        quizButton.setPreferredSize(new Dimension(100, 40));
        logoutButton.setPreferredSize(new Dimension(100, 40));

        navPanel.add(homeButton);
        navPanel.add(quizButton);
        navPanel.add(logoutButton);

        // Add the navigation panel to the main panel
        mainPanel.add(navPanel, BorderLayout.CENTER);

        // Welcome and Description Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("Welcome Teacher!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descriptionLabel = new JLabel("<html><small>This is a teacher area where you can add quizzes and see the results.</small></html>");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPanel.add(welcomeLabel);
        contentPanel.add(Box.createVerticalStrut(20)); // Spacer
        contentPanel.add(descriptionLabel);

        // Add the content panel to the main panel
        mainPanel.add(contentPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Log out action (simulated with a dialog box)
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show a confirmation message
                int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    // Close the TeacherPage and open the LoginPage
                    frame.setVisible(false); // Close TeacherPage
                    new LoginPage(); // Open LoginPage
                }
            }
        });

        // Display the frame
        frame.setVisible(true);
    }
}
