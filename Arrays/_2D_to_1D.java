package Arrays;
import java.util.*;
public class _2D_to_1D {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int row= sc.nextInt();
	int column=sc.nextInt();
	
	int twoD[][]= new int[row][column];
	for(int i=0;i<row;i++) {
		for(int j=0;j<column;j++) {
			twoD[i][j]= sc.nextInt();
		}
		
	}
	
	int oneD[]= new int[row*column];
	int index=0;
	for(int i=0;i<row;i++) {
		for (int j = 0; j < column; j++) {
		oneD[index]=twoD[i][j];
		index++;
	}}
	
	System.out.println("1D Array elements:");
    for (int i = 0; i < oneD.length; i++) {
        System.out.print(oneD[i] + " ");
    }
	
	
	}

}
