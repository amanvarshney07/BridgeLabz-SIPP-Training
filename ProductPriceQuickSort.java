public class ProductPriceQuickSort {
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }
    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return i + 1;
    }
    public static void printArray(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        double[] productPrices = {49.99, 19.99, 29.99, 39.99, 24.99};
        System.out.println("Original Product Prices:");
        printArray(productPrices);
        
        quickSort(productPrices, 0, productPrices.length - 1);
        
        System.out.println("Sorted Product Prices (ascending order):");
        printArray(productPrices);
    }
}
