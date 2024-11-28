package br.unitins.tp1.loja.model.pagamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EscolhaTipoCartao {
    DEBITO (1, "débito"), 
    CREDITO (2, "crédito");

    private final Integer id;
    private final String label;

    EscolhaTipoCartao (Integer id, String label){
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }
    public String getLabel() {
        return label;
    }

    @JsonValue
    public Integer toValue() {
        return id; // Este método retorna o ID para a serialização
    }

    public static EscolhaTipoCartao valueOf(Integer id){
        if (id == null)
            return null;
        for (EscolhaTipoCartao tipo : EscolhaTipoCartao.values()){
            if (tipo.getId().equals(id))
                return tipo;
        }
        throw new IllegalArgumentException("Id inválido");
    }
}