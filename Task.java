package taskPriority;

public class Task {
    private String description;
    private String dueDate;
    private String priority;
    private boolean isCompleted;

    // Constructor
    public Task(String description, String dueDate, String priority) {
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
    
    public String getDescription() {
        return description;
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
        return "Description: " + description + "\nDue Date: " + dueDate + "\nPriority: " + priority + "\n";
    }
}
