package com.texugos.botecando.persistencia;

import com.texugos.botecando.entidades.Usuario;
import com.texugos.botecando.interfaces.UsuarioDAO;
import java.util.List;
import java.util.Optional;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @brief Classe UsuarioDAOImpl
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date   30/01/2018
 */
@Stateless
@Remote(UsuarioDAO.class)
public class UsuarioDAOImpl implements UsuarioDAO{

     @PersistenceContext
    private EntityManager em;
    
    @Override
    public void adicionar(Usuario usuario) {
        usuario.setEmail(usuario.getEmail().toLowerCase());
        em.persist(usuario);
    }

    @Override
    public void remover(Usuario usuario) {
        em.remove(buscarPorId(usuario.getID()));
    }

    @Override
    public void atualizar(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

    @Override
    public Usuario buscarPorId(int id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public Usuario autentica(String email, String senha) {
         TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE "
                + "a.email =:email AND a.senha =:senha", Usuario.class);
        query.setParameter("email", email.toLowerCase());
        query.setParameter("senha", senha);
        Optional<Usuario> resultado = query.getResultList().stream().findFirst();
        if(resultado.isPresent()){
            Usuario usuario = resultado.get();
            return usuario;
        } else {
            return null;
        }
    }

    @Override
    public boolean verificarEmail(String email) {
          TypedQuery<Usuario> createQuery = em.createQuery("SELECT u FROM "
                + "Usuario u WHERE a.email =:email", Usuario.class);
        createQuery.setParameter("email", email);
        Optional<Usuario> findFirst = createQuery.getResultList().stream().findFirst();
        if (findFirst.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

}
