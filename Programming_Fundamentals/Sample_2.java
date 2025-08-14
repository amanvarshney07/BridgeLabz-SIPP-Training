package bridgelabz;
import java.util.Scanner;
public class Sample_2 {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("name, fromCity, viaCity, toCity, distanceFromToVia, DistanceViaToVia, timeFromToVia, timeViaToFinalCity ");
	        String name = scanner.nextLine();

	        String fromCity = scanner.nextLine();

	        String viaCity = scanner.nextLine();

	        String toCity = scanner.nextLine();

	        double distanceFromToVia = scanner.nextDouble();

	        double distanceViaToFinalCity = scanner.nextDouble();

	        int timeFromToVia = scanner.nextInt();

	        int timeViaToFinalCity = scanner.nextInt();

	        double totalDistance = distanceFromToVia + distanceViaToFinalCity;
	        int totalTime = timeFromToVia + timeViaToFinalCity;

	      
	        System.out.println();
	        System.out.println("The Total Distance travelled by " + name + " from " + fromCity + " to " + toCity + " via " + viaCity +
	                           " is " + totalDistance + " km and the Total Time taken is " + 
	                           totalTime + " minutes");

	        scanner.close();
	    }
	}

}
