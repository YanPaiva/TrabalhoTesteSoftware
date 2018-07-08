/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

/**
 *
 * @author fernanda
 */
public class Disciplina {
    private int idDisciplinaServidor;
    private String disciplina;

    public Disciplina(int idDisciplinaServidor, String disciplina) {
        this.idDisciplinaServidor = idDisciplinaServidor;
        this.disciplina = disciplina;
    }
 
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
}
