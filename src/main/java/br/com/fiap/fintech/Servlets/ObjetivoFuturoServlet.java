package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.DAO.ObjetivoFuturoDAO;
import br.com.fiap.fintech.Entities.ObjetivoFuturo;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/insertObjetivoFuturo")
public class ObjetivoFuturoServlet extends HttpServlet {

    private final ObjetivoFuturoDAO objetivoFuturoDAO = new ObjetivoFuturoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao"); // Get the 'acao' parameter to determine what to do

        if (acao == null || acao.equals("list")) {
            List<ObjetivoFuturo> objFuturo = null;
            try {
                objFuturo = objetivoFuturoDAO.getAll(); // Fetch all Objetivos Futuros
                req.setAttribute("objFuturo", objFuturo); // Set the list in the request
                req.getRequestDispatcher("objetivofuturo.jsp").forward(req, resp); // Forward to the list page
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ServletException("Error fetching objetivos futuros: " + e.getMessage());
            }
        } else {
            String codigo = req.getParameter("codigo"); // Get the 'codigo' (ID) parameter

            switch (acao) {
                case "abrir-form-edicao":
                    Long id = Long.parseLong(codigo);
                    try {
                        ObjetivoFuturo objetivoFuturo = objetivoFuturoDAO.getById(id); // Get the specific ObjetivoFuturo by ID
                        req.setAttribute("objetivoFuturo", objetivoFuturo); // Set it as an attribute
                        req.getRequestDispatcher("updateObjetivoFuturoForm.jsp").forward(req, resp); // Forward to the edit form
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new ServletException("Error fetching objetivo futuro for editing: " + e.getMessage());
                    }
                    break;

                case "deletar":
                    int idDespesa = Integer.parseInt(codigo);
                    try {
                        objetivoFuturoDAO.deleteObjetivoFuturo(idDespesa); // Call the delete method from the DAO
                        resp.sendRedirect("insertObjetivoFuturo?acao=list"); // Redirect to the list page
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new ServletException("Error deleting objetivo futuro: " + e.getMessage());
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
            String descricao = req.getParameter("descricao");
            int quantidadeAlvo = Integer.parseInt(req.getParameter("quantidadeAlvo"));
            double valorAtual = Double.parseDouble(req.getParameter("valorAtual"));
            String tipo = req.getParameter("tipo");
            int usuarioIdUsuario = Integer.parseInt(req.getParameter("usuarioIdUsuario"));

            ObjetivoFuturo objetivoFuturo = new ObjetivoFuturo(descricao, quantidadeAlvo, valorAtual, tipo, usuarioIdUsuario);

            objetivoFuturoDAO.save(objetivoFuturo);

            doGet(req,resp);
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Error inserting objetivo futuro: " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}