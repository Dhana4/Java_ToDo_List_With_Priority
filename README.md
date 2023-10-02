# Java_ToDo_List_With_Priority
 This is a command-line to-do list application in Java that allows users to add, view, prioritize, and mark tasks as completed. What makes this unique is the ability to assign priority levels to tasks.
# Task.java
The Task class in this project is a fundamental component that represents an individual task or to-do item. It encapsulates the properties and behaviors associated with tasks, allowing you to manage tasks within your to-do list application.

Purpose and Responsibility:
The Task class is responsible for modeling and storing individual tasks.
It represents tasks as objects with various attributes and methods to manage and query task data.

Attributes:
Description: Each task has a description, which is typically a brief text explaining the task's purpose or content.
Due Date: The class may include an attribute to store the due date or deadline associated with the task.
Priority: You might include an attribute to represent the priority level of the task, such as high, medium, or low.
Completion Status: There is often an attribute to track whether a task has been completed or not, typically a boolean value.

Constructors:
The Task class may provide one or more constructors to initialize task objects.
Constructors can accept arguments for setting task attributes when creating instances
Getter and Setter Methods:
You may include getter methods to retrieve the values of task attributes.
Setter methods can be used to modify task attributes when necessary.

Behavior and Methods:
Methods in the Task class may include behaviors like setting or toggling the completion status of a task.
Additional methods might perform operations related to tasks, such as comparing tasks, formatting task details, etc.
# TodoListApp.java
The ToDoListApp class in this project serves as the application's entry point and the central controller for managing and organizing tasks. It typically orchestrates the interaction between the user interface (ToDoListGUI) and the core logic of the to-do list.In your to-do list application, the ToDoListApp class acts as a controller that bridges the gap between the graphical user interface and the underlying logic for managing tasks and interactions. It plays a crucial role in coordinating the various components of your application to provide a smooth and functional user experience.
Application Entry Point:
The ToDoListApp class often serves as the main entry point for your to-do list application.
It contains the main method, which is executed when the application is started, making it the starting point of your program.

Initialization:
The class may include code for initializing necessary components of your application.
This could involve creating instances of classes such as ToDoListGUI or setting up any initial data.

Integration with GUI:
ToDoListApp interacts with the user interface (UI) through an instance of the ToDoListGUI class.
It typically creates an instance of ToDoListGUI and establishes a connection between the UI and the core functionality.

Task Management:
The class is responsible for managing tasks, such as adding tasks, removing tasks, marking tasks as completed, sorting tasks, etc.
It may use an instance of the ToDoList class (if you have one) to store and manage tasks.

Application Logic:
The class contains the core application logic and business rules.
It enforces rules for adding tasks, validating user input, and maintaining the integrity of the to-do list data.

Flow Control:
The class controls the flow of the application, guiding the user through various actions and transitions within the UI.
It may determine which actions to take based on user input or the state of the application.

Application Lifecycle:
It manages the lifecycle of the application, including initialization, execution, and termination.

Integration with Other Classes:
ToDoListApp may interact with other classes in your project, such as the Task class and potentially other utility classes or data structures you've created.
# ToDoListGUI.java
The ToDoListGUI class in your project is responsible for creating and managing the graphical user interface (GUI) of this to-do list application. It interacts with the user, displays tasks, provides input fields, buttons, and handles user interactions. In our to-do list application, the ToDoListGUI class plays a crucial role in creating an engaging and functional user interface that allows users to interact with their tasks and manage their to-do lists effectively.

User Interface Components:
The ToDoListGUI class defines and manages various user interface components, such as buttons, text areas, text fields, and labels.
It lays out these components in a way that provides an intuitive and user-friendly interface.

Task Display:
The class is responsible for displaying the list of tasks to the user. It often uses a text area or other components to show task details.

Event Listeners:
ToDoListGUI includes event listeners or action listeners for GUI components like buttons.
It listens for user interactions (e.g., button clicks) and responds by invoking corresponding actions.

Add Task Functionality:
The GUI allows users to input task information (description, due date, priority) and provides a button for adding tasks to the list.
It should handle user input validation and provide feedback for incorrect input.

View Tasks Functionality:
Users can view their list of tasks by clicking a "View Tasks" button.
The GUI retrieves and displays the list of tasks, often in a scrollable text area.

Delete Task Functionality:
There might be a way for users to delete tasks. This involves selecting a task (e.g., via checkboxes or selection) and clicking a "Delete Task" button.

Toggle Completion Status:
Users can mark tasks as completed or incomplete using a "Toggle Task Completion" button. This updates the task's status.

Sorting Tasks:
The GUI might offer sorting options, allowing users to arrange tasks by due date, priority, or other criteria.

Error Handling and Feedback:
It provides user-friendly error messages or feedback when invalid input is detected or when actions cannot be performed.

Integration with Application Logic:
The ToDoListGUI class communicates with the underlying application logic, such as the ToDoListApp class or ToDoList class, to perform actions like adding, deleting, and displaying tasks.

Layout Management:
The class manages the layout of GUI components using layout managers like FlowLayout, BorderLayout, or GridBagLayout.

Appearance and Styling:
It may define the appearance of the GUI, including fonts, colors, and other visual aspects.

User Interaction Flow:
It controls the flow of the user interaction, guiding users through the application's features and actions.

Initialization and Display:
The ToDoListGUI class often initializes and displays the GUI when the application is launched.

Responsive Design:
It ensures that the GUI is responsive and behaves correctly when users resize the application window.
