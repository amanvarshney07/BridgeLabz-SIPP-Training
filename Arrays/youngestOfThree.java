package Arrays;
import java.util.*;
public class youngestOfThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] names = {"Amar", "Akbar", "Anthony"};
		int age[] =new int[3];
		int height[] =new int[3];
		for(int i=0;i<3;i++) {
			age[i] =sc.nextInt();
			height[i] = sc.nextInt();
			
		}
		int youngestindex=0;
		for(int i=1;i<3;i++) {
			if(age[i]<youngestindex) {
				youngestindex=i;
			}
		}
		int tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (height[i] > height[tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.println("Youngest friend is: " + names[youngestindex]);
        System.out.println("Tallest friend is: " + names[tallestIndex]);
	}
}
