import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        return Arrays.binarySearch(arr, target);
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();

        for (int n : sizes) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = rand.nextInt(n * 10);
            }

            int target = data[rand.nextInt(n)];

            long start = System.nanoTime();
            linearSearch(data, target);
            long end = System.nanoTime();
            double linearTime = (end - start) / 1e6;

            Arrays.sort(data);

            start = System.nanoTime();
            binarySearch(data, target);
            end = System.nanoTime();
            double binaryTime = (end - start) / 1e6;

            System.out.printf("Dataset Size: %d%n", n);
            System.out.printf("Linear Search Time: %.4f ms%n", linearTime);
            System.out.printf("Binary Search Time: %.4f ms%n", binaryTime);
            System.out.println("---------------------------");
        }
    }
}
