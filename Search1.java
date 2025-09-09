import java.util.*;

public class Search1 {
    
    static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (num <= n) {
                arr[num - 1] = -Math.abs(arr[num - 1]);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
    
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Original array: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        
        int[] arrCopy = arr.clone();
        int missing = firstMissingPositive(arrCopy);
        System.out.println("First missing positive: " + missing);
        
        Arrays.sort(arr);
        System.out.print("Sorted array: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        
        System.out.print("Enter target to search: ");
        int target = sc.nextInt();
        
        int index = binarySearch(arr, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target " + target + " not found");
        }
        
        sc.close();
    }
}