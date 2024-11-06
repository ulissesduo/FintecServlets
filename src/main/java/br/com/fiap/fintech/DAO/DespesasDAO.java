package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.Despesas;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DespesasDAO {
// NAO SERVE MAIS PRA NADA ISSO AQUI
    public void insertDespesa(Despesas despesa) {
        String sql = "INSERT INTO despesas (id_despesa, descricao, data_pagamento, valor, status_pagamento, categoria, usuario_id_usuario) " +
                "VALUES (despesas_seq.nextval, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, despesa.getDescricao());
            stmt.setDate(2, new java.sql.Date(despesa.getDataPagamento().getTime()));
            stmt.setDouble(3, despesa.getValor());
            stmt.setBoolean(4, despesa.getStatusPagamento());
            stmt.setString(5, despesa.getCategoria());
            stmt.setLong(6, despesa.getUsuarioId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error inserting despesa: " + e.getMessage());
        }
    }
}