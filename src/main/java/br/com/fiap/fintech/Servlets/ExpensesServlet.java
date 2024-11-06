package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.Entities.Expenses;
import br.com.fiap.fintech.Factory.ConnectionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import static java.lang.System.out;

@WebServlet("/newExpense")
public class ExpensesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        Double amount = Double.parseDouble(req.getParameter("amount"));
        String description = req.getParameter("description");
        Date date = new Date();

        // Initialize Expense object with user ID from form data (for example, use a hidden input in your form for this)
        Long userId = Long.parseLong(req.getParameter("user_id"));
        Long id = Long.parseLong(req.getParameter("id"));
        Expenses exp = new Expenses(id, description, date, amount, true, category, userId);

        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            String sql = "INSERT INTO despesas (description, date_investment, amount, status_payment, name, user_id) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, exp.getDescription());
                stmt.setDate(2, new java.sql.Date(exp.getPayment_date().getTime()));
                stmt.setDouble(3, exp.getValues());
                stmt.setBoolean(4, exp.getStatusPayment());
                stmt.setString(5, exp.getCategory());
                stmt.setLong(6, exp.getUserId());  // Use userId from the Expenses object

                int rowsInserted = stmt.executeUpdate();

                PrintWriter write = resp.getWriter();
                if (rowsInserted > 0) {
                    write.println("<html><body>category " + category + " cadastrada com sucesso!</body></html>");
                } else {
                    write.println("<html><body>Failed to register expense.</body></html>");
                }
            }
            System.out.println("Expense successfully submitted");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().println("<html><body>Error: Could not save expense. " + e.getMessage() + "</body></html>");
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }
}
