package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.DAO.InvestimentoDAO;
import br.com.fiap.fintech.Entities.Investimento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static java.sql.Timestamp.valueOf;

@WebServlet("/investimentos")
public class InvestimentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InvestimentoDAO investimentoDAO;

    public void init() {
        investimentoDAO = new InvestimentoDAO();  // Initialize DAO
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao"); // Get the 'acao' parameter to determine the action

        if ("list".equals(acao) || acao == null) {
            // List all investments
            try {
                List<Investimento> investimentos = investimentoDAO.getAllInvestimentos(); // Fetch all investments
                req.setAttribute("investimentos", investimentos); // Set investments in request
                req.getRequestDispatcher("listInvestimentos.jsp").forward(req, resp); // Forward to investments page
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ServletException("Error fetching investments: " + e.getMessage());
            }
        } else {
            String codigo = req.getParameter("codigo"); // Get the 'codigo' (ID) parameter

            switch (acao) {
                case "abrir-form-edicao":
                    // Open edit form for specific investment
                    Long id = Long.parseLong(codigo);
                    try {
                        Investimento investimento = investimentoDAO.getById(id); // Fetch specific investment
                        req.setAttribute("investimento", investimento);
                        req.getRequestDispatcher("updateInvestimentoForm.jsp").forward(req, resp); // Forward to the edit form
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new ServletException("Error fetching investment for editing: " + e.getMessage());
                    }
                    break;

                case "deletar":
                    // Delete investment
                    int idInvestimento = Integer.parseInt(codigo);
                    try {
                        investimentoDAO.deleteInvestimento(idInvestimento); // Delete from the database
                        resp.sendRedirect("investimentos?acao=list"); // Redirect to the list page
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new ServletException("Error deleting investment: " + e.getMessage());
                    }
                    break;

                default:
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action not recognized");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Extract form parameters
            Long tipoInvestimento = Long.parseLong(req.getParameter("tipoInvestimento"));
            String tipoDescricao = req.getParameter("tipoDescricao"); // Assuming this field in form as hidden/input
            double valorInvestido = Double.parseDouble(req.getParameter("valor"));
            Timestamp dataInicio = Timestamp.valueOf(req.getParameter("dataInicio") + " 00:00:00");
            Timestamp dataResgate = Timestamp.valueOf(req.getParameter("dataResgate") + " 00:00:00");
            Long usuarioId = Long.parseLong(req.getParameter("usuarioId"));

            // Create the Investimento object
            Investimento investimento = new Investimento(null, tipoInvestimento, tipoDescricao, valorInvestido, dataInicio, dataResgate, usuarioId);

            // Call DAO to either insert or update the investimento
            if (req.getParameter("idInvestimento") == null || req.getParameter("idInvestimento").isEmpty()) {
                investimentoDAO.addInvestimento(investimento);  // Insert
            } else {
                investimentoDAO.updateInvestimento(investimento);  // Update
            }

            doGet(req, resp);

        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Error processing investment: " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }


}
