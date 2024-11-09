package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.Investimento;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO {


//    public List<Investimento> getAllInvestimentos() throws SQLException {
//        List<Investimento> investimentos = new ArrayList<>();
//        Connection con = ConnectionFactory.getConnection();
//        String sql = "SELECT * FROM investimentosT";
//        try (PreparedStatement stmt = con.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                Investimento investimento = new Investimento();
//                investimento.setIdInvestimento(rs.getLong("ID_INVESTIMENTO"));
//                investimento.setTipoInvestimento(rs.getLong("TIPO_INVESTIMENTO"));
//                investimento.setValorInvestido(rs.getDouble("VALOR_INVESTIDO"));
//                investimento.setDataInicio(rs.getTimestamp("DATA_INICIO"));
//                investimento.setDataResgate(rs.getTimestamp("DATA_RESGATE"));
//                investimento.setUsuarioId(rs.getLong("USUARIO_ID"));
//
//                investimentos.add(investimento);
//            }
//        }
//        return investimentos;
//    }


    public List<Investimento> getAllInvestimentos() throws SQLException {
        List<Investimento> investimentos = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT i.ID_INVESTIMENTO, t.DESCRIPTION AS tipoDescricao, i.VALOR_INVESTIDO, " +
                "i.DATA_INICIO, i.DATA_RESGATE, i.USUARIO_ID " +
                "FROM investimentosT i " +
                "INNER JOIN tipos_investimentos t ON i.TIPO_INVESTIMENTO = t.ID";
        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Investimento investimento = new Investimento();
                investimento.setIdInvestimento(rs.getLong("ID_INVESTIMENTO"));
                investimento.setTipoDescricao(rs.getString("tipoDescricao"));  // Set description here
                investimento.setValorInvestido(rs.getDouble("VALOR_INVESTIDO"));
                investimento.setDataInicio(rs.getTimestamp("DATA_INICIO"));
                investimento.setDataResgate(rs.getTimestamp("DATA_RESGATE"));
                investimento.setUsuarioId(rs.getLong("USUARIO_ID"));

                investimentos.add(investimento);
            }
        }
        return investimentos;
    }


    // Get a single Investimento by ID
    public Investimento getById(Long id) throws SQLException {
        String sql = "SELECT * FROM INVESTIMENTOST WHERE ID = ?";
        Connection con = ConnectionFactory.getConnection();

        Investimento investimento = null;
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    investimento = new Investimento();
                    investimento.setIdInvestimento(rs.getLong("ID"));
                    investimento.setTipoInvestimento(rs.getLong("TIPO_INVESTIMENTO"));
                    investimento.setValorInvestido(rs.getDouble("VALOR_INVESTIDO"));
                    investimento.setDataInicio(rs.getTimestamp("DATA_INICIO"));
                    investimento.setDataResgate(rs.getTimestamp("DATA_RESGATE"));
                    investimento.setUsuarioId(rs.getLong("USUARIO_ID"));
                }
            }
        }
        return investimento;
    }

//    public void addInvestimento(Investimento investimento) throws SQLException {
//        String sql = "INSERT INTO investimentosT (TIPO_INVESTIMENTO, VALOR_INVESTIDO, DATA_INICIO, DATA_RESGATE, USUARIO_ID) VALUES (?, ?, ?, ?, ?)";
//        Connection con = ConnectionFactory.getConnection();
//
//        try (PreparedStatement stmt = con.prepareStatement(sql)) {//
//            stmt.setLong(1, investimento.getTipoInvestimento());
//            stmt.setDouble(2, investimento.getValorInvestido());
//            stmt.setTimestamp(3, investimento.getDataInicio());
//            stmt.setTimestamp(4, investimento.getDataResgate());
//            stmt.setLong(5, investimento.getUsuarioId());
//            stmt.executeUpdate();
//        }
//    }


    public void addInvestimento(Investimento investimento) throws SQLException {
        String sql = "INSERT INTO investimentosT (TIPO_INVESTIMENTO, VALOR_INVESTIDO, DATA_INICIO, DATA_RESGATE, USUARIO_ID) VALUES (?, ?, ?, ?, ?)";
        Connection con = ConnectionFactory.getConnection();

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, investimento.getTipoInvestimento());
            stmt.setDouble(2, investimento.getValorInvestido());
            stmt.setTimestamp(3, investimento.getDataInicio());
            stmt.setTimestamp(4, investimento.getDataResgate());
            stmt.setLong(5, investimento.getUsuarioId());
            stmt.executeUpdate();
        }
    }


    public void updateInvestimento(Investimento investimento) throws SQLException {
        String sql = "UPDATE investimentosT SET tipo_investimento = ?, valor_investido = ?, data_inicio = ?, data_resgate = ? WHERE id = ?";
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

    public void deleteInvestimento(int id) throws SQLException {
        String sql = "DELETE FROM investimentosT WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            Connection con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
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
    }

}

