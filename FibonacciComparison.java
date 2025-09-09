public class FibonacciComparison {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] testCases = {10, 30, 40}; 

        for (int n : testCases) {
            System.out.println("Fibonacci(" + n + ")");

            long start = System.currentTimeMillis();
            int rec = fibonacciRecursive(n);
            long end = System.currentTimeMillis();
            System.out.println("Recursive result: " + rec + " | Time: " + (end - start) + " ms");

            start = System.currentTimeMillis();
            int iter = fibonacciIterative(n);
            end = System.currentTimeMillis();
            System.out.println("Iterative result: " + iter + " | Time: " + (end - start) + " ms");

            System.out.println("---------------------------");
        }
    }
}
