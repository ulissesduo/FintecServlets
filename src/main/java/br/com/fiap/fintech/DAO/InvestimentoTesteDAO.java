package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.InvestimentoTeste;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoTesteDAO {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String DB_USER = "RM556204";
    private static final String DB_PASSWORD = "201097";

    public List<InvestimentoTeste> getAllInvestimentos() {
        List<InvestimentoTeste> investimentos = new ArrayList<>();

        String sql = "SELECT id, valor FROM investimento_teste";

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();


            // Loop through the result set and print each row as a card
            while (rs.next()) {
                long id = rs.getLong("id");
                double valor = rs.getDouble("valor");
                System.out.println(id);
                System.out.println(valor);


            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return investimentos;
    }
}