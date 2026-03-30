package vasavichatbot.ui;

import javax.swing.*;
import java.awt.*;

public class TypingIndicator extends JPanel {

    private JLabel gifLabel;

    public TypingIndicator(ImageIcon botIconSmall) {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 5));

        JLabel avatar = new JLabel(botIconSmall);
        add(avatar);
        add(Box.createHorizontalStrut(6));

        ImageIcon gif = new ImageIcon("assets/typing.gif");
        gifLabel = new JLabel(gif);
        add(gifLabel);

        add(Box.createHorizontalGlue());
    }

    public void stopTyping() {
        // nothing special needed, placeholder for compatibility
    }
}
