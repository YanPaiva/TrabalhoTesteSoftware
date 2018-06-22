/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc168;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YanNotebook
 */
public class GrupoDao {
    private static ArrayList<Aluno> grupo;
    private static String feedback;
    private static double nota;
    
    public static ArrayList<Aluno> getInstace() {
        if (grupo == null) {
            grupo = new ArrayList<Aluno>();
            for(int i = 0; i<5 ;i++ ){
                Aluno a = new Aluno();
                a.setNome("aluno"+i);
                grupo.add(a);
            }        
        }
        return grupo;
    }

    public GrupoDao() {
    }

    public static ArrayList<Aluno> getGrupo() {
        return grupo;
    }

    public static void setGrupo(ArrayList<Aluno> grupo) {
        GrupoDao.grupo = grupo;
    }

    public static double getNota() {
        return nota;
    }

    public static void setNota(double nota) {
        GrupoDao.nota = nota;
    }
    public static void setNotaAlunos(double nota){
        for (Aluno aluno : grupo) {
            aluno.setNota(nota);
        }
    }

    public static String getFeedback() {
        return feedback;
    }

    public static void setFeedback(String feedback) {
        GrupoDao.feedback = feedback;
    }
    
}

