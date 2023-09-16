package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class UsuarioDAO {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public void inserir(Usuario novoUsuario) {
        entityManager.persist(novoUsuario);
    }

    public List<Usuario> listar() {
        return entityManager.createQuery("SELECT u FROM tb_usuario_pdist u").getResultList();
    }

}
