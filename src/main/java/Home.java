import javax.swing.JPanel; 
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JPanel implements ActionListener {
    private JButton allBtn, pendingBtn, completedBtn, sortDate;
    private 

    Home(Object instance, JButton allBtn, JButton pendingBtn, JButton completedBtn, JButton sortDate) {
        this.allBtn = allBtn;
        this.pendingBtn = pendingBtn;
        this.completedBtn = completedBtn;
        this.sortDate = sortDate;

        allBtn.addActionListener(this);
        pendingBtn.addActionListener(this);
        completedBtn.addActionListener(this);
        sortDate.addActionListener(this);

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
