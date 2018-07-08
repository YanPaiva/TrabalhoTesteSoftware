/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.util.List;

/**
 *
 * @author fernanda
 */
public class Atividade {
    private int idAtividadeServidor;
    private Disciplina disciplina;
    private String descricao;
    private List<Grupo> grupos;

    public Atividade(int idAtividadeServidor,int idDisciplinaServidor, String disciplina, String descricao) {
        this.idAtividadeServidor = idAtividadeServidor;
        this.disciplina = new Disciplina(idDisciplinaServidor, disciplina);
        this.descricao = descricao;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public int getIdDisciplina() {
        return disciplina.getIdDisciplinaServidor();
    }

    public void setIdDisciplina(int idDisciplina) {
        this.disciplina.setIdDisciplinaServidor(idDisciplina); 
    }
    
    public String getDescricaoDisciplina() {
        return disciplina.getDisciplina();
    }

    public void setDescricaoDisciplina(String descricao) {
        this.disciplina.setDisciplina(descricao);
    }
       
    public int getIdAtividadeServidor() {
        return idAtividadeServidor;
    }

    public void setIdAtividadeServidor(int idAtividadeServidor) {
        this.idAtividadeServidor = idAtividadeServidor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
}
