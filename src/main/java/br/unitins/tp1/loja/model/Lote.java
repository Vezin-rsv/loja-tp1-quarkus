package br.unitins.tp1.loja.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lote extends DefaultEntity{

    @ManyToOne
    @JoinColumn(name = "id_ventilador")
    private Ventilador ventilador;
    
    @Column(length = 60, nullable = false)
    private String codigo;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private LocalDate dataFabricacao;

    public Ventilador getVentilador() {
        return ventilador;
    }

    public void setVentilador(Ventilador ventilador) {
        this.ventilador = ventilador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

}
