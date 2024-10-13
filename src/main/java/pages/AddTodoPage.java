package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import components.PrimaryButton;
import components.ToDo;

import utils.DataManager;

public class AddTodoPage extends JPanel implements ActionListener {
    
    private final Font customFont = new Font("Serif", Font.PLAIN, 16);

    private final static String[] CATEGORIES = {"Select Categories", "Personal", "Work", "School", "Other"};
    private final JComboBox<String> categoryList = new JComboBox<>(CATEGORIES);

    private final JTextField titleField;
    private final JTextArea descriptionField;
    
    private final PrimaryButton addBtn = new PrimaryButton("Add to list");
    private final PrimaryButton cancelBtn = new PrimaryButton("Cancel");

    public AddTodoPage() {
        titleField = new JTextField();
        titleField.setText("Title");
        titleField.setPreferredSize(new Dimension(100, 30));

        descriptionField = new JTextArea();
        descriptionField.setPreferredSize(new Dimension(100, 100));
        descriptionField.setBorder(new EmptyBorder(30, 30,30, 30));
        descriptionField.setLineWrap(true);
        descriptionField.setWrapStyleWord(true);
        descriptionField.setFont(customFont);

        JPanel cathegoryPanel = new JPanel();
        cathegoryPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        cathegoryPanel.add(categoryList);
        cathegoryPanel.setPreferredSize(new Dimension(100, 50));

        JPanel desJPanel = new JPanel();
        desJPanel.setLayout(new BorderLayout());
        desJPanel.add(descriptionField, BorderLayout.CENTER);
        desJPanel.add(cathegoryPanel, BorderLayout.SOUTH);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 30));
        titlePanel.add(titleField);
        titlePanel.setPreferredSize(new Dimension(100, 70));

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 30));
        footerPanel.setSize(100, 70);
        footerPanel.add(addBtn);
        footerPanel.add(cancelBtn);
        addBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        cancelBtn.setBackground(Color.decode("#ffffff"));
        cancelBtn.setForeground(Color.decode("#007bff"));

        this.setLayout(new BorderLayout());
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(desJPanel, BorderLayout.CENTER);
        this.add(footerPanel, BorderLayout.SOUTH);
        this.setPreferredSize(new Dimension(100, 100));
        this.setVisible(true);
    }   

    @Override   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {

            if (categoryList.getSelectedItem().equals("Select Categories")) {
                JOptionPane.showMessageDialog(this, "Please select a category", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ToDo todo = new ToDo(
                titleField.getText(),
                descriptionField.getText(),
                categoryList.getSelectedItem().toString(),
                "Pending"
            );

            DataManager.update(todo, DataManager.ADD_TODO);

            JOptionPane.showMessageDialog(this, "Todo added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

            titleField.setText("Title");
            descriptionField.setText("");
            categoryList.setSelectedIndex(0);

        } else if (e.getSource() == cancelBtn) {
            System.out.println("Cancel button clicked");
        }
    }

}
