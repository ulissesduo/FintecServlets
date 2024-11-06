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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
@WebServlet("/investimentos")
public class InvestimentoServlet extends HttpServlet {
    private InvestimentoDAO investimentoDAO;
    private TipoInvestimentoDAO tipoInvestimentoDAO;

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = ConnectionFactory.getConnection();
            investimentoDAO = new InvestimentoDAO();
            tipoInvestimentoDAO = new TipoInvestimentoDAO(connection);
        } catch (SQLException e) {
            throw new ServletException("Database connection failed", e);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Investimento> investimentos = investimentoDAO.getAllInvestimentos();
            List<TipoInvestimento> tiposInvestimento = tipoInvestimentoDAO.getAllTiposInvestimento();
            req.setAttribute("investimentos", investimentos);
            req.setAttribute("tiposInvestimento", tiposInvestimento);
            req.getRequestDispatcher("investimentos-listagem.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long tipoInvestimento = Long.valueOf(req.getParameter("tipoInvestimento"));
            Double valorInvestido = Double.valueOf(req.getParameter("valorInvestido"));
            Timestamp dataInicio = Timestamp.valueOf(req.getParameter("dataInicio"));
            Timestamp dataResgate = Timestamp.valueOf(req.getParameter("dataResgate"));
            Long usuarioId = Long.valueOf(req.getParameter("usuarioId"));

            Investimento investimento = new Investimento();
            investimento.setTipoInvestimento(tipoInvestimento);
            investimento.setValorInvestido(valorInvestido);
            investimento.setDataInicio(dataInicio);
            investimento.setDataResgate(dataResgate);
            investimento.setUsuarioId(usuarioId);

            investimentoDAO.addInvestimento(investimento);
            resp.sendRedirect(req.getContextPath() + "/investimentos");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}