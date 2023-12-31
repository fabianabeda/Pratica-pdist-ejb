package com.gugawag.pdist.servlets;
import com.gugawag.pdist.ejb.session.MensagemService;
import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/mensagem.do"})
public class MensagemServlet extends HttpServlet {

    @EJB(lookup = "java:module/mensagemService")
    private MensagemService mensagemService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String operacao = request.getParameter("oper");
        PrintWriter resposta = response.getWriter();
        switch (operacao) {
            case "1": { // Inserir
                long id = Integer.parseInt(request.getParameter("id"));
                String mensagem = request.getParameter("texto");
                mensagemService.inserir(id, mensagem);
            }
            case "2": { // Listar
                for (Mensagem mensagem : mensagemService.listarMensagens()) {
                    resposta.println(mensagem.getTexto());
                }
                break;
            }
            case "3": { // Pesquisar por ID
                long id = Long.parseLong(request.getParameter("id"));
                Mensagem mensagem = mensagemService.pesquisarMensagemPorId(id);
                if (mensagem != null) {
                    resposta.println("ID: " + mensagem.getId() + ", Texto: " + mensagem.getTexto());
                } else {
                    resposta.println("Mensagem não encontrada para o ID especificado.");
                }
                break;

            }
        }
    }
}

