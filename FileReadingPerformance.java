import java.io.*;

public class FileReadingPerformance {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; 

        measureFileReader(filePath);
        measureInputStreamReader(filePath);
    }

    private static void measureFileReader(String filePath) {
        long start = System.currentTimeMillis();
        try (FileReader reader = new FileReader(filePath)) {
            while (reader.read() != -1) {
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("FileReader time: " + (end - start) + " ms");
    }

    private static void measureInputStreamReader(String filePath) {
        long start = System.currentTimeMillis();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            while (reader.read() != -1) {
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("InputStreamReader time: " + (end - start) + " ms");
    }
}
