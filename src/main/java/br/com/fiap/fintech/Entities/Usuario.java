package br.com.fiap.fintech.Entities;

import br.com.fiap.fintech.Util.CriptografiaUtils;
import java.time.LocalDate;

public class Usuario {

    private String senha;
    private String email;

    // Constructors
    public Usuario(String email, String senha) {
        this.email = email;
        setSenha(senha);
    }

    public Usuario() {}



    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        try {
            this.senha = CriptografiaUtils.criptografar(senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    // Optional toString() for easier debugging
    @Override
    public String toString() {
        return "Usuario{" +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
