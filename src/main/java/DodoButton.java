import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DodoButton extends JButton {

    DodoButton(String label) {
         super(label);
         setOpaque(false);
         setFocusPainted(false);
         setContentAreaFilled(false);
         setBorderPainted(false);
         setForeground(Color.decode("#21a6de"));

         setIcon(getButtonIcon(label));
    }

    private ImageIcon getButtonIcon(String iconName) {
        String path = "sources/" + iconName + ".png";
        ImageIcon img = new ImageIcon(path);
        Image image = img.getImage();
        Image resizedImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Ellipse2D circle = new Ellipse2D.Float(0, 0, getWidth(), getHeight());

        g2d.fill(circle);
        g2d.setColor(getForeground());
        FontMetrics fm = g2d.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() + fm.getAscent()) / 2 - 2;
        g2d.drawString(getText(), x, y);

        if (getIcon() != null) {
            Icon icon = getIcon();
            int iconWidth = icon.getIconWidth();
            int iconHeight = icon.getIconHeight();
            int a = (getWidth() - iconWidth) / 2;
            int b = (getHeight() - iconHeight) / 2;
            icon.paintIcon(this, g2d, a, b);
        }

        g2d.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Draw the border of the round button (optional)
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        // Ensure the button responds only within its round shape
        Ellipse2D circle = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        return circle.contains(x, y);
    }

    @Override
    public Dimension getPreferredSize() {
        // Ensure the button is a perfect circle
        Dimension size = super.getPreferredSize();
        int diameter = Math.max(size.width, size.height);
        size.setSize(diameter, diameter);
        return size;
    }
}
