package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.Investimento;
import br.com.fiap.fintech.Entities.InvestimentoT;
import br.com.fiap.fintech.Entities.TipoInvestimento;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoTDAO {

    public List<TipoInvestimento> getAllInvestmentTypes() throws SQLException {
        List<TipoInvestimento> types = new ArrayList<>();
        String sql = "SELECT id, type_name FROM investment_type";
        try (Connection con = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                types.add(new TipoInvestimento((long) rs.getInt("id"), rs.getString("type_name")));
            }
        }
        return types;
    }

    public void save(InvestimentoT investimento) throws SQLException {
        String sql = "INSERT INTO investimentosT (tipo_investimento_id, valor_investido, data_inicio, data_resgate, usuario_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, investimento.getInvestmentTypeId());
            stmt.setDouble(2, investimento.getValorInvestido());
            stmt.setTimestamp(3, investimento.getDataInicio());
            stmt.setTimestamp(4, investimento.getDataResgate());
            stmt.setInt(5, investimento.getUsuarioId());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    investimento.setIdInvestimento(generatedKeys.getInt(1));
                }
            }
        }
    }
}
