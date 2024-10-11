import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import components.DodoButton;
import pages.AddTodoPage;
import pages.HomePage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.FlowLayout;

public class ToDodo extends JFrame implements ActionListener {
    private Point initialClick;
    private final DodoButton homeButton;
    private final DodoButton addNoteButton;
    private final DodoButton settingsButton;
    private final JPanel contentPanel;
    private final CardLayout contentPanelCard;
    private final HomePage homePanel = new HomePage();
    private final AddTodoPage addPanel = new AddTodoPage();

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

        JButton minimizeButton = new JButton("−");
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

        homeButton.setIcon(generateIcon("home", 20, 20));
        addNoteButton.setIcon(generateIcon("add", 20, 20));
        settingsButton.setIcon(generateIcon("settings", 20, 20));

        homeButton.addActionListener(this);
        addNoteButton.addActionListener(this);
        settingsButton.addActionListener(this);

        homeButton.setSize(30, 30);
        addNoteButton.setSize(30, 30);
        settingsButton.setSize(30, 30);

        JPanel upperSidePanel = new JPanel();
        upperSidePanel.setLayout(new GridLayout(2, 1, 0, 5));
        upperSidePanel.add(homeButton);
        upperSidePanel.add(addNoteButton);
        upperSidePanel.setPreferredSize(new Dimension(60, 90));

        JPanel lowerSidePanel = new JPanel();
        lowerSidePanel.setPreferredSize(new Dimension(60, 40));
        lowerSidePanel.setLayout(new GridLayout(1, 1, 0, 0));
        lowerSidePanel.add(settingsButton);

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout(5, 5));
        sidePanel.add(upperSidePanel, BorderLayout.NORTH);
        sidePanel.add(lowerSidePanel, BorderLayout.SOUTH);
        sidePanel.setOpaque(false);
        sidePanel.setPreferredSize(new Dimension(60, 100));
        sidePanel.setBackground(Color.decode("#DEDCD8"));
        sidePanel.setBorder(new EmptyBorder(10, 10, 10 , 10));

        JPanel underPanel = new JPanel();
        underPanel.setPreferredSize(new Dimension(100, 1));

        contentPanelCard = new CardLayout();
        contentPanel = new JPanel(contentPanelCard);
        contentPanel.setPreferredSize(new Dimension(100, 100));
        contentPanel.setBackground(Color.decode("#DEDCD8"));

        JPanel settingsPanel = new JPanel();
        JLabel settingsTitle = new JLabel("Settings");
        settingsTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        settingsPanel.add(settingsTitle);

        contentPanel.add(homePanel, "Home");
        contentPanel.add(addPanel, "Add");
        contentPanel.add(settingsPanel, "Settings");

        contentPanel.setVisible(true);
        sidePanel.setVisible(true);
        closeButton.setVisible(true);
        minimizeButton.setVisible(true);
        buttonPanel.setVisible(true);
        titleBar.setVisible(true);

        buttonPanel.add(minimizeButton);
        buttonPanel.add(closeButton);
        titleBar.add(titleIcon, BorderLayout.WEST);
        titleBar.add(buttonPanel, BorderLayout.EAST);

        setShape(new RoundRectangle2D.Double(0, 0, 700, 600, 20, 20));
        this.setTitle("ToDodo");
        titleBar.setVisible(true);
        this.setLayout(new BorderLayout());
        this.add(titleBar, BorderLayout.NORTH);
        this.add(sidePanel, BorderLayout.WEST);
        this.add(underPanel, BorderLayout.SOUTH);
        this.add(contentPanel, BorderLayout.CENTER);
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == homeButton)
            contentPanelCard.show(contentPanel, "Home");
        else if (e.getSource() == addNoteButton)
            contentPanelCard.show(contentPanel, "Add");
        else if (e.getSource() == settingsButton)
            contentPanelCard.show(contentPanel, "Settings");
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