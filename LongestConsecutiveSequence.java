import java.util.*;

public class LongestConsecutiveSequence {
    
    static int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        
        int maxLength = 0;
        
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        return maxLength;
    }
    
    static void findLongestSequence(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        
        int maxLength = 0;
        int startNum = 0;
        
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startNum = num;
                }
            }
        }
        
        System.out.println("Longest consecutive sequence length: " + maxLength);
        if (maxLength > 0) {
            System.out.print("Sequence: ");
            for (int i = 0; i < maxLength; i++) {
                System.out.print((startNum + i) + " ");
            }
            System.out.println();
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
        
        System.out.print("Array: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        
        findLongestSequence(arr);
        
        sc.close();
    }
}