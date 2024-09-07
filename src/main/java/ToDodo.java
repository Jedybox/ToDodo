import javax.swing.*;
import java.awt.*;

public class ToDodo extends JFrame {



    ToDodo () {

        this.setUndecorated(true);

        JPanel titleBar = new JPanel();
        titleBar.setBackground(Color.decode("#DEDCD8"));
        titleBar.setPreferredSize(new Dimension(100, 50));
        titleBar.setLayout(new BorderLayout());

        JLabel title = new JLabel("ToDodo", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        titleBar.add(title, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonPanel.setOpaque(false);

        JButton closeButton = new JButton("X");
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(Color.RED);
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setPreferredSize(new Dimension(40, 40));

        JButton minimizeButton = new JButton("-");
        minimizeButton.setForeground(Color.WHITE);
        minimizeButton.setBackground(Color.GRAY);
        minimizeButton.setFocusPainted(false);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setPreferredSize(new Dimension(40, 40));

        closeButton.addActionListener(e -> System.exit(0));
        minimizeButton.addActionListener(e -> setState(JFrame.ICONIFIED));

        buttonPanel.add(minimizeButton);
        buttonPanel.add(closeButton);

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new ToDodo();
    }

}
