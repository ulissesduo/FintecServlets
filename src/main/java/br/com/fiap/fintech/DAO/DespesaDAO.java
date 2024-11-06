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

                Despesa despesa = new Despesa(desc,valor,data_pagamento,status_pagamento,categoria,usuario_id);
                listDespesa.add(despesa);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listDespesa;
    }
}
