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
public class Atividade {
    private int idAtividadeServidor;
    private String descricao;
    private List<Grupo> grupos = new ArrayList<>();

    public Atividade(int idAtividadeServidor, String descricao) {
        this.idAtividadeServidor = idAtividadeServidor;
        this.descricao = descricao;
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
    
    public void setGrupos(Grupo grupo) {
        this.grupos.add(grupo);
    }
}
