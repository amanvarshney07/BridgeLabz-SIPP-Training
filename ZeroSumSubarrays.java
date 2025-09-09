import java.util.*;

public class ZeroSumSubarrays {
    
    static void findZeroSumSubarrays(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if (sum == 0) {
                System.out.println("Subarray: [0, " + i + "]");
            }
            
            if (map.containsKey(sum)) {
                ArrayList<Integer> list = map.get(sum);
                for (int start : list) {
                    System.out.println("Subarray: [" + (start + 1) + ", " + i + "]");
                }
            }
            
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
    }
    
    static void displayArray(int[] arr) {
        System.out.print("Array: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
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
        
        displayArray(arr);
        System.out.println("Zero sum subarrays:");
        findZeroSumSubarrays(arr);
        
        sc.close();
    }
}