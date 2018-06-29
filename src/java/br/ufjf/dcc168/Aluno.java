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
public class Aluno {

    private String nome;
    private String descricao;
    private static ArrayList<Double> nota = new ArrayList<>();
    

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota.add(nota);
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static ArrayList<Double> getNota() {
        return nota;
    }

    public static void setNota(ArrayList<Double> nota) {
        Aluno.nota = nota;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota(int id) {
        return nota.get(id);
    }

    public ArrayList<Double> getAllNotas() {
        return nota;

    }

    public void setNovaNota(double novaNota) {
        nota.add(novaNota);
    }
    public void setNotaExist(double notaAtt, int id ){
        nota.set(id, notaAtt);    
    }
}
