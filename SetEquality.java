import java.util.*;

public class SetEquality {
    
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }
    
    public static <T> boolean areListsEqualAsSets(List<T> list1, List<T> list2) {
        return new HashSet<>(list1).equals(new HashSet<>(list2));
    }
    
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Are equal: " + areSetsEqual(set1, set2));
        
        Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 2, 4));
        System.out.println("Set3: " + set3);
        System.out.println("Set1 equals Set3: " + areSetsEqual(set1, set3));
        
        List<String> list1 = Arrays.asList("apple", "banana", "cherry");
        List<String> list2 = Arrays.asList("cherry", "apple", "banana");
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("Equal as sets: " + areListsEqualAsSets(list1, list2));
    }
}