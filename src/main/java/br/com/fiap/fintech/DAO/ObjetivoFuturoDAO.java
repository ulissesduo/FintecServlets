package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.ObjetivoFuturo;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjetivoFuturoDAO {
    public void save(ObjetivoFuturo objetivoFuturo) throws SQLException {
        String sql = "INSERT INTO objetivos_futurosT (descricao, quantidade_alvo, valor_atual, tipo, usuario_id_usuario) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setString(1, objetivoFuturo.getDescricao());
            statement.setInt(2, objetivoFuturo.getQuantidadeAlvo());
            statement.setDouble(3, objetivoFuturo.getValorAtual());
            statement.setString(4, objetivoFuturo.getTipo());
            statement.setInt(5, objetivoFuturo.getUsuarioIdUsuario());

            statement.executeUpdate();
        }
    }

    public List<ObjetivoFuturo> getAll() throws SQLException {
        List<ObjetivoFuturo> objFuturo = new ArrayList<>();
        String sql = "SELECT * FROM objetivos_futurosT";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id_objetivo");
                String descricao = rs.getString("descricao");
                int quantidadeAlvo = rs.getInt("quantidade_alvo");
                double valorAtual = rs.getDouble("valor_atual");
                String tipo = rs.getString("tipo");
                int usuarioIdUsuario = rs.getInt("usuario_id_usuario");
                ObjetivoFuturo of = new ObjetivoFuturo(id,descricao,quantidadeAlvo,valorAtual,tipo,usuarioIdUsuario);
                objFuturo.add(of);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return objFuturo;
    }

}
