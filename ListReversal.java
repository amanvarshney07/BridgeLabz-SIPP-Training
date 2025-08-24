import java.util.*;

class ListReversal{
    public static <T> void reverseArrayList(ArrayList<T> list){
        int left = 0, right = list.size() - 1;
        while(left < right){
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public static <T> LinkedList<T> reverseLinkedList(LinkedList<T> list){
        LinkedList<T> reversed = new LinkedList<>();
        for (T element : list) reversed.addFirst(element);
        return reversed;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(arrayList);
        reverseArrayList(arrayList);
        System.out.println(arrayList);
        LinkedList <Integer> linkedlist  =new LinkedList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(linkedlist);
        linkedlist = reverseLinkedList(linkedlist); 
    }
}