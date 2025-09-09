import java.io.*;

class UserDataWriter {
    public static void main(String[] args) {
        BufferedReader reader = null;
        FileWriter writer = null;
        
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("=== User Information Collection ===");
            
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            
            System.out.print("Enter your age: ");
            String ageInput = reader.readLine();
            int age = Integer.parseInt(ageInput);
            
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();
            
            String filename = "user_data.txt";
            writer = new FileWriter(filename);
            
            writer.write("=== User Information ===\n");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");
            writer.write("Date Recorded: " + new java.util.Date() + "\n");
            
            System.out.println("\n✅ User data successfully saved to: " + filename);
            
            displayFileContents(filename);
            
        } catch (IOException e) {
            System.out.println("❌ Error handling file operations: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid age format. Please enter a valid number.");
        } catch (Exception e) {
            System.out.println("❌ An unexpected error occurred: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("❌ Error closing resources: " + e.getMessage());
            }
        }
    }
    
    public static void displayFileContents(String filename) {
        System.out.println("\n=== File Contents ===");
        
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }
    
    public static void appendUserData() {
        BufferedReader reader = null;
        FileWriter writer = null;
        
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("\n=== Add Another User ===");
            
            System.out.print("Enter name: ");
            String name = reader.readLine();
            
            System.out.print("Enter age: ");
            int age = Integer.parseInt(reader.readLine());
            
            System.out.print("Enter favorite programming language: ");
            String language = reader.readLine();
            
            writer = new FileWriter("user_data.txt", true);
            
            writer.write("\n--- Additional User ---\n");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");
            writer.write("Date Added: " + new java.util.Date() + "\n");
            
            System.out.println("✅ Additional user data appended successfully!");
            
        } catch (IOException e) {
            System.out.println("❌ Error appending data: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid age format.");
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("❌ Error closing resources: " + e.getMessage());
            }
        }
    }
    
    public static void validateAndSaveUser() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("validated_user_data.txt")) {
            
            System.out.println("\n=== Enhanced User Data Collection ===");
            
            String name;
            do {
                System.out.print("Enter your name (min 2 characters): ");
                name = reader.readLine().trim();
                if (name.length() < 2) {
                    System.out.println("⚠️  Name must be at least 2 characters long.");
                }
            } while (name.length() < 2);
            
            int age;
            do {
                System.out.print("Enter your age (1-120): ");
                try {
                    age = Integer.parseInt(reader.readLine().trim());
                    if (age < 1 || age > 120) {
                        System.out.println("⚠️  Age must be between 1 and 120.");
                        age = -1;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("⚠️  Please enter a valid number for age.");
                    age = -1;
                }
            } while (age < 1 || age > 120);
            
            String language;
            do {
                System.out.print("Enter your favorite programming language: ");
                language = reader.readLine().trim();
                if (language.isEmpty()) {
                    System.out.println("⚠️  Programming language cannot be empty.");
                }
            } while (language.isEmpty());
            
            writer.write("=== Validated User Information ===\n");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + " years old\n");
            writer.write("Favorite Programming Language: " + language + "\n");
            writer.write("Validation Status: PASSED\n");
            writer.write("Timestamp: " + new java.util.Date() + "\n");
            
            System.out.println("✅ Validated user data saved successfully!");
            
        } catch (IOException e) {
            System.out.println("❌ File operation error: " + e.getMessage());
        }
    }
}