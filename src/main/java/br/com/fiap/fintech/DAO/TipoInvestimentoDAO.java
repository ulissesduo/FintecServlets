package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.TipoInvestimento;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoInvestimentoDAO {
    private Connection connection;

    public TipoInvestimentoDAO(Connection connection) {
        this.connection = connection;
    }

    public List<TipoInvestimento> getAllTiposInvestimento() throws SQLException {
        List<TipoInvestimento> tiposInvestimento = new ArrayList<>();
        String sql = "SELECT * FROM tipos_investimentos";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TipoInvestimento tipoInvestimento = new TipoInvestimento();
                tipoInvestimento.setId(rs.getLong("ID"));
                tipoInvestimento.setDescription(rs.getString("DESCRIPTION"));
                tiposInvestimento.add(tipoInvestimento);
            }
        }
        return tiposInvestimento;
    }
}
