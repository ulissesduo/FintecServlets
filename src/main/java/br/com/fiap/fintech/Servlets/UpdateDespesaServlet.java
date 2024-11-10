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

@WebServlet("/updateDespesa")
public class UpdateDespesaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DespesaDAO dao = new DespesaDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id_despesa"));
            String descricao = request.getParameter("descricao");
            double valor = Double.parseDouble(request.getParameter("valor"));
            String categoria = request.getParameter("categoria");
            char statusPagamento = request.getParameter("status_pagamento").charAt(0);
            int usuarioId = Integer.parseInt(request.getParameter("usuario_id"));
            String dataPagamentoStr = request.getParameter("dataPagamento");
            Timestamp dataPagamento = Timestamp.valueOf(dataPagamentoStr + " 00:00:00");

            Despesa despesa = new Despesa(descricao, valor, dataPagamento, statusPagamento, categoria, usuarioId);
            despesa.setId_despesa(id);

            System.out.println("Updating Despesa with ID: " + id); // Debug
            dao.update(despesa);

            System.out.println("Update successful, redirecting...");
            response.sendRedirect("insertDespesa?acao=list");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error updating despesa: " + e.getMessage());
        }
    }

}