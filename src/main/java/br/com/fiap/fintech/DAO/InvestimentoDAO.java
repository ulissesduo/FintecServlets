package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.Investimento;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO {


    public List<Investimento> getAllInvestimentos() throws SQLException {
        List<Investimento> investimentos = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM investimentost";
        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Investimento investimento = new Investimento();
                investimento.setIdInvestimento(rs.getLong("ID_INVESTIMENTO"));
                investimento.setTipoInvestimento(rs.getLong("TIPO_INVESTIMENTO"));
                investimento.setValorInvestido(rs.getDouble("VALOR_INVESTIDO"));
                investimento.setDataInicio(rs.getTimestamp("DATA_INICIO"));
                investimento.setDataResgate(rs.getTimestamp("DATA_RESGATE"));
                investimento.setUsuarioId(rs.getLong("USUARIO_ID"));

                investimentos.add(investimento);
            }
        }
        return investimentos;
    }

    public void addInvestimento(Investimento investimento) throws SQLException {
        String sql = "INSERT INTO investimentost (TIPO_INVESTIMENTO, VALOR_INVESTIDO, DATA_INICIO, DATA_RESGATE, USUARIO_ID) VALUES (?, ?, ?, ?, ?)";
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {//
            stmt.setLong(1, investimento.getTipoInvestimento());
            stmt.setDouble(2, investimento.getValorInvestido());
            stmt.setTimestamp(3, investimento.getDataInicio());
            stmt.setTimestamp(4, investimento.getDataResgate());
            stmt.setLong(5, investimento.getUsuarioId());
            stmt.executeUpdate();
        }
    }

    public void updateInvestimento(Investimento investimento) throws SQLException {
        String sql = "UPDATE investimentos SET tipo_investimento = ?, valor_investido = ?, data_inicio = ?, data_resgate = ? WHERE id = ?";
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, investimento.getTipoInvestimento());
            stmt.setDouble(2, investimento.getValorInvestido());
            stmt.setTimestamp(3, investimento.getDataInicio());
            stmt.setTimestamp(4, investimento.getDataResgate());
            stmt.setLong(5, investimento.getUsuarioId()); // Use the investment ID for the WHERE clause
            stmt.executeUpdate();
        }
    }

    public void deleteInvestimento(Long id) throws SQLException {
        String sql = "DELETE FROM investimentos WHERE id = ?";
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

}

