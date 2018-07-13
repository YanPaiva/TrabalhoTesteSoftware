/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Atividade;
import static dao.Dados.ATIVIDADE;
import static dao.Dados.ATIVIDADE_ALT;
import static dao.Dados.ATIVIDADE_DAO;
import java.util.List;
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
       if(ATIVIDADE_DAO.buscar(ATIVIDADE.getIdAtividadeServidor()) == null)
            ATIVIDADE_DAO.salvar(ATIVIDADE);
    }

    /**
     * Teste do metodo alterar da classe AtividadeDao.
     */
    @Test
    public void testAlterar() throws Exception {
        ATIVIDADE_DAO.alterar(ATIVIDADE_ALT);
    }

    /**
     * Teste do metodo buscar da classe AtividadeDao.
     */
    @Test
    public void testBuscar() throws Exception {
        Atividade result = ATIVIDADE_DAO.buscar(ATIVIDADE.getIdAtividadeServidor());
        assertEquals(ATIVIDADE_ALT.getDescricao(), result.getDescricao());
    }

    /**
     * Teste de metodo buscarTodos da classe AtividadeDao.
     */
    @Test
    public void testBuscarTodos() throws Exception {
        List<Atividade> result = ATIVIDADE_DAO.buscarTodos();
        assertNotNull(result);
    }
    
}
