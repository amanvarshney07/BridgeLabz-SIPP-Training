public class InterestCalculator {

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        try {
            double interest = calculateInterest(10000, 5, 2);
            System.out.println("Calculated Interest: " + interest);

            // Example with invalid input
            double invalidInterest = calculateInterest(-5000, 5, 2);
            System.out.println("Calculated Interest: " + invalidInterest);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}
