package utils;

import components.ToDo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DataManager {

    public static final int DELETE_TODO = 0;
    public static final int ADD_TODO = 1;

    public static ArrayList<ToDo> load() {
        ArrayList<ToDo> todos = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("todos.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                todos.add(new ToDo(data[0], data[1], data[2], data[3]));
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JPanel(), "Error loading data", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return todos;
    }

    public static void update(ToDo todo, int action) {
        if (action == DELETE_TODO) {
            remove(todo);
        } else if (action == ADD_TODO) {
            add(todo);
        }
    }

    private static void remove(ToDo todo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data/data.csv"));
            String line;
            StringBuilder inputBuffer = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (!data[0].equals(todo.getTitle())) {
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }
            }
            reader.close();
            FileWriter writer = new FileWriter("src/main/resources/data/data.csv");
            writer.write(inputBuffer.toString());
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JPanel(), "Error saving data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void add(ToDo todo) {
        try (FileWriter writer = new FileWriter("src/main/resources/data/data.csv", true)) {
            writer.append(
                todo.getTitle() + "," +
                todo.getDescription() + "," +
                todo.getCategory() + "," +
                todo.getStatus() + "," +
                "\n"
            );
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JPanel(), "Error saving data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
