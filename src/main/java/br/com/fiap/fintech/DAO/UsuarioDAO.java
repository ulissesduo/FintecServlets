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
}