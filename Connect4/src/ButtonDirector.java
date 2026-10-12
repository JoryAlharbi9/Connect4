import java.awt.*;
import javax.swing.*;

public class ButtonDirector {

    private ButtonBuilder builder;

    public ButtonDirector(ButtonBuilder builder) {
        this.builder = builder;
    }

    // Build game buttons (1-7 and EXIT)
    public void makeGameButton(
            Font font, Color background,
            Color foreground, Dimension size) {

        builder.buildFont(font);
        builder.buildBackground(background);
        builder.buildForeground(foreground);
        builder.buildBorder(false);
        builder.buildFocus(false);
        builder.buildSize(size);
        builder.buildHoverEffect(background, Colours.buttononhover);
    }

    // Build menu buttons (PLAY and STATS)
    public void makeMenuButton(
            Font font, Color background,
            Color foreground, Icon icon) {

        builder.buildFont(font);
        builder.buildBackground(background);
        builder.buildForeground(foreground);
        builder.buildBorder(false);
        builder.buildFocus(false);
        builder.buildIcon(icon);
        builder.buildTextPosition(
            SwingConstants.TOP,
            SwingConstants.CENTER
        );
        builder.buildHoverEffect(background, Colours.buttononhover);
    }
}