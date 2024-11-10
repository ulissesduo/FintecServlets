package br.com.fiap.fintech.DAO;
import br.com.fiap.fintech.Entities.ObjetivoFuturo;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static br.com.fiap.fintech.Factory.ConnectionFactory.closeConnection;

public class ObjetivoFuturoDAO {
    public void save(ObjetivoFuturo objetivoFuturo) throws SQLException {
        String sql = "INSERT INTO objetivos_futurosT (descricao, quantidade_alvo, valor_atual, tipo, usuario_id_usuario) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, objetivoFuturo.getDescricao());
            statement.setInt(2, objetivoFuturo.getQuantidadeAlvo());
            statement.setDouble(3, objetivoFuturo.getValorAtual());
            statement.setString(4, objetivoFuturo.getTipo());
            statement.setInt(5, objetivoFuturo.getUsuarioIdUsuario());

            statement.executeUpdate();
        }catch(Exception e){
            throw new SQLException(e.getMessage());
        } finally {
            if (statement != null) statement.close();
            closeConnection(con);
        }
    }

    public List<ObjetivoFuturo> getAll() throws SQLException {
        List<ObjetivoFuturo> objFuturo = new ArrayList<>();
        String sql = "SELECT * FROM objetivos_futurosT";
        Connection con = null;
        PreparedStatement statement = null;
        try{
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);
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
        } finally {
            if (statement != null) statement.close();
            closeConnection(con);
        }
        return objFuturo;
    }

    public ObjetivoFuturo getById(Long idObjetivo) throws SQLException {
        String sql = "SELECT * FROM objetivos_futurosT WHERE id_objetivo = ?";
        ObjetivoFuturo objFut = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, idObjetivo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    Long id = rs.getLong("id_objetivo");
                    String descricao = rs.getString("descricao");
                    int qtdAlvo = rs.getInt("quantidade_alvo");
                    double valorAtual = rs.getDouble("valor_atual");
                    String tipo = rs.getString("tipo");
                    int usuarioIdUsuario = rs.getInt("usuario_id_usuario");

                    objFut = new ObjetivoFuturo(id, descricao, qtdAlvo, valorAtual, tipo, usuarioIdUsuario);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            if (stmt != null) stmt.close();
            closeConnection(con);
        }

        return objFut;
    }


    public void update(ObjetivoFuturo objFut) throws SQLException {
        String sql = "UPDATE objetivos_futurosT SET descricao = ?, quantidade_alvo = ?, valor_atual = ?, tipo = ?, usuario_id_usuario = ? WHERE id_objetivo = ?";
        PreparedStatement statement = null;
        Connection con =null;
        try {
            con = ConnectionFactory.getConnection();
            statement = con.prepareStatement(sql);

            statement.setString(1, objFut.getDescricao());
            statement.setInt(2, objFut.getQuantidadeAlvo());
            statement.setDouble(3, objFut.getValorAtual());
            statement.setString(4, objFut.getTipo());
            statement.setInt(5, objFut.getUsuarioIdUsuario());
            statement.setLong(6, objFut.getUsuarioIdUsuario());  // Assuming you have an 'id' method in ObjetivoFuturo
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if (statement != null) statement.close();
            closeConnection(con);
        }
    }
    public void deleteObjetivoFuturo(int idObjetivoFuturo) throws SQLException {
        String sql = "DELETE FROM objetivos_futurosT WHERE id_objetivo = ?";
        PreparedStatement stmt = null;
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idObjetivoFuturo);
            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if (stmt != null) stmt.close();
            closeConnection(con);
        }
    }
}
