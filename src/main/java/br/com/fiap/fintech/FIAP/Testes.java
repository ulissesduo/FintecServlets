package br.com.fiap.fintech.FIAP;

import br.com.fiap.fintech.DAO.DespesaDAO;
import br.com.fiap.fintech.Entities.Despesa;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Testes {
    public static void main(String[] args) throws SQLException {
        DespesaDAO despesaDAO = new DespesaDAO();

        // Step 1: Retrieve a Despesa object by ID (Assume we want to update the one with ID 31)
        int idToUpdate = 31;
        Despesa despesa = null;
        try {
            despesa = despesaDAO.getById(idToUpdate);  // Ensure this method is implemented
        } catch (SQLException e) {
            System.err.println("Failed to retrieve Despesa with ID " + idToUpdate);
            e.printStackTrace();
            return;
        }

        if (despesa != null) {
            System.out.println("Before update: " + despesa);

            // Step 2: Modify fields of the retrieved Despesa
            despesa.setDescricao("Updated Description");
            despesa.setValor(750.00);
            despesa.setData_pagamento(new Timestamp(System.currentTimeMillis()));
            despesa.setStatus_pagamento('P');
            despesa.setCategoria("Updated Category");

            // Step 3: Update the Despesa in the database
            try {
                despesaDAO.update(despesa);
            } catch (SQLException e) {
                System.err.println("Update failed for Despesa with ID " + idToUpdate);
                e.printStackTrace();
            }

            // Step 4: Retrieve the Despesa again to verify the update
            try {
                Despesa updatedDespesa = despesaDAO.getById(idToUpdate);
                System.out.println("After update: " + updatedDespesa);
            } catch (SQLException e) {
                System.err.println("Failed to retrieve updated Despesa with ID " + idToUpdate);
                e.printStackTrace();
            }
        } else {
            System.out.println("No Despesa found with ID " + idToUpdate + " to update.");
        }
    }
}
