package br.unitins.tp1.loja.model.pagamento;

import br.unitins.tp1.loja.model.converter.EscolhaTipoCartaoConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;

@Entity
public class Cartao extends Pagamento {

    @Column(nullable = false)
    private String numeroCartao;

    @Column(nullable = false)
    private String nomeTitular;

    @Column(nullable = false)
    private String validade;

    @Column(nullable = false)
    private String codigoSeguranca;

    @Convert(converter = EscolhaTipoCartaoConverter.class)
    @Column(nullable = false)
    private EscolhaTipoCartao tipo;

    public EscolhaTipoCartao getTipo() {
        return tipo;
    }

    public void setTipo(EscolhaTipoCartao tipo) {
        this.tipo = tipo;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }
}

