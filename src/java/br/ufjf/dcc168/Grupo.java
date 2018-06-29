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

    private ArrayList<Aluno> grupo;
    private String feedback;
    private double nota;
    
    public ArrayList<Aluno> getInstace() {
        if (grupo == null) {
            grupo = new ArrayList<Aluno>();
            for(int i = 0 ; i< 5 ; i++){
                Aluno a = new Aluno("Aluno"+i, i*2.5);
                grupo.add(a);            
            }
        }
        return grupo;
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
    public void setNotaAlunos(double nota){        
        for (Aluno aluno : grupo) {
            aluno.setNovaNota(nota);
        }
    }
}
