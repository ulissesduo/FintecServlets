package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.DAO.InvestimentoDAO;
import br.com.fiap.fintech.DAO.TipoInvestimentoDAO;
import br.com.fiap.fintech.Entities.Investimento;
import br.com.fiap.fintech.Entities.TipoInvestimento;
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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/investimentos")
public class InvestimentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private InvestimentoDAO investimentoDAO;

    public void init() {
        investimentoDAO = new InvestimentoDAO();  // Initialize DAO
    }

    // Handle GET for listing investments
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Investimento> investimentos = null;
        try {
            investimentos = investimentoDAO.getAllInvestimentos();  // Fetch all investments
        } catch (SQLException e) {
            throw new ServletException("Error fetching investments", e);
        }
        request.setAttribute("investimentos", investimentos);  // Set the list of investments in request
        request.getRequestDispatcher("/listInvestimentos.jsp").forward(request, response);  // Forward to the list page
    }

//    // Handle POST for inserting new investment
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // Retrieve form data for new investment
//        Long tipoInvestimento = Long.valueOf(request.getParameter("tipoInvestimento"));
//        double valorInvestido = Double.parseDouble(request.getParameter("valorInvestido"));
//
//        String dataIniciostr = request.getParameter("dataInicio");
//        java.sql.Timestamp dataInicio = java.sql.Timestamp.valueOf(dataIniciostr + " 00:00:00");
//
//        String dataResgatestr = request.getParameter("dataResgate");
//        java.sql.Timestamp dataResgate = java.sql.Timestamp.valueOf(dataResgatestr + " 00:00:00");
//
//        Long usuarioId = Long.parseLong(request.getParameter("usuarioId"));
//
//        Investimento investimento = new Investimento(tipoInvestimento, valorInvestido, dataInicio, dataResgate, usuarioId);
//        try {
//            investimentoDAO.addInvestimento(investimento);  // Add the new investment to the database
//        } catch (SQLException e) {
//            throw new ServletException("Error inserting investment", e);
//        }
//        response.sendRedirect("investimentos");  // Redirect to the list of investments after insertion
//    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Retrieve form data
            Long tipoInvestimento = Long.parseLong(req.getParameter("tipoInvestimento"));
            String tipoDescricao = req.getParameter("tipoDescricao"); // Assuming this field in form as hidden/input
            double valorInvestido = Double.parseDouble(req.getParameter("valor"));
            Timestamp dataInicio = Timestamp.valueOf(req.getParameter("dataInicio") + " 00:00:00");
            Timestamp dataResgate = Timestamp.valueOf(req.getParameter("dataResgate") + " 00:00:00");
            Long usuarioId = Long.parseLong(req.getParameter("usuarioId"));

            // Create the Investimento object
            Investimento investimento = new Investimento(null, tipoInvestimento, tipoDescricao, valorInvestido, dataInicio, dataResgate, usuarioId);

            // Call DAO to add investment
            investimentoDAO.addInvestimento(investimento);

            // Provide feedback to the user
            PrintWriter writer = resp.getWriter();
            writer.println("<html><body>Investment added successfully!</body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().println("<html><body>Error: Could not save investment. " + e.getMessage() + "</body></html>");
        }
    }
}