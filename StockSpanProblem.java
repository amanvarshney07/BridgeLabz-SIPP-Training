import java.util.Stack;
import java.util.Scanner;

public class StockSpanProblem {
    
    static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        
        return span;
    }
    
    static void display(int[] arr, String name) {
        System.out.print(name + ": ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        
        int[] prices = new int[n];
        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        
        int[] span = calculateSpan(prices);
        
        display(prices, "Prices");
        display(span, "Spans");
        
        sc.close();
    }
}