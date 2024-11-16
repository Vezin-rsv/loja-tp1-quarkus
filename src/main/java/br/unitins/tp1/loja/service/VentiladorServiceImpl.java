package br.unitins.tp1.loja.service;

import java.util.List;
import br.unitins.tp1.loja.dto.VentiladorRequestDTO;
import br.unitins.tp1.loja.model.Cor;
import br.unitins.tp1.loja.model.Ventilador;
import br.unitins.tp1.loja.model.Voltagem;
import br.unitins.tp1.loja.repository.VentiladorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class VentiladorServiceImpl implements VentiladorService{

    @Inject
    VentiladorRepository ventiladorRepository;

    @Inject
    ModeloService modeloService;

    @Inject
    FabricanteService fabricanteService;

    @Inject
    FornecedorService fornecedorService;

    @Override
    public Ventilador findById(Long id) {
        return ventiladorRepository.findById(id);
    }

    @Override
    public List<Ventilador> findByNome(String nome) {
        return ventiladorRepository.findByNome(nome);
    }

    @Override
    public List<Ventilador> findAll() {
        return ventiladorRepository.listAll();
    }


    @Override
    @Transactional
    public Ventilador create(VentiladorRequestDTO dto) {
        Ventilador ventilador = new Ventilador();
        ventilador.setNome(dto.nome());
        ventilador.setPreco(dto.preco());
        ventilador.setDescricao(dto.descricao());
        ventilador.setVoltagem(Voltagem.valueOf(dto.idVoltagem()));
        ventilador.setCor(Cor.valueOf(dto.idCor()));
        ventilador.setNomeImagem(dto.nomeImagem());

        ventilador.setModelo(modeloService.findById(dto.idModelo()));
        ventilador.setFabricante(fabricanteService.findById(dto.idFabricante()));
        ventilador.setFornecedor(fornecedorService.findById(dto.idFornecedor()));
    
        ventiladorRepository.persist(ventilador);
        return ventilador;
    }

    @Override
    @Transactional
    public Ventilador update(Long id, VentiladorRequestDTO dto) {
        Ventilador ventilador = ventiladorRepository.findById(id);
        ventilador.setNome(dto.nome());
        ventilador.setPreco(dto.preco());
        ventilador.setDescricao(dto.descricao());
        ventilador.setVoltagem(Voltagem.valueOf(dto.idVoltagem()));
        ventilador.setCor(Cor.valueOf(dto.idCor()));
        ventilador.setNomeImagem(dto.nomeImagem());
    
        ventilador.setModelo(modeloService.findById(dto.idModelo()));
        ventilador.setFabricante(fabricanteService.findById(dto.idFabricante()));
        ventilador.setFornecedor(fornecedorService.findById(dto.idFornecedor()));
    
        ventiladorRepository.persist(ventilador);
        return ventilador; // Retorne a entidade atualizada
    }

    @Override
    @Transactional
    public Ventilador updateNomeImagem(Long id, String nomeImagem) {
        Ventilador ventilador = ventiladorRepository.findById(id);

        ventilador.setNomeImagem(nomeImagem);
        
        return ventilador;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!ventiladorRepository.deleteById(id)) {
            throw new IllegalArgumentException("Ventilador não encontrado para exclusão");
        }
    }

}
