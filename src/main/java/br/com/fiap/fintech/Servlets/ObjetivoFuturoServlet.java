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
        List<ObjetivoFuturo> objFuturo = null;
        try {
            objFuturo = objetivoFuturoDAO.getAll();
            req.setAttribute("objFuturo", objFuturo);
            req.getRequestDispatcher("objetivofuturo.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

            resp.sendRedirect("success.jsp");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Error inserting objetivo futuro: " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }


}
