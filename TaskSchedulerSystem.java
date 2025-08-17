import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;
    
    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskCircularLinkedList {
    private Task head;
    private Task current;
    
    public TaskCircularLinkedList() {
        this.head = null;
        this.current = null;
    }
    
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task last = head;
            while (last.next != head) {
                last = last.next;
            }
            
            newTask.next = head;
            last.next = newTask;
            head = newTask;
            current = head;
        }
        System.out.println("Task added at beginning successfully!");
    }
    
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task last = head;
            while (last.next != head) {
                last = last.next;
            }
            
            last.next = newTask;
            newTask.next = head;
        }
        System.out.println("Task added at end successfully!");
    }
    
    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position < 1) {
            System.out.println("Position should be >= 1");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        
        if (head == null) {
            System.out.println("List is empty! Adding at position 1.");
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
            if (temp == head) {
                System.out.println("Position out of bounds! Adding at end.");
                addAtEnd(taskId, taskName, priority, dueDate);
                return;
            }
        }
        
        newTask.next = temp.next;
        temp.next = newTask;
        System.out.println("Task added at position " + position + " successfully!");
    }
    
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }
        
        if (head.next == head && head.taskId == taskId) {
            head = null;
            current = null;
            System.out.println("Task with ID " + taskId + " removed successfully!");
            return;
        }
        
        if (head.taskId == taskId) {
            Task last = head;
            while (last.next != head) {
                last = last.next;
            }
            
            last.next = head.next;
            head = head.next;
            current = head;
            System.out.println("Task with ID " + taskId + " removed successfully!");
            return;
        }
        
        Task temp = head;
        while (temp.next != head && temp.next.taskId != taskId) {
            temp = temp.next;
        }
        
        if (temp.next.taskId == taskId) {
            if (current == temp.next) {
                current = temp.next.next;
            }
            temp.next = temp.next.next;
            System.out.println("Task with ID " + taskId + " removed successfully!");
        } else {
            System.out.println("Task with ID " + taskId + " not found!");
        }
    }
    
    public void viewCurrentTaskAndMoveNext() {
        if (head == null) {
            System.out.println("No tasks in the scheduler!");
            return;
        }
        
        System.out.println("\n--- Current Task ---");
        displayTaskInfo(current);
        
        current = current.next;
        System.out.println("\nMoved to next task in the circular list.");
    }
    
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the scheduler!");
            return;
        }
        
        System.out.println("\n--- All Tasks (Circular List) ---");
        Task temp = head;
        int position = 1;
        
        do {
            System.out.println("\nPosition " + position + ":");
            displayTaskInfo(temp);
            if (temp == current) {
                System.out.println(">>> CURRENT TASK <<<");
            }
            temp = temp.next;
            position++;
        } while (temp != head);
    }
    
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the scheduler!");
            return;
        }
        
        Task temp = head;
        boolean found = false;
        
        System.out.println("\n--- Tasks with Priority " + priority + " ---");
        do {
            if (temp.priority == priority) {
                displayTaskInfo(temp);
                System.out.println("---");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        
        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
    
    private void displayTaskInfo(Task task) {
        System.out.println("Task ID: " + task.taskId);
        System.out.println("Task Name: " + task.taskName);
        System.out.println("Priority: " + task.priority);
        System.out.println("Due Date: " + task.dueDate);
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void getCurrentTaskInfo() {
        if (current == null) {
            System.out.println("No current task!");
        } else {
            System.out.println("\n--- Current Task Details ---");
            displayTaskInfo(current);
        }
    }
    
    public void demonstrateCircularNature(int steps) {
        if (head == null) {
            System.out.println("No tasks to demonstrate!");
            return;
        }
        
        System.out.println("\n--- Demonstrating Circular Nature ---");
        System.out.println("Starting from current task, moving " + steps + " steps:");
        
        Task temp = current;
        for (int i = 1; i <= steps; i++) {
            System.out.println("\nStep " + i + ":");
            displayTaskInfo(temp);
            temp = temp.next;
        }
    }
}

public class TaskSchedulerSystem {
    public static void main(String[] args) {
        TaskCircularLinkedList taskScheduler = new TaskCircularLinkedList();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Task Scheduler System ===");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Specific Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task & Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Tasks by Priority");
            System.out.println("8. Show Current Task Details");
            System.out.println("9. Demonstrate Circular Nature");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Task ID: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Task Name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter Priority (1-10, 1=Highest): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Due Date (DD/MM/YYYY): ");
                    String dueDate = scanner.nextLine();
                    
                    if (choice == 1) {
                        taskScheduler.addAtBeginning(taskId, taskName, priority, dueDate);
                    } else if (choice == 2) {
                        taskScheduler.addAtEnd(taskId, taskName, priority, dueDate);
                    } else {
                        System.out.print("Enter Position: ");
                        int position = scanner.nextInt();
                        taskScheduler.addAtPosition(taskId, taskName, priority, dueDate, position);
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    int removeId = scanner.nextInt();
                    taskScheduler.removeByTaskId(removeId);
                    break;
                    
                case 5:
                    taskScheduler.viewCurrentTaskAndMoveNext();
                    break;
                    
                case 6:
                    taskScheduler.displayAllTasks();
                    break;
                    
                case 7:
                    System.out.print("Enter Priority to search (1-10): ");
                    int searchPriority = scanner.nextInt();
                    taskScheduler.searchByPriority(searchPriority);
                    break;
                    
                case 8:
                    taskScheduler.getCurrentTaskInfo();
                    break;
                    
                case 9:
                    System.out.print("Enter number of steps to demonstrate: ");
                    int steps = scanner.nextInt();
                    taskScheduler.demonstrateCircularNature(steps);
                    break;
                    
                case 10:
                    System.out.println("Thank you for using Task Scheduler System!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}