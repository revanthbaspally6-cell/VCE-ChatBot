package vasavichatbot;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
        }

        SwingUtilities.invokeLater(() -> {
            try {
                LoginPage login = new LoginPage();
                login.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to start VCE ChatBot",
                        "Startup Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
