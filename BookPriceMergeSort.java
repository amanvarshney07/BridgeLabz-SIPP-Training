public class BookPriceMergeSort {
    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }
    public static void merge(double[] prices, int left, int mid, int right){
        int n1 = mid-left+1;
        int n2 = right-mid;

        double[] L = new double[n1];
        double[] R = new double[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = prices[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = prices[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while( i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                prices[k] = L[i];
                i++;
            } else {
                prices[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            prices[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            prices[k] = R[j];
            j++;
            k++;
        }
    }   
    public static void printArray(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        double[] bookPrices = {19.99, 9.99, 14.99, 29.99, 24.99};
        System.out.println("Original Book Prices:");
        printArray(bookPrices);
        
        mergeSort(bookPrices, 0, bookPrices.length - 1);
        
        System.out.println("Sorted Book Prices (ascending order):");
        printArray(bookPrices);
    }
}
