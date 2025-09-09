import java.io.*;
import java.util.Scanner;

class BufferedFileCopy {
    private static final int BUFFER_SIZE = 4096;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== File Copy Performance Comparison ===");
        System.out.print("Enter source file path: ");
        String sourceFile = scanner.nextLine();
        
        if (!new File(sourceFile).exists()) {
            System.out.println("Creating a sample large file for testing...");
            createLargeFile("large_sample.txt", 10);
            sourceFile = "large_sample.txt";
        }
        
        String bufferedDest = "copy_buffered.txt";
        String unbufferedDest = "copy_unbuffered.txt";
        
        System.out.println("\nFile size: " + getFileSizeInMB(sourceFile) + " MB");
        System.out.println("Buffer size: " + BUFFER_SIZE + " bytes\n");
        
        performanceTesting(sourceFile, bufferedDest, unbufferedDest);
        
        cleanupFiles(bufferedDest, unbufferedDest);
        scanner.close();
    }
    
    public static void performanceTesting(String source, String bufferedDest, String unbufferedDest) {
        long bufferedTime = copyWithBufferedStreams(source, bufferedDest);
        long unbufferedTime = copyWithUnbufferedStreams(source, unbufferedDest);
        
        System.out.println("\n=== PERFORMANCE COMPARISON ===");
        System.out.printf("Buffered Copy Time:   %.3f ms%n", bufferedTime / 1_000_000.0);
        System.out.printf("Unbuffered Copy Time: %.3f ms%n", unbufferedTime / 1_000_000.0);
        
        double speedup = (double) unbufferedTime / bufferedTime;
        System.out.printf("Performance Improvement: %.2fx faster%n", speedup);
        
        if (speedup > 1) {
            System.out.println("✅ Buffered streams are faster!");
        } else {
            System.out.println("⚠️  Unbuffered streams performed better (unusual for large files)");
        }
    }
    
    public static long copyWithBufferedStreams(String source, String dest) {
        System.out.println("Copying with BufferedInputStream/BufferedOutputStream...");
        
        long startTime = System.nanoTime();
        
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source), BUFFER_SIZE);
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest), BUFFER_SIZE)) {
            
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            long totalBytes = 0;
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }
            
            long endTime = System.nanoTime();
            System.out.printf("Buffered copy completed: %d bytes copied%n", totalBytes);
            return endTime - startTime;
            
        } catch (IOException e) {
            System.out.println("Error in buffered copy: " + e.getMessage());
            return -1;
        }
    }
    
    public static long copyWithUnbufferedStreams(String source, String dest) {
        System.out.println("Copying with FileInputStream/FileOutputStream...");
        
        long startTime = System.nanoTime();
        
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            long totalBytes = 0;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }
            
            long endTime = System.nanoTime();
            System.out.printf("Unbuffered copy completed: %d bytes copied%n", totalBytes);
            return endTime - startTime;
            
        } catch (IOException e) {
            System.out.println("Error in unbuffered copy: " + e.getMessage());
            return -1;
        }
    }
    
    public static void createLargeFile(String filename, int sizeInMB) {
        System.out.println("Creating " + sizeInMB + "MB test file...");
        
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filename))) {
            byte[] data = "This is sample data for performance testing. ".getBytes();
            int bytesPerMB = 1024 * 1024;
            int totalBytes = sizeInMB * bytesPerMB;
            int written = 0;
            
            while (written < totalBytes) {
                int toWrite = Math.min(data.length, totalBytes - written);
                bos.write(data, 0, toWrite);
                written += toWrite;
            }
            
            System.out.println("Test file created: " + filename);
        } catch (IOException e) {
            System.out.println("Error creating test file: " + e.getMessage());
        }
    }
    
    public static double getFileSizeInMB(String filename) {
        File file = new File(filename);
        return file.length() / (1024.0 * 1024.0);
    }
    
    public static void cleanupFiles(String... files) {
        System.out.println("\nCleaning up temporary files...");
        for (String file : files) {
            if (new File(file).delete()) {
                System.out.println("Deleted: " + file);
            }
        }
    }
    
    public static void demonstrateBufferSizes() {
        System.out.println("\n=== BUFFER SIZE COMPARISON ===");
        String source = "large_sample.txt";
        
        int[] bufferSizes = {512, 1024, 2048, 4096, 8192, 16384};
        
        for (int bufferSize : bufferSizes) {
            long time = copyWithCustomBuffer(source, "temp_copy.txt", bufferSize);
            System.out.printf("Buffer %d bytes: %.3f ms%n", bufferSize, time / 1_000_000.0);
            new File("temp_copy.txt").delete();
        }
    }
    
    public static long copyWithCustomBuffer(String source, String dest, int bufferSize) {
        long startTime = System.nanoTime();
        
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source), bufferSize);
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest), bufferSize)) {
            
            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
        
        return System.nanoTime() - startTime;
    }
}