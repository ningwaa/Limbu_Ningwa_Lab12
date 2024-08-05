import java.util.Scanner;

public class SafeInput {

    public static String getNonEmptyString(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
        } while (input.trim().isEmpty());
        return input;
    }

    public static String getFormattedString(Scanner scanner, String prompt, String regex) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
        } while (!input.matches(regex));
        return input;
    }

    public static int getInt(Scanner scanner, String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Discard invalid input
            }
        }
        return number;
    }
}