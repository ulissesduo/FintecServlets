package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.Expenses;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpensesDAO {

    private Connection con;

    public ExpensesDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

    public List<Expenses> getAll(long id) throws SQLException{
        String sql = "SELECT * FROM DESPESAS WHERE USUARIO_ID_USUARIO = ?";
        List<Expenses> listInvestments = new ArrayList<>();

        try (PreparedStatement stm = con.prepareStatement(sql)){
            stm.setLong(1, id);
            ResultSet result = stm.executeQuery();
            while(result.next()){
                Long idExpense = result.getLong("ID_DESPESA");
                String description = result.getNString("DESCRICAO");
                Date paymentDate = result.getDate("DATA_PAGAMENTO");
                double values = result.getDouble("VALOR");
                Boolean statusPayment = result.getBoolean("STATUS_PAGAMENTO");
                long userId = result.getLong("USUARIO_ID_USUARIO");
                String category = result.getString("CATEGORIA");

                Expenses expense = new Expenses(idExpense, description, paymentDate,values, statusPayment, category,userId);
                listInvestments.add(expense);

            }
        }
        catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return listInvestments;
    }

    public void createExpense(Expenses exp) throws SQLException {
        String sql = "INSERT INTO DESPESAS ( DESCRICAO, DATA_PAGAMENTO, VALOR, STATUS_PAGAMENTO, CATEGORIA, USUARIO_ID_USUARIO,ID_DESPESA) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, exp.getDescription());

            // Convert java.util.Date to java.sql.Date if needed
            if (exp.getPayment_date() != null) {
                stm.setDate(2, new java.sql.Date(exp.getPayment_date().getTime()));
            } else {
                stm.setNull(2, java.sql.Types.DATE);
            }

            stm.setDouble(3, exp.getValues());
            stm.setBoolean(4, exp.getStatusPayment());
            stm.setString(5, exp.getCategory());
            stm.setLong(6, exp.getUserId());
            stm.setLong(7, exp.getId());

            stm.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con);
        }
    }
}
