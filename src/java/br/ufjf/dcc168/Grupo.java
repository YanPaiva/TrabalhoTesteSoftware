/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc168;

import java.util.ArrayList;

/**
 *
 * @author YanNotebook
 */
public class Grupo {
    private int id;
    private ArrayList<Aluno> grupo;
    private String feedback;
    private double nota;

    public ArrayList<Aluno> getInstace() {
        if (grupo == null) {
            grupo = new ArrayList<Aluno>();

//tem q pegar os alunos da turma pra não precisar vailidar se o aluno esta matriculado na turma
            for(int i = 0 ; i< 5 ; i++){
                Aluno a = new Aluno("Aluno"+i, i);
                grupo.add(a);            
            }
        }
        return grupo;
    }

    public void setNotaAlunos(double nota){        
        for (Aluno aluno : grupo) {
            aluno.setNovaNota(nota);
        }
    }


    public ArrayList<Aluno> getGrupo() {
        return grupo;
    }

    public void setGrupo(ArrayList<Aluno> grupo) {
        this.grupo = grupo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Grupo() {
    }
     public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
     public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    void setNotaAluno(double nota, int id) {
     
    }
}
