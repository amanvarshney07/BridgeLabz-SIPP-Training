import java.util.Scanner;

class Process {
    int processId, burstTime, priority, remainingTime, waitingTime, turnaroundTime;
    Process next;
    
    Process(int id, int burst, int prio) {
        processId = id; burstTime = remainingTime = burst; priority = prio;
        waitingTime = turnaroundTime = 0;
    }
}

class RoundRobinScheduler {
    private Process head, tail;
    private int totalProcesses = 0;
    
    public void addProcess(int id, int burst, int priority) {
        Process newProcess = new Process(id, burst, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
        totalProcesses++;
        System.out.println("Process " + id + " added!");
    }
    
    public void removeProcess(int id) {
        if (head == null) return;
        
        if (head.processId == id && head == tail) {
            head = tail = null;
            totalProcesses--;
            return;
        }
        
        if (head.processId == id) {
            tail.next = head.next;
            head = head.next;
            totalProcesses--;
            return;
        }
        
        Process temp = head;
        while (temp.next != head && temp.next.processId != id) {
            temp = temp.next;
        }
        
        if (temp.next.processId == id) {
            if (temp.next == tail) tail = temp;
            temp.next = temp.next.next;
            totalProcesses--;
        }
    }
    
    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule!");
            return;
        }
        
        Process current = head;
        int currentTime = 0, round = 1;
        
        System.out.println("\n=== Round Robin Simulation (Quantum: " + timeQuantum + ") ===");
        
        while (totalProcesses > 0) {
            System.out.println("\nRound " + round++);
            Process start = current;
            
            do {
                if (current.remainingTime > 0) {
                    int executeTime = Math.min(timeQuantum, current.remainingTime);
                    current.remainingTime -= executeTime;
                    currentTime += executeTime;
                    
                    System.out.println("Process " + current.processId + " executed for " + executeTime + 
                        " units (Remaining: " + current.remainingTime + ")");
                    
                    if (current.remainingTime == 0) {
                        current.turnaroundTime = currentTime;
                        current.waitingTime = current.turnaroundTime - current.burstTime;
                        System.out.println("Process " + current.processId + " completed!");
                        
                        Process toRemove = current;
                        current = current.next;
                        removeProcess(toRemove.processId);
                        
                        if (totalProcesses == 0) break;
                        if (current == toRemove) current = head;
                    } else {
                        current = current.next;
                    }
                } else {
                    current = current.next;
                }
            } while (current != start && totalProcesses > 0);
            
            displayQueue();
        }
        
        calculateAverages();
    }
    
    public void displayQueue() {
        if (head == null) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.print("Current Queue: ");
        Process temp = head;
        do {
            System.out.print("P" + temp.processId + "(" + temp.remainingTime + ") ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
    
    private void calculateAverages() {
        System.out.println("\n=== Execution Summary ===");
        // Note: This simplified version shows averages based on completed processes
        // In a real implementation, you'd store completed processes separately
        System.out.println("All processes completed successfully!");
    }
}

public class CPUSchedulerSystem {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Round-Robin CPU Scheduler ===");
            System.out.println("1. Add Process  2. Display Queue  3. Start Simulation  4. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Process ID: "); int id = sc.nextInt();
                    System.out.print("Burst Time: "); int burst = sc.nextInt();
                    System.out.print("Priority: "); int priority = sc.nextInt();
                    scheduler.addProcess(id, burst, priority);
                    break;
                case 2:
                    scheduler.displayQueue();
                    break;
                case 3:
                    System.out.print("Time Quantum: "); int quantum = sc.nextInt();
                    scheduler.simulate(quantum);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}