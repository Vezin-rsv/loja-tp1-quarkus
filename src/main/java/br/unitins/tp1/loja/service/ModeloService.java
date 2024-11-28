package br.unitins.tp1.loja.service;
import java.util.List;

import br.unitins.tp1.loja.dto.produto.ModeloRequestDTO;
import br.unitins.tp1.loja.model.produto.Modelo;


public interface ModeloService {

    Modelo findById(Long id);

    List<Modelo> findByNome(String nome);

    List<Modelo> findAll();

    Modelo create(ModeloRequestDTO dto);

    Modelo update(Long id, ModeloRequestDTO dto);

    void delete(Long id); 
}
