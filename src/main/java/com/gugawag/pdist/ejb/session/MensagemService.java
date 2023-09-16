package com.gugawag.pdist.ejb.session;
import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;


import java.util.List;

@Stateless(name = "mensagemService")
public class MensagemService {
    @EJB
    private MensagemDAO mensagemDAO;


    public void inserir(long id, String mensagem) {
        Mensagem newMensagem = new Mensagem(id, mensagem);
        newMensagem.setTexto(newMensagem.getTexto() + "u" + newMensagem.getId());
        mensagemDAO.inserir(newMensagem);
    }

    public List<Mensagem> listarMensagens() {
        return mensagemDAO.listar();
    }



}

