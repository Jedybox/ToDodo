import javax.swing.JPanel; 
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Home extends JPanel implements ActionListener {
    private JButton allBtn, pendingBtn, completedBtn, sortDate;

    Home() {

        this.setPreferredSize(new Dimension(100, 150));
        this.setLayout(new BorderLayout());

        JPanel headPanel = new JPanel();
        headPanel.setLayout(new GridLayout(2, 1));

        JLabel title = new JLabel("TODO's");

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnPanel.setPreferredSize(new Dimension(100, 100));

        this.allBtn = new JButton("All");
        this.pendingBtn = new JButton("Pending");
        this.completedBtn = new JButton("Completed");
        this.sortDate = new JButton("Sort by newest");

        allBtn.addActionListener(this);
        pendingBtn.addActionListener(this);
        completedBtn.addActionListener(this);
        sortDate.addActionListener(this);

        btnPanel.add(allBtn);
        btnPanel.add(pendingBtn);
        btnPanel.add(completedBtn);
        btnPanel.add(sortDate);

        headPanel.add(title);
        headPanel.add(btnPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == allBtn) {
            // Display all tasks
        } else if (e.getSource() == pendingBtn) {
            // Display pending tasks
        } else if (e.getSource() == completedBtn) {
            // Display completed tasks
        } else if (e.getSource() == sortDate) {
            // Sort tasks by date
        }
    }

}
