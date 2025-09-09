import java.util.Stack;
import java.util.Scanner;

public class SortStackRecursion {
    
    static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertSorted(stack, temp);
        }
    }
    
    static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertSorted(stack, element);
            stack.push(temp);
        }
    }
    
    static void display(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1.Push 2.Sort 3.Display 4.Exit");
            int ch = sc.nextInt();
            
            if (ch == 1) {
                System.out.print("Value: ");
                stack.push(sc.nextInt());
            } else if (ch == 2) {
                sortStack(stack);
                System.out.println("Stack sorted!");
            } else if (ch == 3) {
                display(stack);
            } else if (ch == 4) {
                break;
            }
        }
        sc.close();
    }
}