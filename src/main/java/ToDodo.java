import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToDodo extends JFrame implements ActionListener {
    private Point initialClick;
    private JButton homeButton;
    private JButton addNoteButton;
    private JButton settingsButton;

    ToDodo () {

        this.setUndecorated(true);

        JPanel titleBar = new JPanel();
        titleBar.setBackground(Color.decode("#DEDCD8"));
        titleBar.setPreferredSize(new Dimension(100, 40));
        titleBar.setLayout(new BorderLayout());

        JLabel titleIcon = getIcon();

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonPanel.setOpaque(false);

        JButton closeButton = new JButton("x");
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(Color.RED);
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setPreferredSize(new Dimension(50, 40));

        JButton minimizeButton = new JButton("-");
        minimizeButton.setForeground(Color.WHITE);
        minimizeButton.setBackground(Color.GRAY);
        minimizeButton.setFocusPainted(false);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setPreferredSize(new Dimension(50, 40));

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

        homeButton = new JButton();
        addNoteButton = new JButton();
        settingsButton = new JButton();

        JPanel upperSidePanel = new JPanel();
        upperSidePanel.setLayout(new BoxLayout(upperSidePanel, BoxLayout.Y_AXIS));
        upperSidePanel.add(homeButton);
        upperSidePanel.add(addNoteButton);
        upperSidePanel.setPreferredSize(new Dimension(100, 400));

        JPanel lowerSidePanel = new JPanel();
        lowerSidePanel.setLayout(new BoxLayout(lowerSidePanel, BoxLayout.Y_AXIS));
        lowerSidePanel.add(settingsButton);

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout(5, 5));
        sidePanel.add(upperSidePanel, BorderLayout.NORTH);
        sidePanel.add(lowerSidePanel, BorderLayout.SOUTH);
        sidePanel.setOpaque(false);
        sidePanel.setPreferredSize(new Dimension(100, 100));
        sidePanel.setBackground(Color.decode("#DEDCD8"));
        sidePanel.setBorder(new EmptyBorder(10, 10, 10 , 10));

        JPanel underPanel = new JPanel();
        underPanel.setPreferredSize(new Dimension(100, 1));

        sidePanel.setVisible(true);
        closeButton.setVisible(true);
        minimizeButton.setVisible(true);
        buttonPanel.setVisible(true);

        buttonPanel.add(minimizeButton);
        buttonPanel.add(closeButton);
        titleBar.add(titleIcon, BorderLayout.WEST);
        titleBar.add(buttonPanel, BorderLayout.EAST);

        this.setTitle("ToDodo");
        titleBar.setVisible(true);
        this.setLayout(new BorderLayout());
        this.add(titleBar, BorderLayout.NORTH);
        this.add(sidePanel, BorderLayout.WEST);
        this.add(underPanel, BorderLayout.SOUTH);
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
    }

    private static JLabel getIcon() {
        ImageIcon img = new ImageIcon("sources/tododoIcon.png");
        Image image = img.getImage();
        Image resizedImage = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedImg = new ImageIcon(resizedImage);

        JLabel titleIcon = new JLabel();
        titleIcon.setHorizontalAlignment(SwingConstants.LEFT);
        titleIcon.setText("ToDodo");
        titleIcon.setVerticalTextPosition(SwingConstants.CENTER);
        titleIcon.setIcon(resizedImg);
        titleIcon.setVisible(true);

        return titleIcon;
    }
}