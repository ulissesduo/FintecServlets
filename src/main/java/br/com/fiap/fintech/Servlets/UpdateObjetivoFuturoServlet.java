package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.DAO.ObjetivoFuturoDAO;
import br.com.fiap.fintech.Entities.ObjetivoFuturo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateObjetivoFuturo")
public class UpdateObjetivoFuturoServlet extends HttpServlet {

    private final ObjetivoFuturoDAO objetivoFuturoDAO = new ObjetivoFuturoDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Retrieve parameters from the request
            Long idObjetivo = Long.parseLong(req.getParameter("idObjetivo"));
            String descricao = req.getParameter("descricao");
            int quantidadeAlvo = Integer.parseInt(req.getParameter("quantidadeAlvo"));
            double valorAtual = Double.parseDouble(req.getParameter("valorAtual"));
            String tipo = req.getParameter("tipo");
            int usuarioIdUsuario = Integer.parseInt(req.getParameter("usuarioIdUsuario"));

            // Create an updated ObjetivoFuturo object
            ObjetivoFuturo objetivoFuturo = new ObjetivoFuturo(idObjetivo, descricao, quantidadeAlvo, valorAtual, tipo, usuarioIdUsuario);

            // Update the record in the database
            objetivoFuturoDAO.update(objetivoFuturo);

            // Redirect to the list page after successful update
            resp.sendRedirect("insertObjetivoFuturo?acao=list");

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Error updating objetivo futuro: " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
