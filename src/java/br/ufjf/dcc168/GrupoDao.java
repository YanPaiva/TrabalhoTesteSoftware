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
    private static ArrayList<Grupo> grupo;
    
    public static ArrayList<Grupo> getInstace() {
        if (grupo == null) {
            //cria Array de grupo
            grupo = new ArrayList<Grupo>();            
            //cria grupo de exemplo
            Grupo exemplo = new Grupo();
            //cria Array de Alunos dentro do grupo de exemplo
            exemplo.getInstace();
            grupo.add(exemplo);
            
         // pegar no JSON todos os grupos da disciplina     
        }
        return grupo;
    }

    public GrupoDao() {
    }
    public static Grupo getGrupoDesejado(int id){
        return grupo.get(id);    
    }
    public static ArrayList<Grupo> getGrupo() {
        return grupo;
    }

    public static void setGrupo(ArrayList<Grupo> grupo) {
        GrupoDao.grupo = grupo;
    }
}

