package Java_Control_Flow_Concepts;

public class DayOfWeek {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println(" DayOfWeek <month> <day> <year>");
            return;
        }

        int m = Integer.parseInt(args[0]); 
        int d = Integer.parseInt(args[1]); 
        int y = Integer.parseInt(args[2]); 

        if (m < 3) {
            m += 12;
            y--;
        }

        int k = y % 100;
        int j = y / 100;

        int dayOfWeek = (d + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

        int result = (dayOfWeek + 6) % 7;

        System.out.println("Day of the week (0=Sunday,...,6=Saturday): " + result);
    }
}
