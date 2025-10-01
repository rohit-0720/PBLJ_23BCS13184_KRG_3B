// Q3) Exception Handling
import java.util.ArrayList;
import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
        System.out.println("Enter numbers (type 'done' to finish):");
        
        while (true) {
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            
            try {
                int num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input, please enter a valid integer.");
            }
        }
        
        try {
            if (numbers.isEmpty()) {
                throw new ArithmeticException("Cannot calculate average of an empty list.");
            }
            
            int sum = 0;
            for (int num : numbers) {
                sum += num;
            }
            
            double average = (double) sum / numbers.size();
            System.out.println("Average: " + average);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        scanner.close();
    }
}
