import java.util.ArrayList;

class SuppressWarningsDemo {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        
        list.add("Hello");
        list.add(123);
        list.add(45.67);
        list.add(true);
        
        System.out.println("List contents: " + list);
        
        String str = (String) list.get(0);
        Integer num = (Integer) list.get(1);
        Double decimal = (Double) list.get(2);
        Boolean bool = (Boolean) list.get(3);
        
        System.out.println("String: " + str);
        System.out.println("Integer: " + num);
        System.out.println("Double: " + decimal);
        System.out.println("Boolean: " + bool);
    }
}