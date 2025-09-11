import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "The quick brown fox jumps over the lazy dog. The dog was sleeping under the tree.";
        
        Arrays.stream(paragraph.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+"))
            .collect(Collectors.toMap(Function.identity(), w -> 1, Integer::sum))
            .forEach((word, count) -> System.out.println(word + ": " + count));
    }
}