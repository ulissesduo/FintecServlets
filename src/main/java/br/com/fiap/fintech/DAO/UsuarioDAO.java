package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.Usuario;

import br.com.fiap.fintech.Factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO  {

    private Connection conexao;


    public boolean validarUsuario(Usuario usuario) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = ConnectionFactory.getConnection();

            String sql = "SELECT * FROM TB_USUARIO " +
                    "WHERE DS_EMAIL = ? AND DS_SENHA = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            rs = stmt.executeQuery();

            if (rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO();
    }
    public void inserirUsuario(Usuario usuario) throws SQLException {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_USUARIO (DS_EMAIL, DS_SENHA) VALUES (?, ?)";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) stmt.close();
            if (conexao != null) conexao.close();
        }
    }


    public boolean atualizarUsuario(String emailAntigo, Usuario usuarioAtualizado) {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionFactory.getConnection();
            String sql = "UPDATE TB_USUARIO SET DS_EMAIL = ?, DS_SENHA = ? WHERE DS_EMAIL = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuarioAtualizado.getEmail());
            stmt.setString(2, usuarioAtualizado.getSenha());
            stmt.setString(3, emailAntigo);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}