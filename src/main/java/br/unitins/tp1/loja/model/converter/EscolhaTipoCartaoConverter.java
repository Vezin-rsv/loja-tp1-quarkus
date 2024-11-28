package br.unitins.tp1.loja.model.converter;

import br.unitins.tp1.loja.model.pagamento.EscolhaTipoCartao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EscolhaTipoCartaoConverter implements AttributeConverter<EscolhaTipoCartao, Integer>{
    @Override
    public Integer convertToDatabaseColumn(EscolhaTipoCartao tipo){
        return tipo == null ? null : tipo.getId();
    }

    @Override
    public EscolhaTipoCartao convertToEntityAttribute(Integer idEscolhaTipoCartao){
        return EscolhaTipoCartao.valueOf(idEscolhaTipoCartao);
    }
}
