package com.texugos.botecando.persistencia;

import com.texugos.botecando.entidades.Estabelecimento;
import com.texugos.botecando.interfaces.EstabelecimentoDAO;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @brief Classe EstabelecimentoDAOImpl
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date   29/01/2018
 */
@Stateless
@Remote(EstabelecimentoDAO.class)
public class EstabelecimentoDAOImpl implements EstabelecimentoDAO{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void adicionar(Estabelecimento estabelecimento) {
        em.persist(estabelecimento);
    }

    @Override
    public void remover(Estabelecimento estabelecimento) {
        em.remove(estabelecimento);
    }

    @Override
    public void atualizar(Estabelecimento estabelecimento) {
        em.merge(estabelecimento);
    }

    @Override
    public List<Estabelecimento> listarTodos() {
        return em.createQuery("SELECT e FROM Estabelecimento e", 
                Estabelecimento.class).getResultList();
    }

    @Override
    public Estabelecimento buscarPorId(int id) {
        return em.find(Estabelecimento.class, id);
    }

}
