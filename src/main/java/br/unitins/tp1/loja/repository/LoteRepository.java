package br.unitins.tp1.loja.repository;

import br.unitins.tp1.loja.model.produto.Lote;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoteRepository implements PanacheRepository<Lote>{

    /**
     * @return retorna o ventilador com o lote mais antigo e com quantidade maior que zero
     */
    public Lote findByIdVentilador(Long idVentilador) {
        StringBuffer jpql = new StringBuffer();
        jpql.append("SELECT ");
        jpql.append("  l ");
        jpql.append("FROM ");
        jpql.append("  Lote l ");
        jpql.append("WHERE ");
        jpql.append("  l.ventilador.id = ?1 ");
        jpql.append("  AND l.estoque > 0 ");
        jpql.append("ORDER BY l.data ");

        return find(jpql.toString(), idVentilador).firstResult();
    }
  
    public Lote findByCodigo(String codigo) {
        StringBuffer jpql = new StringBuffer();
        jpql.append("SELECT ");
        jpql.append("  l ");
        jpql.append("FROM ");
        jpql.append("  Lote l ");
        jpql.append("WHERE ");
        jpql.append("  l.codigo = ?1 ");

        return find(jpql.toString(), codigo).firstResult();
    }
}
