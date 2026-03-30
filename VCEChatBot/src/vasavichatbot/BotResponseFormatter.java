package vasavichatbot;

public class BotResponseFormatter {

    public static String format(String text) {
        text = text.trim();
        text = text.replaceAll("\\s+", " ");
        if (!text.endsWith(".")) {
            if (!text.endsWith("!") && !text.endsWith("?")) {
                text = text + ".";
            }
        }
        return text;
    }
}
