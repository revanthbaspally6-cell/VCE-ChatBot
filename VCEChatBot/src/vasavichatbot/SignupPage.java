package vasavichatbot;

import javax.swing.*;
import java.awt.*;

public class SignupPage extends JFrame {

    private JTextField usernameField, emailField;
    private JPasswordField passwordField, confirmField;
    private JButton signupButton, loginButton;
    private JLabel logoLabel, titleLabel;

    public SignupPage() {
        setTitle("Vasavi College ChatBot - Signup");
        setSize(420, 620);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        ImageIcon logo = new ImageIcon("assets/vce_logo.png");
        logoLabel = new JLabel(logo);
        logoLabel.setBounds(140, 20, 140, 140);
        add(logoLabel);

        titleLabel = new JLabel("Create New Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(60, 160, 300, 30);
        add(titleLabel);

        JLabel userLbl = new JLabel("Username");
        userLbl.setBounds(60, 220, 300, 20);
        add(userLbl);

        usernameField = new JTextField();
        usernameField.setBounds(60, 245, 300, 35);
        add(usernameField);

        JLabel emailLbl = new JLabel("Email");
        emailLbl.setBounds(60, 295, 300, 20);
        add(emailLbl);

        emailField = new JTextField();
        emailField.setBounds(60, 320, 300, 35);
        add(emailField);

        JLabel passLbl = new JLabel("Password");
        passLbl.setBounds(60, 370, 300, 20);
        add(passLbl);

        passwordField = new JPasswordField();
        passwordField.setBounds(60, 395, 300, 35);
        add(passwordField);

        JLabel confirmLbl = new JLabel("Confirm Password");
        confirmLbl.setBounds(60, 445, 300, 20);
        add(confirmLbl);

        confirmField = new JPasswordField();
        confirmField.setBounds(60, 470, 300, 35);
        add(confirmField);

        signupButton = new JButton("Sign Up");
        signupButton.setBounds(60, 525, 300, 40);
        add(signupButton);

        loginButton = new JButton("Already have an account?");
        loginButton.setBounds(60, 570, 300, 28);
        add(loginButton);

        signupButton.addActionListener(e -> registerUser());
        loginButton.addActionListener(e -> {
            new LoginPage().setVisible(true);
            dispose();
        });

        setVisible(true);
    }

    private void registerUser() {
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String pass = new String(passwordField.getPassword()).trim();
        String confirm = new String(confirmField.getPassword()).trim();

        if (username.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields required");
            return;
        }

        if (!pass.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match");
            return;
        }

        if (FileUtils.userExists(username)) {
            JOptionPane.showMessageDialog(this, "Username already exists");
            return;
        }

        if (!FileUtils.saveUser(username, pass)) {
            JOptionPane.showMessageDialog(this, "Failed to save user. Try again.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Account created successfully");

        new LoginPage().setVisible(true);
        dispose();
    }
}
