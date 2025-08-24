import java.util.*;
public class FrequencyCounter {
    public static Map<String, Integer>  countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : list) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }
        return frequencyMap;
    }
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> frequency = countFrequency(strings);
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
