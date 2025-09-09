import java.util.*;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // List of programming languages to search for
        String[] languages = {"Java", "Python", "JavaScript", "C++", "C#", "Go", "Ruby", "PHP", "Swift", "Kotlin"};

        List<String> foundLanguages = new ArrayList<>();
        for (String lang : languages) {
            // Regex to match whole word (case-sensitive)
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(lang) + "\\b");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                foundLanguages.add(lang);
            }
        }

        if (foundLanguages.isEmpty()) {
            System.out.println("No programming languages found.");
        } else {
            System.out.println(String.join(", ", foundLanguages));
        }
    }
}
