package br.com.fiap.fintech.Entities;

public class ObjetivoFuturo {

    private Long idObjetivo;
    private String descricao;
    private int quantidadeAlvo;
    private double valorAtual;
    private String tipo;
    private int usuarioIdUsuario;

    // Constructor


    public ObjetivoFuturo(Long idObjetivo, String descricao, int quantidadeAlvo, double valorAtual, String tipo, int usuarioIdUsuario) {
        this.idObjetivo = idObjetivo;
        this.descricao = descricao;
        this.quantidadeAlvo = quantidadeAlvo;
        this.valorAtual = valorAtual;
        this.tipo = tipo;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public ObjetivoFuturo(String descricao, int quantidadeAlvo, double valorAtual, String tipo, int usuarioIdUsuario) {
        this.descricao = descricao;
        this.quantidadeAlvo = quantidadeAlvo;
        this.valorAtual = valorAtual;
        this.tipo = tipo;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    // Getters and setters
    public Long getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(Long idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeAlvo() {
        return quantidadeAlvo;
    }

    public void setQuantidadeAlvo(int quantidadeAlvo) {
        this.quantidadeAlvo = quantidadeAlvo;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
}