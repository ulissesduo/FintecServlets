package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.DAO.InvestmentFIAPDAO;
import br.com.fiap.fintech.Entities.InvestmentFIAP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/fiapInvestment")
public class FIAPInvestmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String description = req.getParameter("description");
        String type = req.getParameter("type");
        double amount = Double.parseDouble(req.getParameter("amount"));
        Timestamp date = new Timestamp(System.currentTimeMillis());
        long userId = Long.parseLong(req.getParameter("userId"));

        InvestmentFIAP investmentFIAP = new InvestmentFIAP();
        investmentFIAP.setAmount(amount);
        investmentFIAP.setDate(date);
        investmentFIAP.setDescription(description);
        investmentFIAP.setType(type);
        investmentFIAP.setUserId(userId); // Replace with a valid user ID

        InvestmentFIAPDAO dao = new InvestmentFIAPDAO();

        try {
            dao.save(investmentFIAP);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("/success.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<InvestmentFIAP> investmentFIAPList = new ArrayList<>();

        InvestmentFIAPDAO dao = new InvestmentFIAPDAO();
        try {
            investmentFIAPList = dao.getInvestmentFIAP();
            req.setAttribute("investmentFIAPList", investmentFIAPList);
            req.getRequestDispatcher("/success2.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
