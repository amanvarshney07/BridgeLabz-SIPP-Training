import java.util.Stack;
import java.util.Scanner;

public class QueueUsingStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    void enqueue(int x) {
        s1.push(x);
    }
    
    int dequeue() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.isEmpty() ? -1 : s2.pop();
    }
    
    int front() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.isEmpty() ? -1 : s2.peek();
    }
    
    boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    
    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("\n1.Enqueue 2.Dequeue 3.Front 4.Empty 5.Exit");
            int ch = sc.nextInt();
            
            if(ch == 1) {
                System.out.print("Value: ");
                q.enqueue(sc.nextInt());
            } else if(ch == 2) {
                System.out.println("Dequeued: " + q.dequeue());
            } else if(ch == 3) {
                System.out.println("Front: " + q.front());
            } else if(ch == 4) {
                System.out.println("Empty: " + q.isEmpty());
            } else if(ch == 5) {
                break;
            }
        }
        sc.close();
    }
}