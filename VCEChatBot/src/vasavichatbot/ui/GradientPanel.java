package vasavichatbot.ui;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {

    private Color color1;
    private Color color2;

    public GradientPanel(Color c1, Color c2) {
        this.color1 = c1;
        this.color2 = c2;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
        super.paintComponent(g);
    }
}
