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
 * @author fernanda
 */
public class Disciplina {
    
    private static Disciplina instance;
    private int idDisciplinaServidor;
    private String disciplina;
    private Atividade atividade;
    private List<Aluno> alunos = new ArrayList<>();
    
    public static Disciplina getInstance(){
        if(instance == null){
            instance = new Disciplina();
        }
        return instance;
    }
    
    public Disciplina() {}
 
    public int getIdDisciplinaServidor() {
        return idDisciplinaServidor;
    }

    public void setIdDisciplinaServidor(int idDisciplinaServidor) {
        this.idDisciplinaServidor = idDisciplinaServidor;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    public void setAlunos(Aluno aluno) {
        this.alunos.add(aluno);
    }
}
