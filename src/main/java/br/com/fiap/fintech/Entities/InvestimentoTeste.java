package br.com.fiap.fintech.Entities;


public class InvestimentoTeste {
    private Long id;
    private double valor;

    public InvestimentoTeste(Long id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
