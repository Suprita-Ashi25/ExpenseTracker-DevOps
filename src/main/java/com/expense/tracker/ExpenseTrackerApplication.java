package com.expense.tracker;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTrackerApplication {

    public static List<Expense> expenses = new ArrayList<>();

    public static void addExpense(
            String name,
            double amount,
            String category,
            String date) {

        Expense expense =
                new Expense(name, amount, category, date);

        expenses.add(expense);
    }

    public static double getTotalExpense() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }
}
