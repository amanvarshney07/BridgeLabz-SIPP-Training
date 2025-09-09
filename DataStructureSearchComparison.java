import java.util.*;

public class DataStructureSearchComparison {

    public static boolean arraySearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        Random rand = new Random();

        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(n * 10);
            }
            int target = arr[rand.nextInt(n)];

            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int num : arr) {
                hashSet.add(num);
                treeSet.add(num);
            }

            long start, end;

            start = System.nanoTime();
            arraySearch(arr, target);
            end = System.nanoTime();
            double arrayTime = (end - start) / 1e6;

            start = System.nanoTime();
            hashSet.contains(target);
            end = System.nanoTime();
            double hashSetTime = (end - start) / 1e6;

            start = System.nanoTime();
            treeSet.contains(target);
            end = System.nanoTime();
            double treeSetTime = (end - start) / 1e6;

            System.out.println("Dataset Size: " + n);
            System.out.printf("Array Search Time: %.4f ms%n", arrayTime);
            System.out.printf("HashSet Search Time: %.4f ms%n", hashSetTime);
            System.out.printf("TreeSet Search Time: %.4f ms%n", treeSetTime);
            System.out.println("---------------------------");
        }
    }
}
