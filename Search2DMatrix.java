import java.util.Scanner;

public class Search2DMatrix {
    
    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int midValue = matrix[row][col];
            
            if (midValue == target) {
                System.out.println("Target found at position: (" + row + ", " + col + ")");
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
    
    static void displayMatrix(int[][] matrix) {
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements (sorted):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        displayMatrix(matrix);
        
        System.out.print("Enter target value: ");
        int target = sc.nextInt();
        
        if (searchMatrix(matrix, target)) {
            System.out.println("Result: Target " + target + " found!");
        } else {
            System.out.println("Result: Target " + target + " not found!");
        }
        
        sc.close();
    }
}