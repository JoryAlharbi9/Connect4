import java.awt.*;
import javax.swing.*;

public class GameButtonBuilder implements ButtonBuilder {

    private JButton button;

    public GameButtonBuilder(String text) {
        button = new JButton(text);
    }

    @Override
    public void buildFont(Font font) {
        button.setFont(font);
    }

    @Override
    public void buildBackground(Color color) {
        button.setBackground(color);
    }

    @Override
    public void buildForeground(Color color) {
        button.setForeground(color);
    }

    @Override
    public void buildBorder(boolean painted) {
        button.setBorderPainted(painted);
    }

    @Override
    public void buildFocus(boolean painted) {
        button.setFocusPainted(painted);
    }

    @Override
    public void buildSize(Dimension size) {
        button.setPreferredSize(size);
    }

    @Override
    public void buildIcon(Icon icon) {
        button.setIcon(icon);
    }

    @Override
    public void buildTextPosition(int vertical, int horizontal) {
        button.setVerticalTextPosition(vertical);
        button.setHorizontalTextPosition(horizontal);
    }

    @Override
    public void buildHoverEffect(Color normalColour, Color hoverColour) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            button.setBackground(hoverColour);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            button.setBackground(normalColour);
        }
        });
    }

    @Override
    public JButton getButton() {
        return button;
    }
}