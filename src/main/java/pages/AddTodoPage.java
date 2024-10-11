package pages;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddTodoPage extends JPanel implements ActionListener {
    JTextField titleField;
    JTextArea descriptionField;

    public AddTodoPage() {
        titleField = new JTextField();
        titleField.setText("Title");
        titleField.setPreferredSize(new Dimension(100, 30));

        descriptionField = new JTextArea();

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 30));
        titlePanel.add(titleField);
        titlePanel.setPreferredSize(new Dimension(100, 100));

        this.setLayout(new BorderLayout());
        this.add(titlePanel, BorderLayout.NORTH);
        this.setPreferredSize(new Dimension(100, 100));
        this.setVisible(true);
    }   

    @Override   
    public void actionPerformed(ActionEvent e) {
        // Add new task
    }

}
