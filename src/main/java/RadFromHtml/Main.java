package RadFromHtml;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean running = true;
        while (running) {
            System.out.print("Enter the input string (or 'exit' to quit): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) {
                running = false;
            } else {
                String output = input.toLowerCase()
                        .replaceAll("\\s+", "-")
                        .replaceAll("[^a-z0-9-]", "");
                
                System.out.println("Output: " + output);
            }
        }
        
        System.out.println("Program exited.");
    }
}

