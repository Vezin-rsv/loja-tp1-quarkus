package br.unitins.tp1.loja.service;
import java.util.List;

import br.unitins.tp1.loja.dto.produto.VentiladorRequestDTO;
import br.unitins.tp1.loja.model.produto.Ventilador;


public interface VentiladorService {

    Ventilador findById(Long id);

    List<Ventilador> findByNome(String nome);

    List<Ventilador> findAll();

    Ventilador create(VentiladorRequestDTO dto);

    Ventilador update(Long id, VentiladorRequestDTO dto);

    Ventilador updateNomeImagem(Long id, String nomeImagem);

    void delete(Long id); 
}
