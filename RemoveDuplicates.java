import java.util.*;
public class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>();
        for (T element : list) {
            seen.add(element);
        }
        return new ArrayList<>(seen);
    }
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,1,2,2,3,4);
        System.out.println(numbers);
        List<Integer> result = removeDuplicates(numbers);
        System.out.println(result);
        List<String> str = Arrays.asList("apple", "banana", "apple", "chwerry", "banana");
        System.out.println(str);
        System.out.println(removeDuplicates(str));
    }
}
