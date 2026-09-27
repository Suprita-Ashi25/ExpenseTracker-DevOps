package com.expense.tracker;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add-expense")
public class AddExpenseServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("expenseName");
        String amountText = request.getParameter("amount");
        String category = request.getParameter("category");
        String date = request.getParameter("date");

        try {
            double amount = Double.parseDouble(amountText);

            ExpenseTrackerApplication.addExpense(
                    name,
                    amount,
                    category,
                    date
            );

            response.sendRedirect("expenses");

        } catch (NumberFormatException e) {
            response.sendRedirect("add-expense.html?error=invalid");
        }
    }
}