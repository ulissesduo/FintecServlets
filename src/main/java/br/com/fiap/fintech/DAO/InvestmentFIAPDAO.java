package br.com.fiap.fintech.DAO;

import br.com.fiap.fintech.Entities.InvestmentFIAP;
import br.com.fiap.fintech.Factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestmentFIAPDAO {

    public List<InvestmentFIAP> getInvestmentFIAP() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM FIAPInvestment";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            List<InvestmentFIAP> investmentFIAPs = new ArrayList<>();

            // Debugging output to check how many rows are returned
            int rowCount = 0;
            while (rs.next()) {
                InvestmentFIAP investmentFIAP = new InvestmentFIAP();
                investmentFIAP.setInvestmentID(rs.getInt("ID_FIAP")); // Use actual column name
                investmentFIAP.setDescription(rs.getString("Investment_Description")); // Use actual column name
                investmentFIAP.setAmount(rs.getDouble("Investment_Amount")); // Use actual column name
                investmentFIAP.setType(rs.getString("Investment_Type")); // Use actual column name
                investmentFIAP.setDate(rs.getTimestamp("Investment_Date")); // Use actual column name
                investmentFIAP.setUserId(rs.getLong("User_ID")); // Use actual column name

                investmentFIAPs.add(investmentFIAP);
                rowCount++;
            }

            System.out.println("Number of rows returned: " + rowCount); // Debugging line
            return investmentFIAPs; // Return the populated list

        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception after logging it
        } finally {
            try {
                if (rs != null) rs.close(); // Close ResultSet if not null
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                throw new SQLException(e);
            }
        }
    }


    public void save(InvestmentFIAP investmentFIAP) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        // Updated SQL to use sequence for ID_FIAP
        String sql = "INSERT INTO FIAPInvestment (ID_FIAP, Investment_Description, Investment_Type, Investment_Amount, Investment_Date, User_ID) " +
                "VALUES (FIAPInvestment_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, investmentFIAP.getDescription());
            stmt.setString(2, investmentFIAP.getType());
            stmt.setDouble(3, investmentFIAP.getAmount());
            stmt.setTimestamp(4, new Timestamp(investmentFIAP.getDate().getTime()));
            stmt.setLong(5, investmentFIAP.getUserId() != null ? investmentFIAP.getUserId() : 0L); // Handle null UserId gracefully

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                throw new SQLException();
            }
        }
    }
}
