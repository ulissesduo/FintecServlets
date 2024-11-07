package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.DAO.DespesaDAO;
import br.com.fiap.fintech.Entities.Despesa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/insertDespesa")
public class DespesasTServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DespesaDAO dao = new DespesaDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        double valor = Double.parseDouble(request.getParameter("valor"));
        String categoria = request.getParameter("categoria");
        char statusPagamento = request.getParameter("statusPagamento").charAt(0);
        int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
        String dataPagamentoStr = request.getParameter("dataPagamento");
        Timestamp dataPagamento = Timestamp.valueOf(dataPagamentoStr + " 00:00:00");
        try {
            Despesa despesa = new Despesa(descricao,valor,dataPagamento,statusPagamento,categoria,usuarioId);
            dao.save(despesa);
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error inserting despesa: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");  // Get the 'acao' parameter

        if (acao == null || acao.equals("list")) {  // Default to list if 'acao' is null or "list"
            List<Despesa> despesaList = null;
            try {
                despesaList = dao.getAll();  // Fetch all despesas
                req.setAttribute("despesaList", despesaList);  // Set the list in request
                req.getRequestDispatcher("despesas.jsp").forward(req, resp);  // Forward to the list page
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ServletException("Error fetching despesas: " + e.getMessage());
            }
            return;  // Exit the method after listing
        }

        String codigo = req.getParameter("codigo");  // Get the 'codigo' parameter

        switch (acao) {
            case "abrir-form-edicao":
                // Edit form: fetch despesa by ID
                int id = Integer.parseInt(codigo);  // Parse 'codigo' (ID) to integer
                try {
                    Despesa despesa = dao.getById(id);  // Fetch the despesa by ID
                    req.setAttribute("despesa", despesa);  // Set the despesa attribute
                    req.getRequestDispatcher("updateDespesaForm.jsp").forward(req, resp);  // Forward to the update form
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new ServletException("Error fetching despesa for editing: " + e.getMessage());
                }
                break;
            case "deletar": // Delete case
                // Delete the despesa by ID
                int idDespesa = Integer.parseInt(codigo);  // Parse 'codigo' (ID) to integer
                try {
                    dao.deleteDespesa(idDespesa);  // Call the delete method from DAO
                    resp.sendRedirect("insertDespesa?acao=list");
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new ServletException("Error deleting despesa: " + e.getMessage());
                }
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action not recognized");  // Handle unknown actions
        }
    }

}