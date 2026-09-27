package com.expense.tracker;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/expenses")
public class ViewExpensesServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        StringBuilder html = new StringBuilder();

        html.append("<!DOCTYPE html>");
        html.append("<html>");
        html.append("<head>");
        html.append("<title>View Expenses</title>");

        html.append("<style>");
        html.append("body { font-family: Arial; margin: 40px; }");
        html.append("table { border-collapse: collapse; width: 80%; }");
        html.append("th, td { border: 1px solid #ccc; padding: 10px; }");
        html.append("th { background-color: #f2f2f2; }");
        html.append("</style>");

        html.append("</head>");
        html.append("<body>");

        html.append("<h1>Expense List</h1>");

        html.append("<table>");
        html.append("<tr>");
        html.append("<th>Name</th>");
        html.append("<th>Amount</th>");
        html.append("<th>Category</th>");
        html.append("<th>Date</th>");
        html.append("</tr>");

        for (Expense expense : ExpenseTrackerApplication.expenses) {

            html.append("<tr>");

            html.append("<td>");
            html.append(expense.getName());
            html.append("</td>");

            html.append("<td>₹");
            html.append(expense.getAmount());
            html.append("</td>");

            html.append("<td>");
            html.append(expense.getCategory());
            html.append("</td>");

            html.append("<td>");
            html.append(expense.getDate());
            html.append("</td>");

            html.append("</tr>");
        }

        html.append("</table>");

        html.append("<h2>Total Expense: ₹");
        html.append(ExpenseTrackerApplication.getTotalExpense());
        html.append("</h2>");

        html.append("<br>");

        html.append("<a href='add-expense.html'>Add Another Expense</a>");
        html.append("<br><br>");
        html.append("<a href='index.html'>Home</a>");

        html.append("</body>");
        html.append("</html>");

        response.getWriter().write(html.toString());
    }
}