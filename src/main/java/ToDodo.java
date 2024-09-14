import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToDodo extends JFrame implements ActionListener {
    private Point initialClick;
    private final DodoButton homeButton;
    private final DodoButton addNoteButton;
    private final DodoButton settingsButton;

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

        homeButton = new DodoButton("Home");
        addNoteButton = new DodoButton("Add");
        settingsButton = new DodoButton("Settings");

        homeButton.setIcon(generateIcon("home", 25, 25));
        addNoteButton.setIcon(generateIcon("add", 25, 25));
        settingsButton.setIcon(generateIcon("settings", 25, 25));

        homeButton.addActionListener(this);
        addNoteButton.addActionListener(this);
        settingsButton.addActionListener(this);

        homeButton.setSize(40, 40);
        addNoteButton.setSize(40, 40);
        settingsButton.setSize(40, 40);

        JPanel upperSidePanel = new JPanel();
        upperSidePanel.setLayout(new GridLayout(2, 1, 0, 5));
        upperSidePanel.add(homeButton);
        upperSidePanel.add(addNoteButton);
        upperSidePanel.setPreferredSize(new Dimension(70, 105));

        JPanel lowerSidePanel = new JPanel();
        lowerSidePanel.setPreferredSize(new Dimension(70, 50));
        lowerSidePanel.setLayout(new GridLayout(1, 1, 0, 5));
        lowerSidePanel.add(settingsButton);

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout(5, 5));
        sidePanel.add(upperSidePanel, BorderLayout.NORTH);
        sidePanel.add(lowerSidePanel, BorderLayout.SOUTH);
        sidePanel.setOpaque(false);
        sidePanel.setPreferredSize(new Dimension(70, 100));
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
        if (e.getSource() == homeButton) System.out.println("Home");
        else if (e.getSource() == addNoteButton) System.out.println("Add");
        else if (e.getSource() == settingsButton) System.out.println("Setting");
    }

    private static JLabel getIcon() {
        ImageIcon resizedImg = generateIcon("icon", 30, 30);

        JLabel titleIcon = new JLabel();
        titleIcon.setHorizontalAlignment(SwingConstants.LEFT);
        titleIcon.setText("ToDodo");
        titleIcon.setVerticalTextPosition(SwingConstants.CENTER);
        titleIcon.setIcon(resizedImg);
        titleIcon.setVisible(true);

        return titleIcon;
    }

    private static ImageIcon generateIcon(String iconName, int width, int height) {
        String path = "src/main/resources/" + iconName + ".png";
        ImageIcon img = new ImageIcon(path);
        Image image = img.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}