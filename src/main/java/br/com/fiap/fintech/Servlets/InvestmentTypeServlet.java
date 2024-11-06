package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.DAO.TipoInvestimentoDAO;

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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/addInvestmentType")
public class InvestmentTypeServlet extends HttpServlet {
//    TipoInvestimentoDAO dao = new TipoInvestimentoDAO();
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<TipoInvestimento> listInvestmentType = null;
//        try{
//            listInvestmentType = dao.getAllTiposInvestimento();
//            req.setAttribute("listInvestmentType", listInvestmentType);
//            req.getRequestDispatcher("investmenttype.jsp").forward(req, resp);
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String description = req.getParameter("description");
//
//        TipoInvestimento investmentType = new TipoInvestimento(null, description);
//
//        try (Connection conn = ConnectionFactory.getConnection()) {
//            String sql = "INSERT INTO tipos_investimentos (ID, Description) VALUES (tipos_investimentos_seq.nextval, ?)";
//            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//                stmt.setString(1, investmentType.getDescription());
//                int rowsInserted = stmt.executeUpdate();
//
//                PrintWriter writer = resp.getWriter();
//                if (rowsInserted > 0) {
//                    writer.println("<html><body>Investment type '" + description + "' added successfully!</body></html>");
//                } else {
//                    writer.println("<html><body>Failed to add investment type.</body></html>");
//                }
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            resp.getWriter().println("<html><body>Error: Could not save investment type. " + e.getMessage() + "</body></html>");
//        }
//    }
}
