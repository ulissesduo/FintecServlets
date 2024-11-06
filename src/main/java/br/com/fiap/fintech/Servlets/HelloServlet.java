package br.com.fiap.fintech.Servlets;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.fintech.Factory.ConnectionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Initialize database connection
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM despesas WHERE usuario_id_usuario = 2";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Begin the HTML response with a Bootstrap CSS link
            out.println("<html><head><link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'></head><body>");
            out.println("<div class='container'>");
            out.println("<h1 class='my-4'>Despesas List</h1>");
            out.println("<div class='row'>"); // Start row for cards

            // Loop through the result set and print each row as a card
            while (rs.next()) {
                long idDespesa = rs.getLong("id_despesa");
                String descricao = rs.getString("descricao");
                String dataPagamento = rs.getString("data_pagamento");
                double valor = rs.getDouble("valor");
                String statusPagamento = rs.getString("status_pagamento");
                String categoria = rs.getString("categoria");
                long usuarioId = rs.getLong("usuario_id_usuario");

                // Add each record inside a Bootstrap card component
                out.println("<div class='col-md-4 mb-4'>");
                out.println("<div class='card h-100'>");
                out.println("<div class='card-body'>");
                out.println("<h5 class='card-title'>Descrição: " + descricao + "</h5>");
                out.println("<p class='card-text'><strong>Data Pagamento:</strong> " + dataPagamento + "</p>");
                out.println("<p class='card-text'><strong>Valor:</strong> R$" + valor + "</p>");
                out.println("<p class='card-text'><strong>Status Pagamento:</strong> " + statusPagamento + "</p>");
                out.println("<p class='card-text'><strong>Categoria:</strong> " + categoria + "</p>");
                out.println("<p class='card-text'><strong>ID Usuário:</strong> " + usuarioId + "</p>");
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
        System.out.println("post method");
    }

    public void destroy() {
    }
}