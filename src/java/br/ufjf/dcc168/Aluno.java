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
    private int id;
    private String nome;
    private String descricao;
    private ArrayList<Double> nota = new ArrayList<>();
    

    public Aluno(String nome, int id) {
        this.nome = nome;
        this.id=id;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Double> getNota() {
        return nota;
    }

    public void setNota(ArrayList<Double> nota) {
        this.nota = nota;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
