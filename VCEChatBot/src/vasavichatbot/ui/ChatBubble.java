package vasavichatbot.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ChatBubble extends JPanel {

    private String text;
    private boolean isUser;
    private static final int PADDING = 10;
    private static final int ARC = 18;
    private static final int MAX_BUBBLE_WIDTH = 420;

    public ChatBubble(String text, boolean isUser) {
        this.text = text;
        this.isUser = isUser;
        setOpaque(false);
        setLayout(new BorderLayout());
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(getFont());
        FontMetrics fm = g2.getFontMetrics();

        List<String> lines = wrapText(text, fm, MAX_BUBBLE_WIDTH);
        int contentWidth = getMaxLineWidth(lines, fm);
        int contentHeight = lines.size() * fm.getHeight();

        int bubbleWidth = contentWidth + PADDING * 2;
        int bubbleHeight = contentHeight + PADDING * 2;

        int x = 0;

        if (isUser) {
            g2.setColor(new Color(25, 118, 210));
        } else {
            g2.setColor(new Color(245, 247, 250));
        }

        g2.fillRoundRect(x, 0, bubbleWidth, bubbleHeight, ARC, ARC);

        if (isUser) {
            g2.setColor(Color.WHITE);
        } else {
            g2.setColor(new Color(20, 30, 40));
        }

        int textX = x + PADDING;
        int textY = PADDING + fm.getAscent();

        for (String line : lines) {
            g2.drawString(line, textX, textY);
            textY += fm.getHeight();
        }

        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        Graphics g = getGraphics();
        if (g == null) {
            g = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
        }
        g.setFont(getFont());
        FontMetrics fm = g.getFontMetrics();

        List<String> lines = wrapText(text, fm, MAX_BUBBLE_WIDTH);
        int contentWidth = getMaxLineWidth(lines, fm);
        int contentHeight = lines.size() * fm.getHeight();

        int bubbleWidth = contentWidth + PADDING * 2;
        int bubbleHeight = contentHeight + PADDING * 2;

        return new Dimension(bubbleWidth, bubbleHeight);
    }

    private List<String> wrapText(String text, FontMetrics fm, int maxWidth) {
        List<String> result = new ArrayList<>();
        String[] paragraphs = text.split("\n");

        for (String para : paragraphs) {
            String[] words = para.split("\\s+");
            StringBuilder line = new StringBuilder();

            for (String word : words) {
                if (line.length() == 0) {
                    line.append(word);
                } else {
                    String testLine = line + " " + word;
                    int testWidth = fm.stringWidth(testLine);
                    if (testWidth <= maxWidth) {
                        line.append(" ").append(word);
                    } else {
                        result.add(line.toString());
                        line = new StringBuilder(word);
                    }
                }
            }
            if (line.length() > 0) {
                result.add(line.toString());
            }
        }

        if (result.isEmpty()) {
            result.add("");
        }

        return result;
    }

    private int getMaxLineWidth(List<String> lines, FontMetrics fm) {
        int max = 0;
        for (String line : lines) {
            int w = fm.stringWidth(line);
            if (w > max) max = w;
        }
        return max;
    }
}
