package br.com.fiap.fintech.Entities;

import java.sql.Timestamp;

public class Despesa {
    private int id_despesa;
    private String descricao;
    private double valor;
    private Timestamp data_pagamento; // To store the payment date
    private char status_pagamento; // Assuming single character (P/U)
    private String categoria;
    private int usuario_id; // Foreign key for user

    public Despesa(String descricao, double valor, Timestamp data_pagamento, char status_pagamento, String categoria, int usuario_id) {
        this.descricao = descricao;
        this.valor = valor;
        this.data_pagamento = data_pagamento;
        this.status_pagamento = status_pagamento;
        this.categoria = categoria;
        this.usuario_id = usuario_id;
    }

    // Getters and Setters
    public int getId_despesa() {
        return id_despesa;
    }

    public void setId_despesa(int id_despesa) {
        this.id_despesa = id_despesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Timestamp getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Timestamp data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public char getStatus_pagamento() {
        return status_pagamento;
    }

    public void setStatus_pagamento(char status_pagamento) {
        this.status_pagamento = status_pagamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
}