package br.com.fiap.fintech.Entities;

import java.util.Date;

public class Despesas {
    private Long id;
    private String descricao;
    private Date dataPagamento;
    private Double valor;
    private Boolean statusPagamento;
    private String categoria;
    private Long usuarioId;

    public Despesas(Long id, String descricao, Date dataPagamento, Double valor, Boolean statusPagamento, String categoria, Long usuarioId) {
        this.id = id;
        this.descricao = descricao;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.statusPagamento = statusPagamento;
        this.categoria = categoria;
        this.usuarioId = usuarioId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(Boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}