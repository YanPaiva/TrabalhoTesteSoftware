/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Atividade;
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
public class AtividadeDaoTest {
    
    /**
     * Teste do metodo getInstance da classe AtividadeDao.
     */
    @Test
    public void testGetInstance() {
        AtividadeDao result = AtividadeDao.getInstance();
        assertNotNull(result);
    }

    /**
     * Teste do metodo salvar da classe AtividadeDao.
     */
    @Test
    public void testSalvar() throws Exception {
        Atividade atividade = new Atividade(1,"atividade 1");
        AtividadeDao instance = new AtividadeDao();
        instance.salvar(atividade);
    }

    /**
     * Teste do metodo alterar da classe AtividadeDao.
     */
    @Test
    public void testAlterar() throws Exception {
        Atividade atividade = new Atividade(1,"atividade 2");
        AtividadeDao instance = AtividadeDao.getInstance();
        instance.alterar(atividade);
    }

    /**
     * Teste do metodo buscar da classe AtividadeDao.
     */
    @Test
    public void testBuscar() throws Exception {
        int idAtividade = 1;
        AtividadeDao instance = AtividadeDao.getInstance();
        Atividade expResult = new Atividade(1,"atividade 1");
        Atividade result = instance.buscar(idAtividade);
        assertEquals(expResult, result);
    }

    /**
     * Teste de metodo buscarTodos da classe AtividadeDao.
     */
    @Test
    public void testBuscarTodos() throws Exception {
        AtividadeDao instance = new AtividadeDao();
        List<Atividade> result = instance.buscarTodos();
        assertNotNull(result);
    }
    
}
