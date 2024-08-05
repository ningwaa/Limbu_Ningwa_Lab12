import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {

    public static void main(String[] args) {
        ArrayList<String> records = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        char moreData;

        do {
            String firstName = SafeInput.getNonEmptyString(scanner, "Enter first name: ");
            String lastName = SafeInput.getNonEmptyString(scanner, "Enter last name: ");
            String idNumber = SafeInput.getFormattedString(scanner, "Enter ID number (000001, 000002, etc.): ", "\\d{6}");
            String email = SafeInput.getNonEmptyString(scanner, "Enter email: ");
            int yearOfBirth = SafeInput.getInt(scanner, "Enter year of birth: ");

            String record = String.format("%s, %s, %s, %s, %d", firstName, lastName, idNumber, email, yearOfBirth);
            records.add(record);

            System.out.print("Do you want to enter another record? (Y/N): ");
            moreData = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline

        } while (moreData == 'Y' || moreData == 'y');

        System.out.print("Enter the filename to save (without extension): ");
        String filename = scanner.nextLine();
        saveRecords(records, filename + ".csv");
    }

    private static void saveRecords(ArrayList<String> records, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/" + filename))) {
            for (String record : records) {
                writer.println(record);
            }
            System.out.println("Records saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving records: " + e.getMessage());
        }
    }
}