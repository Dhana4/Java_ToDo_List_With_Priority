package taskPriority;
import java.io.*;
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
	  
	  public static ArrayList<Task> searchTasks(String searchTerm) {
		    ArrayList<Task> matchingTasks = new ArrayList<>();

		    for (Task task : tasks) {
		        String description = task.getDescription();
		        if (description != null && description.toLowerCase().contains(searchTerm.toLowerCase())) {
		            matchingTasks.add(task);
		        }
		    }

		    return matchingTasks;
		}
	  
	  
	 
	  public static void sortTasks(ArrayList<Task> tasks) {
		    Collections.sort(tasks, new Comparator<Task>() {
		        @Override
		        public int compare(Task task1, Task task2) {
		            // Check for null values
		            if (task1.getPriority() == null && task2.getPriority() == null) {
		                // Both priorities are null; consider them equal
		                return 0;
		            } else if (task1.getPriority() == null) {
		                // Task1's priority is null; it should come after task2
		                return 1;
		            } else if (task2.getPriority() == null) {
		                // Task2's priority is null; it should come after task1
		                return -1;
		            } else {
		                // Compare by priority first
		                int priorityComparison = task1.getPriority().compareTo(task2.getPriority());

		                // If priorities are the same, compare by due date
		                if (priorityComparison == 0) {
		                    return task1.getDueDate().compareTo(task2.getDueDate());
		                }

		                return priorityComparison;
		            }
		        }
		    });
    }
	
	public static void toggleTaskCompletion(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            task.setCompleted(!task.isCompleted()); // Toggle completion status
        } else {
            System.out.println("Invalid task index. Please try again.");
        }
    }
	
	public static void deleteTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task removedTask = tasks.remove(taskIndex);
            System.out.println(removedTask.getDescription());
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
                     System.out.print("Enter task No: ");
                    String taskno = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter due date: ");
                    String dueDate = scanner.nextLine();
                    System.out.print("Enter priority: ");
                    String priority = scanner.nextLine();

                    Task newTask = new Task(taskno,description, dueDate, priority);
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
    @SuppressWarnings("unchecked")
    public static ArrayList<Task> loadTasksFromFile(String filename) {
        ArrayList<Task> loadedTasks = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            loadedTasks = (ArrayList<Task>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        tasks.clear();
        for(Task g:loadedTasks)
        {
        	tasks.add(g);
        }
        return tasks;
    }
    
    public static void saveTasksToFile(String filename) {
    	ArrayList<Task> bb=new ArrayList<>();
    	ArrayList<Task> cc=new ArrayList<>();
    	bb=loadTasksFromFile(filename);
    	for(Task y:bb)
    	{
    		cc.add(y);
    	}
    	for(Task z: tasks) {
    		cc.add(z);
    	}
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(cc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
