package br.unitins.tp1.loja.service;
import java.util.List;

import br.unitins.tp1.loja.dto.LoteRequestDTO;
import br.unitins.tp1.loja.model.Lote;


public interface LoteService {

    Lote findById(Long id);

    Lote findByCodigo(String codigo);

    Lote findByIdVentilador(Long idVentilador);

    List<Lote> findAll();

    Lote create(LoteRequestDTO dto);

    Lote update(Long id, LoteRequestDTO dto);

    void delete(Long id); 

}
