package bridgelabs;
import java.util.*;
public class basic_calculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        float number1 = input.nextFloat();
        float number2 = input.nextFloat();

        float sum = number1 + number2;
        float difference = number1 - number2;
        float product = number1 * number2;
        float division = number2 != 0 ? number1 / number2 : 0;

        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " 
            + number1 + " and " + number2 + " is " 
            + sum + ", " + difference + ", " + product + ", and " + division);

	}

}
