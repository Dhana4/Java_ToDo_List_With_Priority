package taskPriority;

import java.io.Serializable;

public class Task implements Serializable{
	private String taskno;
    private String description;
    private String dueDate;
    private String priority;
    private boolean isCompleted;

    // Constructor
    public Task(String taskno,String description, String dueDate, String priority) {
    	this.taskno=taskno;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isCompleted = false; 
    }

    // Getters and setters for description, dueDate, and priority
    
    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
    public String getno() {
        return taskno;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setno(String taskno) {
        this.taskno = taskno;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task No:" + taskno +"Description: " + description + "\nDue Date: " + dueDate + "\nPriority: " + priority + "\n";
    }
}
