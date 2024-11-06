package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.DAO.DespesaDAO;
import br.com.fiap.fintech.DAO.GastosRecorrentesDAO;
import br.com.fiap.fintech.Entities.Despesa;
import br.com.fiap.fintech.Entities.GastosRecorrentes;
import br.com.fiap.fintech.Factory.ConnectionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet("/insertGastosRecorrentes")
public class GastosRecorrentesServlet extends HttpServlet {

    private GastosRecorrentesDAO gastosRecorrentesDAO = new GastosRecorrentesDAO();
    private DespesaDAO despesaDAO = new DespesaDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the form data
        String descricao = request.getParameter("descricao");
        double valor = Double.parseDouble(request.getParameter("valor"));
        String dataPagamentoStr = request.getParameter("dataPagamento"); // Format: yyyy-MM-dd'T'HH:mm
        Timestamp dataPagamento = Timestamp.valueOf(dataPagamentoStr + " 00:00:00");
        char statusPagamento = request.getParameter("statusPagamento").charAt(0);
        String categoria = request.getParameter("categoria");
        int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
        String endDateStr = request.getParameter("endDate");
        Timestamp endDate = Timestamp.valueOf(endDateStr + " 00:00:00");

        String nextPaymentDateStr = request.getParameter("nextPaymentDate");
        Timestamp nextPaymentDate = Timestamp.valueOf(nextPaymentDateStr + " 00:00:00");

        int autoPay = Integer.parseInt(request.getParameter("autoPay"));
        String recurringNote = request.getParameter("recurringNote");
        int isCanceled = Integer.parseInt(request.getParameter("isCanceled"));
        String frequencia = request.getParameter("frequencia");

        try {
            Despesa despesa = new Despesa(descricao, valor, dataPagamento, statusPagamento, categoria, usuarioId);
            despesaDAO.save(despesa);
            // Create a new GastosRecorrentes object (assume you have a corresponding class)
            GastosRecorrentes gastosRecorrentes = new GastosRecorrentes(descricao, valor,dataPagamento, statusPagamento, categoria,usuarioId,endDate, nextPaymentDate, autoPay, recurringNote, isCanceled, frequencia );

            gastosRecorrentesDAO.insertGastosRecorrentes(gastosRecorrentes);
            // Here, save the gastosRecorrentes object to the database using your service/repository
            // Example: gastosRecorrentesService.save(gastosRecorrentes);

            // Redirect or forward to a success page
            response.sendRedirect("successPage.jsp");
        } catch (IllegalArgumentException e) {
            // Handle parsing errors
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}