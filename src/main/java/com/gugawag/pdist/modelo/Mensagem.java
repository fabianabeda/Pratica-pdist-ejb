package com.gugawag.pdist.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;


@Entity
public class Mensagem implements Serializable {
    @Id
    private Long id;
    private String texto;

    public Mensagem(long id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public Mensagem() {

    }

    public Long getId() {

        return id;
    }


    public String getTexto() {

        return this.texto;
    }

    public void setTexto(String texto) {

        this.texto = texto;
    }
}

