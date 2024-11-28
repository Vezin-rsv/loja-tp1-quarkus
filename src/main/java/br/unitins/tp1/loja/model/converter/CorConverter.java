package br.unitins.tp1.loja.model.converter;
import br.unitins.tp1.loja.model.produto.Cor;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CorConverter implements AttributeConverter<Cor, Integer>{

    @Override
    public Integer convertToDatabaseColumn(Cor cor){
        return cor == null ? null : cor.getId();
    }

    @Override
    public Cor convertToEntityAttribute(Integer idCor){
        return Cor.valueOf(idCor);
    }
}
