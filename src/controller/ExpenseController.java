package controller;

import dao.ExpenseDAO;
import model.Expense;

import java.util.List;

public class ExpenseController {
    private ExpenseDAO dao = new ExpenseDAO();

    public void addExpense(String desc, double amt, String cat, String date) {
        Expense exp = new Expense(desc, amt, cat, date);
        dao.addExpense(exp);
    }

    public List<Expense> getAllExpenses() {
        return dao.getAllExpenses();
    }

    public void deleteExpense(int id) {
        dao.deleteExpense(id);
    }

    public double getTotalExpense() {
        return dao.getTotalExpense();
    }
}
