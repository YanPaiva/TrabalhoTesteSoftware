/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marit
 */
public class AtividadeTest {
    
    /**
     * Teste do metodo getIdAtividadeServidor da classe Atividade.
     */
    @Test
    public void testGetIdAtividadeServidor() {
        Atividade atividade = new Atividade(1,"atividade 1");
        int expResult = 1;
        int result = atividade.getIdAtividadeServidor();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setIdAtividadeServidor da classe Atividade.
     */
    @Test
    public void testSetIdAtividadeServidor() {
        int idAtividadeServidor = 0;
        Atividade atividade = new Atividade(1,"atividade 1");
        atividade.setIdAtividadeServidor(idAtividadeServidor);
        assertEquals(idAtividadeServidor,atividade.getIdAtividadeServidor());
    }

    /**
     * Teste do metodo getDescricao da classe Atividade.
     */
    @Test
    public void testGetDescricao() {
        Atividade atividade = new Atividade(1,"atividade 1");
        String expResult = "atividade 1";
        String result = atividade.getDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setDescricao da classe Atividade.
     */
    @Test
    public void testSetDescricao() {
        String descricao = "Atividade 2";
        Atividade atividade = new Atividade(1,"atividade 1");
        atividade.setDescricao(descricao);
        assertEquals(descricao,atividade.getDescricao());
    }

    /**
     * Teste do metodo getGrupos da classe Atividade.
     */
    @Test
    public void testGetGrupos() {
        Atividade atividade = new Atividade(1,"atividade 1");
        List<Grupo> expResult = new ArrayList<>();
        List<Grupo> result = atividade.getGrupos();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setGrupos da classe Atividade.
     */
    @Test
    public void testSetGrupos() {
        List<Grupo> grupos = null;
        Atividade atividade = new Atividade(1,"atividade 1");
        atividade.setGrupos(grupos);
    }
    
}
