import java.util.*;

public class SetToSortedList {
    
    public static <T extends Comparable<T>> List<T> convertToSortedList(Set<T> set) {
        List<T> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
    
    public static List<Integer> convertIntegerSetToSortedList(Set<Integer> set) {
        return set.stream().sorted().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    public static void main(String[] args) {
        Set<Integer> intSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("Input Set: " + intSet);
        System.out.println("Sorted List: " + convertToSortedList(intSet));
        
        Set<String> stringSet = new HashSet<>(Arrays.asList("banana", "apple", "cherry", "date"));
        System.out.println("Input Set: " + stringSet);
        System.out.println("Sorted List: " + convertToSortedList(stringSet));
        
        Set<Integer> intSet2 = new HashSet<>(Arrays.asList(7, 2, 8, 4, 6));
        System.out.println("Input Set: " + intSet2);
        System.out.println("Sorted List (Stream): " + convertIntegerSetToSortedList(intSet2));
    }
}