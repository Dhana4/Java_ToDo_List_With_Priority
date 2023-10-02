package taskPriority;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JCheckBox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class ToDoListGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton addButton;
    private JButton deleteButton;
    private JButton sortButton;
    private JButton viewButton;
    private JButton toggleTaskCompletion;
    private JButton searchButton;
    private JTextArea taskTextArea;
    private JButton clearButton;
    
    public ToDoListGUI() {
        setTitle("To-Do List Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        

        
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Vertical layout

        // Create an empty border with space at the top
        int topMargin = 20;
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, 0, 0));
        
        
        JLabel headingLabel = new JLabel("Welcome to Task Manager");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 50));
        headingLabel.setForeground(Color.BLUE);
        buttonPanel.add(headingLabel,BorderLayout.CENTER);
        JPanel spacer7 = new JPanel();
        spacer7.setPreferredSize(new Dimension(0,25));
        buttonPanel.add(spacer7);
        
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        
        
        addButton = new JButton("Add Task");
        buttonPanel.add(addButton);
        JPanel spacer1 = new JPanel();
        spacer1.setPreferredSize(new Dimension(200, 25));
        buttonPanel.add(spacer1);
        viewButton = new JButton("View Tasks");
        buttonPanel.add(viewButton);
        JPanel spacer2 = new JPanel();
        spacer2.setPreferredSize(new Dimension(0, 25));
        buttonPanel.add(spacer2);
        sortButton = new JButton("Sort Tasks");
        buttonPanel.add(sortButton);
        JPanel spacer3 = new JPanel();
        spacer3.setPreferredSize(new Dimension(0, 25));
        buttonPanel.add(spacer3);
        toggleTaskCompletion = new JButton("Toggle Task completion");
        buttonPanel.add(toggleTaskCompletion);
        JPanel spacer4 = new JPanel();
        spacer4.setPreferredSize(new Dimension(0, 25));
        buttonPanel.add(spacer4);
        searchButton = new JButton("Search Tasks");
        buttonPanel.add(searchButton);
        JPanel spacer5 = new JPanel();
        spacer5.setPreferredSize(new Dimension(0, 25));
        buttonPanel.add(spacer5);
        deleteButton = new JButton("Delete Task");
        buttonPanel.add(deleteButton);
        JPanel spacer6 = new JPanel();
        spacer6.setPreferredSize(new Dimension(0, 25));
        buttonPanel.add(spacer6);
        taskTextArea = new JTextArea(30, 50); 
        JScrollPane scrollPane = new JScrollPane(taskTextArea);
        rightPanel.add(scrollPane, BorderLayout.EAST);
        clearButton = new JButton("Clear");
        buttonPanel.add(clearButton);
        
        add(buttonPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
        pack();
        setLocationRelativeTo(null);

        
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get task details from the user
                String taskDescription = JOptionPane.showInputDialog("Enter task description:");
                String taskDueDate = JOptionPane.showInputDialog("Enter task due date:");
                String taskPriority = JOptionPane.showInputDialog("Enter task priority (High/Medium/Low):");

                // Create a new Task object with the user-entered details
                Task newTask = new Task(taskDescription, taskDueDate, taskPriority);

                // Add the new task to your ToDoList instance (assuming you have an instance named 'toDoList')
                TodoListApp.addTask(newTask);
                JOptionPane.showMessageDialog(null, "Task added successfully!");

                // Optionally, update the GUI to reflect the added task
                // For example, update a task list display
            }
        });
        
        viewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                ArrayList<Task> tasks = TodoListApp.getTasks();
                updateTaskTextArea(tasks);
            }
        });
        
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                taskTextArea.setText(""); // Clear the text area
            }
        });
        
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call the method to sort tasks here (e.g., toDoList.sortTasks())
                TodoListApp.sortTasks1();
                
                // Optionally, update the JTextArea with the sorted tasks
                ArrayList<Task> sortedTasks = TodoListApp.getTasks();
                updateTaskTextArea(sortedTasks);
            }
        });
        
        toggleTaskCompletion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String userInput = JOptionPane.showInputDialog("Enter the index of the task:");
                    int selectedIndex = Integer.parseInt(userInput);
                    
                    // Check if the index is valid and toggle the completion status
                    if (selectedIndex >= 0 && selectedIndex < TodoListApp.getTasks().size()) {
                        TodoListApp.toggleTaskCompletion(selectedIndex);
                        updateTaskTextArea(TodoListApp.getTasks());
                    } else {
                        JOptionPane.showMessageDialog(ToDoListGUI.this, "Invalid index. Please enter a valid index.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ToDoListGUI.this, "Invalid index. Please enter a valid integer index.");
                }
            }
        });
        
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String searchTerm = JOptionPane.showInputDialog("Enter the searchterm  of the task:");
                ArrayList<Task> matchingTasks = TodoListApp.searchTasks(searchTerm);
                
                // Highlight matching tasks in the JTextArea
                updateTaskTextArea(matchingTasks);
            }
        });
        
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String userInput = JOptionPane.showInputDialog("Enter the index of the task to delete:");
                    int selectedIndex = Integer.parseInt(userInput);
                    
                    // Check if the index is valid
                    if (selectedIndex >= 0 && selectedIndex < TodoListApp.getTasks().size()) {
                        // Call the method to delete the task
                        TodoListApp.deleteTask(selectedIndex);
                        // Update the JTextArea to reflect the changes
                        updateTaskTextArea(TodoListApp.getTasks());
                    } else {
                        JOptionPane.showMessageDialog(ToDoListGUI.this, "Invalid index. Please enter a valid index.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ToDoListGUI.this, "Invalid index. Please enter a valid integer index.");
                }
            }
        });
        
    }
    
    private void updateTaskTextArea(ArrayList<Task> tasks) {
    	taskTextArea.setText(""); // Clear the existing content
        for (Task task : tasks) {
            JCheckBox checkBox = new JCheckBox(task.getDescription());
            checkBox.setSelected(task.isCompleted());
            checkBox.addItemListener(new ItemListener() {
                public  void itemStateChanged(ItemEvent e) {
                    // Update the task's completion status when the checkbox is clicked
                     task.setCompleted(checkBox.isSelected());
                }
            });
            taskTextArea.add(checkBox);
            taskTextArea.append("Description: " + task.getDescription() + "\n");
            taskTextArea.append("Due Date: " + task.getDueDate() + "\n");
            taskTextArea.append("Priority: " + task.getPriority() + "\n");
            taskTextArea.append("Completed: " + (task.isCompleted() ? "Yes" : "No") + "\n");
            taskTextArea.append("\n");

        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ToDoListGUI gui = new ToDoListGUI();
            gui.setVisible(true);
        });
        
    }
}
