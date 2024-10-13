package components;

import java.awt.Color;

import javax.swing.JButton;

public class PrimaryButton extends JButton {
    public PrimaryButton(String text) {
        super(text);
        this.setBackground(Color.decode("#007bff"));
        this.setForeground(Color.white);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setOpaque(true);
    }
}
