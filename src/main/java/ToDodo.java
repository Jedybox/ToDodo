import javax.swing.*;
import java.awt.*;

public class ToDodo extends JFrame {

    ToDodo () {
        this.setTitle("ToDodo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,600);
        this.setVisible(true);

        JPanel header = new JPanel();
        JPanel sidebar = new JPanel();

        header.setBackground(Color.BLACK);
        sidebar.setBackground(Color.BLACK);
        header.setPreferredSize(new Dimension(100,50));
        sidebar.setPreferredSize(new Dimension(50,100));

        this.add(header, BorderLayout.NORTH);
        this.add(sidebar, BorderLayout.WEST);

    }

}
