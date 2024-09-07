import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToDodo extends JFrame {
    private Point initialClick;

    ToDodo () {

        this.setUndecorated(true);

        JPanel titleBar = new JPanel();
        titleBar.setBackground(Color.decode("#DEDCD8"));
        titleBar.setPreferredSize(new Dimension(100, 50));
        titleBar.setLayout(new BorderLayout());

        ImageIcon img = new ImageIcon("sources/tododoIcon.png");
        Image image = img.getImage();
        Image resizedImage = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon resizedImg = new ImageIcon(resizedImage);

        JLabel titleIcon = new JLabel();
        titleIcon.setHorizontalAlignment(SwingConstants.LEFT);
        titleIcon.setText("ToDodo");
        titleIcon.setIcon(resizedImg);
        titleIcon.setVisible(true);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonPanel.setOpaque(false);

        JButton closeButton = new JButton("X");
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(Color.RED);
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setPreferredSize(new Dimension(50, 50));

        JButton minimizeButton = new JButton("-");
        minimizeButton.setForeground(Color.WHITE);
        minimizeButton.setBackground(Color.GRAY);
        minimizeButton.setFocusPainted(false);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setPreferredSize(new Dimension(50, 50));

        closeButton.addActionListener(e -> System.exit(0));
        minimizeButton.addActionListener(e -> setState(JFrame.ICONIFIED));

        titleBar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        titleBar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Get the current location of the window
                int thisX = getLocation().x;
                int thisY = getLocation().y;

                // Determine how much the mouse moved since the initial click
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                // Move the window
                int x = thisX + xMoved;
                int y = thisY + yMoved;
                setLocation(x, y);
            }
        });

        closeButton.setVisible(true);
        minimizeButton.setVisible(true);
        buttonPanel.setVisible(true);

        buttonPanel.add(minimizeButton);
        buttonPanel.add(closeButton);
        titleBar.add(titleIcon, BorderLayout.WEST);
        titleBar.add(buttonPanel, BorderLayout.EAST);

        titleBar.setVisible(true);
        this.setLayout(new BorderLayout());
        this.add(titleBar, BorderLayout.NORTH);
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

    public static void main(String[] args) {
        new ToDodo();
    }

}
