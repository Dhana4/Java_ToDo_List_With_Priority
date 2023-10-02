package taskPriority;
import java.util.*;
public class TodoListApp {
	
	static ArrayList<Task> tasks = new ArrayList<>();
	  public static void addTask(Task t)
	  {
		  tasks.add(t);
	  }
	  public static ArrayList<Task> getTasks()
	  {
		  return tasks;
	  }
	  public static void sortTasks1()
	  {
		  sortTasks(tasks);
	  }
	  public  static ArrayList<Task> searchTasks(String keyword) {
	        ArrayList<Task> matchingTasks = new ArrayList<>();

	        for (Task task : tasks) {
	            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
	                matchingTasks.add(task);
	            }
	        }

	        return matchingTasks;
	    }
	  
	  
	 public static void sortTasks(ArrayList<Task> tasks) {
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task task1, Task task2) {
                // Compare by priority first
                int priorityComparison = task1.getPriority().compareTo(task2.getPriority());

                // If priorities are the same, compare by due date
                if (priorityComparison == 0) {
                    return task1.getDueDate().compareTo(task2.getDueDate());
                }

                return priorityComparison;
            }
        });
        System.out.println("Tasks sorted by priority and due date.");
    }
	
	public static void toggleTaskCompletion(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            task.setCompleted(!task.isCompleted()); // Toggle completion status
            System.out.println("Task marked as " + (task.isCompleted() ? "completed" : "incomplete"));
        } else {
            System.out.println("Invalid task index. Please try again.");
        }
    }
	
	public static void deleteTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task removedTask = tasks.remove(taskIndex);
            System.out.println("Task removed: " + removedTask.getDescription());
        } else {
            System.out.println("Invalid task index. Please try again.");
        }
    }
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        while (true) {
            // Display menu options
            System.out.println("To-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Add a new task
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter due date: ");
                    String dueDate = scanner.nextLine();
                    System.out.print("Enter priority: ");
                    String priority = scanner.nextLine();

                    Task newTask = new Task(description, dueDate, priority);
                    tasks.add(newTask);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    // View tasks
                    System.out.println("Task List:");
                    for (Task task : tasks) {
                        System.out.println(task);
                    }
                    break;
                case 3:
                    // Sort tasks
                    sortTasks(tasks);
                    break;    
                case 4:
                    // Mark a task as completed or incomplete
                    System.out.print("Enter the index of the task to mark (starting from 0): ");
                    int taskIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    toggleTaskCompletion(taskIndex);
                    break; 
                    
                case 5:
                    // Search for tasks
                    System.out.print("Enter keywords to search for tasks: ");
                    String keyword = scanner.nextLine();
                    searchTasks(keyword);
                    break;  
                case 6:
                    // Delete a task
                    System.out.print("Enter the index of the task to delete (starting from 0): ");
                    int taskIndex1 = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    deleteTask(taskIndex1);
                    break;    
                case 7:
                    // Exit the program
                    System.out.println("Exiting To-Do List App. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
