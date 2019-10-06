package com.projeto.parte1.data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "LEMBRETE")
public class Lembrete implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long   id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESC")
    private String desc;

    //construtor
    public Lembrete() {
    }

    public Lembrete(Long id, String nome, String desc) {
        this.id   = id;
        this.nome = nome;
        this.desc = desc;
    }

    //getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
