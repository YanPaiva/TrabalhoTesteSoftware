/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;
/**
 *
 * @author YanNotebook
 */
public class Aluno {
    private int idAlunoServidor;
    private String nome;
    private double nota;

    public Aluno(int idAlunoServidor, String nome, double nota) {
        this.idAlunoServidor = idAlunoServidor;
        this.nome = nome;
        this.nota = nota;
    }
    
    public Aluno(int idAlunoServidor, String nome) {
        this.idAlunoServidor = idAlunoServidor;
        this.nome = nome;
    }
    
    public int getIdAlunoServidor() {
        return idAlunoServidor;
    }

    public void setIdAlunoServidor(int idAlunoServidor) {
        this.idAlunoServidor = idAlunoServidor;
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

}
