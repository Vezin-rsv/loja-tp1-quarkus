package br.unitins.tp1.loja.model.pagamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Boleto extends Pagamento {

    @Column(nullable = false)
    private String codigoBarras;

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
}

