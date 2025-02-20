import java.util.ArrayList;
import java.util.Scanner;

public class StaffManagement {
    private static ArrayList<Staff> staffList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            while (!input.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                input.next(); // Clear invalid input
            }
            option = input.nextInt();
            input.nextLine(); // Consume newline

            switch (option) {
                case 1 -> addStaff(input);
                case 2 -> updateStaff(input);
                case 3 -> removeStaff(input);
                case 4 -> searchStaff(input);
                case 5 -> System.out.println("Exiting... Have a great day!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (option != 5);
    }

    private static void displayMenu() {
        System.out.println("\nEmployee Management System");
        System.out.println("1. Add New Employee");
        System.out.println("2. Update Employee Details");
        System.out.println("3. Remove Employee");
        System.out.println("4. Search Employee");
        System.out.println("5. Exit");
    }

    private static void addStaff(Scanner input) {
        System.out.print("Enter Employee ID: ");
        int employeeId = input.nextInt();
        input.nextLine(); // Consume newline

        System.out.print("Enter Employee Name: ");
        String employeeName = input.nextLine();

        System.out.print("Enter Employee Salary: ");
        while (!input.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a valid salary.");
            input.next(); // Clear invalid input
        }
        double salary = input.nextDouble();
        
        staffList.add(new Staff(employeeId, employeeName, salary));
        System.out.println("Employee added successfully.");
    }

    private static void updateStaff(Scanner input) {
        System.out.print("Enter Employee ID to update: ");
        int employeeId = input.nextInt();
        input.nextLine(); // Consume newline

        for (Staff staff : staffList) {
            if (staff.employeeId == employeeId) {
                System.out.print("Enter new Name: ");
                staff.employeeName = input.nextLine();

                System.out.print("Enter new Salary: ");
                while (!input.hasNextDouble()) {
                    System.out.println("Invalid input! Please enter a valid salary.");
                    input.next(); // Clear invalid input
                }
                staff.salary = input.nextDouble();

                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    private static void removeStaff(Scanner input) {
        System.out.print("Enter Employee ID to remove: ");
        int employeeId = input.nextInt();

        for (Staff staff : staffList) {
            if (staff.employeeId == employeeId) {
                staffList.remove(staff);
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    private static void searchStaff(Scanner input) {
        System.out.print("Enter Employee ID to search: ");
        int employeeId = input.nextInt();

        for (Staff staff : staffList) {
            if (staff.employeeId == employeeId) {
                System.out.println(staff);
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}