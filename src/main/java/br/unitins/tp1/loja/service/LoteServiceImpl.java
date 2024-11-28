package br.unitins.tp1.loja.service;

import java.util.List;
import br.unitins.tp1.loja.dto.produto.LoteRequestDTO;
import br.unitins.tp1.loja.model.produto.Lote;
import br.unitins.tp1.loja.repository.LoteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class LoteServiceImpl implements LoteService{

    @Inject
    LoteRepository loteRepository;

    @Inject
    VentiladorService ventiladorService;

    @Override
    public Lote findById(Long id) {
        return loteRepository.findById(id);
    }

    @Override
    public Lote findByCodigo(String codigo) {
        return loteRepository.findByCodigo(codigo);
    }

    @Override
    public Lote findByIdVentilador(Long idVentilador) {
        return loteRepository.findByIdVentilador(idVentilador);
    }

    @Override
    public List<Lote> findAll() {
        return loteRepository.listAll();
    }

    @Override
    @Transactional
    public Lote create(LoteRequestDTO dto) {
        Lote lote = new Lote();
        lote.setVentilador(ventiladorService.findById(dto.idVentilador()));
        lote.setCodigo(dto.codigo());
        lote.setQuantidade(dto.quantidade());
        lote.setDataFabricacao(dto.dataFabricacao());
        
        loteRepository.persist(lote); // salva o lote
        return lote;
    }

    @Override
    @Transactional
    public Lote update(Long id, LoteRequestDTO dto) {
        Lote lote = loteRepository.findById(id);

        lote.setVentilador(ventiladorService.findById(dto.idVentilador()));
        lote.setCodigo(dto.codigo());
        lote.setQuantidade(dto.quantidade());
        lote.setDataFabricacao(dto.dataFabricacao());

        return lote; // Retorne a entidade atualizada
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!loteRepository.deleteById(id)) {
            throw new IllegalArgumentException("Lote não encontrado para exclusão");
        }
    }
}
