package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.Factory.ConnectionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "investimentoTesteServlet", value = "/investimento-teste-servlet")
public class InvestimentoTesteServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Initialize database connection
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM users WHERE id = 4";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            out.println("<html><head><link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'></head><body>");
            out.println("<div class='container'>");
            out.println("<h1 class='my-4'>Despesas List</h1>");
            out.println("<div class='row'>"); // Start row for cards
            while (rs.next()) {
                long idDespesa = rs.getLong("id");
                String descricao = rs.getString("name");
                String dataPagamento = rs.getString("email");
                String statusPagamento = rs.getString("country");
                out.println("<div class='col-md-4 mb-4'>");
                out.println("<div class='card h-100'>");
                out.println("<div class='card-body'>");
                out.println("<h5 class='card-title'>Descrição: " + descricao + "</h5>");
                out.println("<p class='card-text'><strong>Data Pagamento:</strong> " + dataPagamento + "</p>");
                out.println("<p class='card-text'><strong>Status Pagamento:</strong> " + statusPagamento + "</p>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
            }

            out.println("</div>"); // End row
            out.println("</div>"); // End container
            out.println("</body></html>");

        } catch (SQLException e) {
            out.println("<html><body>");
            out.println("<h1>Error: Unable to fetch despesas</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.println("</body></html>");
        }

        System.out.println("GET method executed: fetched all despesas");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST method");
    }

    public void destroy() {
    }
}
