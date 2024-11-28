package br.unitins.tp1.loja.model.converter;

import br.unitins.tp1.loja.model.produto.Voltagem;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class VoltagemConverter implements AttributeConverter<Voltagem, Integer>{
    @Override
    public Integer convertToDatabaseColumn(Voltagem voltagem){
        return voltagem == null ? null : voltagem.getId();
    }

    @Override
    public Voltagem convertToEntityAttribute(Integer idVoltagem){
        return Voltagem.valueOf(idVoltagem);
    }
}
