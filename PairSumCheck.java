import java.util.*;

public class PairSumCheck {
    
    static boolean findPair(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : arr) {
            if (set.contains(target - num)) {
                System.out.println("Pair found: " + num + " + " + (target - num) + " = " + target);
                return true;
            }
            set.add(num);
        }
        
        System.out.println("No pair found with sum " + target);
        return false;
    }
    
    static void findAllPairs(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        boolean found = false;
        
        for (int num : arr) {
            if (set.contains(target - num)) {
                System.out.println("Pair: " + num + " + " + (target - num) + " = " + target);
                found = true;
            }
            set.add(num);
        }
        
        if (!found) {
            System.out.println("No pairs found with sum " + target);
        }
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
        
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        
        System.out.println("\n1. Check if pair exists");
        findPair(arr, target);
        
        System.out.println("\n2. Find all pairs:");
        findAllPairs(arr, target);
        
        sc.close();
    }
}