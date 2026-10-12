import java.awt.*;
import javax.swing.*;

public interface ButtonBuilder {

    void buildFont(Font font);

    void buildBackground(Color color);

    void buildForeground(Color color);

    void buildBorder(boolean painted);

    void buildFocus(boolean painted);

    void buildSize(Dimension size);

    void buildIcon(Icon icon);

    void buildTextPosition(int vertical, int horizontal);

    void buildHoverEffect(Color normalColour, Color hoverColour);

    JButton getButton();
}