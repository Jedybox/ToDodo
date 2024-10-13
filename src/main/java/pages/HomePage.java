package pages;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pages.subpages.AllTodo;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class HomePage extends JPanel implements ActionListener {
    private final JButton allBtn, pendingBtn, completedBtn, sortDate;
    private final CardLayout contentPanelCard = new CardLayout();
    private final AllTodo allTodoPanel = new AllTodo();
    private final JPanel pendingTodoPanel = new JPanel();
    private final JPanel completedTodoPanel = new JPanel();

    public HomePage() {

        this.setPreferredSize(new Dimension(100, 100));
        this.setLayout(new BorderLayout());

        JPanel headPanel = new JPanel();
        headPanel.setLayout(new GridLayout(2, 1));

        JLabel title = new JLabel("TODO's");
        title.setBorder(new EmptyBorder(10, 75, 10, 10));
        title.setFont(new Font("Serif", Font.PLAIN, 20));

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnPanel.setPreferredSize(new Dimension(100, 20));

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

        this.contentPanelCard.addLayoutComponent(allTodoPanel, "all");
        this.contentPanelCard.addLayoutComponent(pendingTodoPanel, "pending");
        this.contentPanelCard.addLayoutComponent(completedTodoPanel, "completed");

        JPanel contentPanel = new JPanel(contentPanelCard);
        contentPanel.setPreferredSize(new Dimension(100, 100));
        
        this.add(contentPanel, BorderLayout.CENTER);
        this.add(headPanel, BorderLayout.NORTH);
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
