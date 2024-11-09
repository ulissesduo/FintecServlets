package br.com.fiap.fintech.Factory;


import br.com.fiap.fintech.DAO.UsuarioDAO;

public class DaoFactory {

    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO();
    }

}