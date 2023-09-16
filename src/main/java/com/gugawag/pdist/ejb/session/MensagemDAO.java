package com.gugawag.pdist.ejb.session;
import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MensagemDAO {
    @PersistenceContext(unitName="default")
    private EntityManager entityManager;

    public void inserir(Mensagem mensagem) {
        entityManager.persist(mensagem);
    }

    public List<Mensagem> listar() {
        return entityManager.createQuery("SELECT m FROM Mensagem m", Mensagem.class).getResultList();
    }

    public Mensagem pesquisarPorId(Long id) {
        return entityManager.find(Mensagem.class, id);
    }
}

