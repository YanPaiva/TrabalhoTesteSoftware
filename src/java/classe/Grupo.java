/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YanNotebook
 */
public class Grupo {
    private int idGrupoServidor;
    private int idAtividadeServidor;
    private String nome;
    private double nota;
    private List<Aluno> alunos = new ArrayList<>();
    
    public Grupo(int idGrupoServidor, String nome, double nota, List<Aluno> alunos) {
        this.idGrupoServidor = idGrupoServidor;
        this.nome = nome;
        this.nota = nota;
        this.alunos = alunos;
    }
    
    public Grupo(int idGrupoServidor, int idAtividadeServidor, String nome, double nota) {
        this.idGrupoServidor = idGrupoServidor;
        this.idAtividadeServidor = idAtividadeServidor;
        this.nome = nome;
        this.nota = nota;
    }
    
    public Grupo(int idGrupoServidor, int idAtividadeServidor, String nome, List<Aluno> alunos) {
        this.idGrupoServidor = idGrupoServidor;
        this.idAtividadeServidor = idAtividadeServidor;
        this.alunos = alunos;
        this.nome = nome;
    }
    
    public int getIdGrupoServidor() {
        return idGrupoServidor;
    }

    public void setIdGrupoServidor(int idGrupoServidor) {
        this.idGrupoServidor = idGrupoServidor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno aluno) {
        this.alunos.add(aluno);
    }
    
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public int getIdAtividadeServidor() {
        return idAtividadeServidor;
    }

    public void setIdAtividadeServidor(int idAtividadeServidor) {
        this.idAtividadeServidor = idAtividadeServidor;
    } 
}
