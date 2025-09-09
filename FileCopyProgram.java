import java.io.*;
import java.util.Scanner;

class FileCopyProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter source file name: ");
        String sourceFile = scanner.nextLine();
        
        System.out.print("Enter destination file name: ");
        String destinationFile = scanner.nextLine();
        
        copyFile(sourceFile, destinationFile);
        scanner.close();
    }
    
    public static void copyFile(String sourceFile, String destinationFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        try {
            File source = new File(sourceFile);
            if (!source.exists()) {
                System.out.println("Error: Source file '" + sourceFile + "' does not exist!");
                return;
            }
            
            if (!source.canRead()) {
                System.out.println("Error: Cannot read from source file '" + sourceFile + "'");
                return;
            }
            
            fis = new FileInputStream(source);
            fos = new FileOutputStream(destinationFile);
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalBytes = 0;
            
            System.out.println("Copying file...");
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }
            
            System.out.println("File copied successfully!");
            System.out.println("Total bytes copied: " + totalBytes);
            System.out.println("Source: " + sourceFile);
            System.out.println("Destination: " + destinationFile);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: I/O exception occurred - " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Error: Access denied - " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing files: " + e.getMessage());
            }
        }
    }
    
    public static void createSampleFile() {
        try (FileOutputStream fos = new FileOutputStream("sample.txt")) {
            String content = "Hello World!\nThis is a sample file for testing.\nJava File I/O operations.";
            fos.write(content.getBytes());
            System.out.println("Sample file 'sample.txt' created!");
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }
}