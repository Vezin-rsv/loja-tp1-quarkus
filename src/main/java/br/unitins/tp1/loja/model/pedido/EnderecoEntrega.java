package br.unitins.tp1.loja.model.pedido;

import br.unitins.tp1.loja.model.DefaultEntity;
import br.unitins.tp1.loja.model.endereco.Cidade;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EnderecoEntrega extends DefaultEntity{

    private String cep;
    private String logradouro;
    private String bairro;
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;
    
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    
}
