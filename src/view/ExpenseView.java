package view;

import controller.ExpenseController;
import model.Expense;

import java.util.List;
import java.util.Scanner;

public class ExpenseView {
    private ExpenseController controller = new ExpenseController();
    private Scanner sc = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n--- Expense Tracker Menu ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. View Total Expense");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> viewAllExpenses();
                case 3 -> deleteExpense();
                case 4 -> viewTotal();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void addExpense() {
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter category: ");
        String cat = sc.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        controller.addExpense(desc, amt, cat, date);
        System.out.println("Expense added successfully!");
    }

    private void viewAllExpenses() {
        List<Expense> expenses = controller.getAllExpenses();
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        System.out.println("\nID | Description | Amount | Category | Date");
        for (Expense e : expenses) {
            System.out.printf("%d | %s | %.2f | %s | %s%n", e.getId(), e.getDescription(), e.getAmount(), e.getCategory(), e.getDate());
        }
    }

    private void deleteExpense() {
        System.out.print("Enter expense ID to delete: ");
        int id = sc.nextInt();
        controller.deleteExpense(id);
        System.out.println("Deleted successfully.");
    }

    private void viewTotal() {
        double total = controller.getTotalExpense();
        System.out.printf("Total Expense: %.2f%n", total);
    }
}
