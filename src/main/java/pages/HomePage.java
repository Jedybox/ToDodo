package pages;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import components.ToDo;
import utils.DataManager;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class HomePage extends JPanel implements ActionListener {

    private final String[] groupOptions = {"All", "Completed", "Uncompleted", "Personal", "Work", "School", "Other"};
    private final JComboBox<String> groupedTodos = new JComboBox<>(groupOptions);

    private final JPanel contentPanel = new JPanel();
    private ArrayList<ToDo> todos = new ArrayList<>();

    private final JScrollPane scrollPane = new JScrollPane(contentPanel);

    public HomePage() {
        this.updateList();
        this.setPreferredSize(new Dimension(100, 100));
        this.setLayout(new BorderLayout());

        JPanel headPanel = new JPanel();
        headPanel.setLayout(new GridLayout(2, 1));

        JLabel title = new JLabel("TODO's");
        title.setBorder(new EmptyBorder(10, 75, 10, 10));
        title.setFont(new Font("Serif", Font.PLAIN, 20));

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 10));
        btnPanel.setPreferredSize(new Dimension(30, 20));
        btnPanel.setBorder(new EmptyBorder(0, 10, 0, 30));
        btnPanel.add(groupedTodos);

        headPanel.add(title);
        headPanel.add(btnPanel);
        
        scrollPane.setPreferredSize(new Dimension(100, 100));
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(headPanel, BorderLayout.NORTH);
    }

    private void updateContentPanel() {
        this.contentPanel.removeAll();
        this.todos.forEach(todo -> {
            // this.contentPanel.add(todo);
        });
        this.contentPanel.revalidate();
        this.contentPanel.repaint();
    }

    public void updateList() {
        this.todos.clear();
        this.todos.addAll(DataManager.load());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         
    }

}
