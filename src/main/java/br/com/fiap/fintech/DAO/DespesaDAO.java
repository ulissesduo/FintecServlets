package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.Despesa;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {

    public void save (Despesa despesa) throws SQLException {

        String sql = "INSERT INTO despesasT (descricao, valor, data_pagamento, status_pagamento, categoria, usuario_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionFactory.getConnection()){
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, despesa.getDescricao());
            statement.setDouble(2, despesa.getValor());
            statement.setTimestamp(3, despesa.getData_pagamento());
            statement.setString(4, String.valueOf(despesa.getStatus_pagamento()));
            statement.setString(5, despesa.getCategoria());
            statement.setInt(6, despesa.getUsuario_id());
            statement.executeUpdate();
        }
        catch(Exception e){
            throw new SQLException(e.getMessage());
        }
    }

    public List<Despesa> getAll() throws SQLException{
        List<Despesa> listDespesa = new ArrayList<>();
        String sql = "SELECT * FROM despesasT";
        Connection con = ConnectionFactory.getConnection();
        try{
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                int id = rs.getInt("id_despesa");
                String desc = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                Timestamp data_pagamento = rs.getTimestamp("data_pagamento");
                char status_pagamento = rs.getString("status_pagamento").charAt(0);
                String categoria = rs.getString("categoria");
                int usuario_id = rs.getInt("usuario_id");

                Despesa despesa = new Despesa(id,desc,valor,data_pagamento,status_pagamento,categoria,usuario_id);
                listDespesa.add(despesa);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listDespesa;
    }

    public Despesa getById(int id_despesa) throws SQLException {
        String sql = "SELECT * FROM despesasT WHERE id_despesa = ?";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        Despesa despesa = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_despesa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_despesa");
                String desc = rs.getString("descricao");
                double valor = rs.getDouble("valor");

                //fix the format of the date
                Timestamp data_pagamento = rs.getTimestamp("data_pagamento");

                char status_pagamento = rs.getString("status_pagamento").charAt(0);
                String categoria = rs.getString("categoria");
                int usuario_id = rs.getInt("usuario_id");

                despesa = new Despesa(desc, valor, data_pagamento, status_pagamento, categoria, usuario_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                stmt.close();
                //fechar conexao banco
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return despesa;
    }

    public void update (Despesa despesa) throws SQLException {
        PreparedStatement statement = null;
        try{
            Connection con = ConnectionFactory.getConnection();
            String sql = "UPDATE despesasT SET descricao = ?, valor = ?, data_pagamento = ?, status_pagamento = ?, categoria = ? WHERE id_despesa = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, despesa.getDescricao());
            statement.setDouble(2, despesa.getValor());
            statement.setTimestamp(3, despesa.getData_pagamento());
            statement.setString(4, String.valueOf(despesa.getStatus_pagamento()));
            statement.setString(5, despesa.getCategoria());
            statement.setInt(6, despesa.getUsuario_id());
            int rowsAffected = statement.executeUpdate();
            System.out.println("Update completed. Rows affected: " + rowsAffected);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                statement.close();
                //fechar conexao banco
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }


    public void deleteDespesa(int idDespesa) throws SQLException {
        String sql = "DELETE FROM despesasT WHERE id_despesa = ?";
        PreparedStatement stmt = null;
        try {
            Connection con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idDespesa);  // Set the despesa ID to delete
            stmt.executeUpdate();  // Execute the delete operation
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                stmt.close();
                //fechar conexao banco
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

}
