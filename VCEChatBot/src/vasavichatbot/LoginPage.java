package vasavichatbot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vasavichatbot.ui.ChatBotApp;

public class LoginPage extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signupButton;
    private JLabel logoLabel;

    public LoginPage() {
        setTitle("Vasavi College Chatbot - Login");
        setSize(420, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        // Load logo from assets folder (relative to project root)
        ImageIcon logo = new ImageIcon("assets/vce_logo.png");
        logoLabel = new JLabel(logo);
        logoLabel.setBounds(130, 20, 150, 150);
        add(logoLabel);

        JLabel title = new JLabel("VASAVI COLLEGE CHATBOT");
        title.setFont(new Font("Arial", Font.BOLD, 17));
        title.setBounds(70, 170, 300, 30);
        add(title);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(50, 230, 100, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 230, 200, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(50, 280, 100, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 280, 200, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(80, 350, 110, 35);
        loginButton.addActionListener(this);
        add(loginButton);

        signupButton = new JButton("Signup");
        signupButton.setBounds(220, 350, 110, 35);
        signupButton.addActionListener(this);
        add(signupButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = usernameField.getText().trim();
            String pass = new String(passwordField.getPassword()).trim();

            if (FileUtils.validateUser(user, pass)) {
                dispose();
                new ChatBotApp(user).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
        } else if (e.getSource() == signupButton) {
            dispose();
            new SignupPage().setVisible(true);
        }
    }
}
