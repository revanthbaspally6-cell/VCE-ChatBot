package vasavichatbot.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import vasavichatbot.BotLogic;
import vasavichatbot.BotResponseFormatter;

public class ChatBotApp extends JFrame {

    private JPanel chatPanel;
    private JScrollPane scrollPane;
    private JTextField inputField;
    private JButton sendButton;
    private TypingIndicator indicator;

    private ImageIcon botIconSmall;
    private ImageIcon userIconSmall;

    public ChatBotApp() {
        setTitle("Vasavi College Chatbot");
        setSize(470, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GradientPanel mainPanel = new GradientPanel(
                new Color(240, 244, 248),
                new Color(225, 232, 242)
        );
        mainPanel.setLayout(new BorderLayout());

        JPanel top = new JPanel(new BorderLayout());
        top.setPreferredSize(new Dimension(0, 60));
        top.setBackground(new Color(22, 54, 95));
        top.setOpaque(true);

        JLabel logo = new JLabel();
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon logoIcon = new ImageIcon("assets/vce_logo.png");
        Image logoScaled = logoIcon.getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(logoScaled));
        logo.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 8));

        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.setOpaque(false);

        JLabel title = new JLabel("Vasavi College Chatbot");
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel("Formal academic assistance");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        subtitle.setForeground(new Color(205, 215, 230));

        titlePanel.add(title);
        titlePanel.add(subtitle);

        top.add(logo, BorderLayout.WEST);
        top.add(titlePanel, BorderLayout.CENTER);

        chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        chatPanel.setOpaque(false);

        JPanel chatContainer = new JPanel(new BorderLayout());
        chatContainer.setOpaque(false);
        chatContainer.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        chatContainer.add(chatPanel, BorderLayout.NORTH);

        scrollPane = new JScrollPane(chatContainer);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        JPanel bottomWrapper = new JPanel(new BorderLayout());
        bottomWrapper.setOpaque(false);
        bottomWrapper.setBorder(BorderFactory.createEmptyBorder(6, 10, 10, 10));

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setOpaque(true);
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(new RoundedBorder(20, new Color(190, 198, 210)));

        inputField = new JTextField();
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        inputField.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
        inputField.setOpaque(false);

        sendButton = new JButton();
        sendButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        sendButton.setFocusPainted(false);
        sendButton.setOpaque(true);
        sendButton.setContentAreaFilled(true);
        sendButton.setBackground(new Color(22, 54, 95));
        sendButton.setBorder(new RoundedBorder(16, new Color(22, 54, 95)));
        sendButton.setPreferredSize(new Dimension(56, 34));
        sendButton.setToolTipText("Send message");

        ImageIcon sendIcon = new ImageIcon("assets/send_dark.png");
        Image sendScaled = sendIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        sendButton.setIcon(new ImageIcon(sendScaled));
        sendButton.setHorizontalAlignment(SwingConstants.CENTER);

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        bottomWrapper.add(inputPanel, BorderLayout.CENTER);

        mainPanel.add(top, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomWrapper, BorderLayout.SOUTH);

        add(mainPanel);

        ImageIcon botIcon = new ImageIcon("assets/chat_icon.png");
        Image botScaled = botIcon.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
        botIconSmall = new ImageIcon(botScaled);

        ImageIcon userIcon = new ImageIcon("assets/user_avatar.png");
        Image userScaled = userIcon.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
        userIconSmall = new ImageIcon(userScaled);

        addListeners();

        addBotMessage("Hello. I am the Vasavi College Chatbot. You can ask detailed questions about admissions, fee structure, departments, faculty, placements, facilities, exam rules, and other academic information related to Vasavi College of Engineering.");
    }

    public ChatBotApp(String username) {
        this();
        addBotMessage("Welcome, " + username + ". Please type your query clearly. For example, you can ask \"fee structure\", \"cse department details\", \"placement record\", or type \"help\" to see sample questions.");
    }

    private void addListeners() {
        sendButton.addActionListener(e -> handleSend());
        inputField.addActionListener(e -> handleSend());
    }

    private void handleSend() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) return;

        addUserMessage(text);
        inputField.setText("");

        addTypingIndicator();

        new Thread(() -> {
            try { Thread.sleep(900); } catch (Exception ignored) {}
            removeTypingIndicator();

            String response = BotLogic.getResponse(text);
            response = BotResponseFormatter.format(response);
            addBotMessage(response);
        }).start();
    }

    private void addUserMessage(String msg) {
        JPanel row = new JPanel(new BorderLayout());
        row.setOpaque(false);
        row.setBorder(BorderFactory.createEmptyBorder(3, 40, 3, 5));

        JPanel inner = new JPanel();
        inner.setLayout(new BoxLayout(inner, BoxLayout.X_AXIS));
        inner.setOpaque(false);

        ChatBubble bubble = new ChatBubble(msg, true);
        JLabel avatar = new JLabel(userIconSmall);

        inner.add(bubble);
        inner.add(Box.createHorizontalStrut(4));
        inner.add(avatar);

        row.add(inner, BorderLayout.EAST);

        chatPanel.add(row);
        refreshChat();
    }

    private void addBotMessage(String msg) {
        JPanel row = new JPanel(new BorderLayout());
        row.setOpaque(false);
        row.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 40));

        JPanel inner = new JPanel();
        inner.setLayout(new BoxLayout(inner, BoxLayout.X_AXIS));
        inner.setOpaque(false);

        JLabel avatar = new JLabel(botIconSmall);
        ChatBubble bubble = new ChatBubble(msg, false);

        inner.add(avatar);
        inner.add(Box.createHorizontalStrut(4));
        inner.add(bubble);

        row.add(inner, BorderLayout.WEST);

        chatPanel.add(row);
        refreshChat();
    }

    private void addTypingIndicator() {
        indicator = new TypingIndicator(botIconSmall);
        chatPanel.add(indicator);
        refreshChat();
    }

    private void removeTypingIndicator() {
        if (indicator != null) {
            chatPanel.remove(indicator);
            indicator.stopTyping();
            indicator = null;
            refreshChat();
        }
    }

    private void refreshChat() {
        chatPanel.revalidate();
        chatPanel.repaint();
        SwingUtilities.invokeLater(() -> {
            JScrollBar bar = scrollPane.getVerticalScrollBar();
            bar.setValue(bar.getMaximum());
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChatBotApp().setVisible(true));
    }

    private static class RoundedBorder implements Border {
        private final int radius;
        private final Color borderColor;

        public RoundedBorder(int radius, Color borderColor) {
            this.radius = radius;
            this.borderColor = borderColor;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(4, 8, 4, 8);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(borderColor);
            g2.drawRoundRect(x + 1, y + 1, width - 3, height - 3, radius, radius);
        }
    }
}
