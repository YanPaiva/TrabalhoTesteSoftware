/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Dados.DISCIPLINA;
import static dao.Dados.DISCIPLINA_DAO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marit
 */
public class DisciplinaDaoTest {
      
    /**
     * Teste do metodo getInstance da classe DisciplinaDao.
     */
    @Test
    public void testGetInstance() {
        assertNotNull(DISCIPLINA_DAO);
    }

    /**
     * Teste do metodo salvar da classe DisciplinaDao.
     */
    @Test
    public void testSalvar() throws Exception {
        DISCIPLINA_DAO.salvar(DISCIPLINA);
    }

    /**
     * Teste do metodo buscar da classe DisciplinaDao.
     */
    @Test
    public void testBuscar() throws Exception {
        boolean expResult = false;
        boolean result = DISCIPLINA_DAO.buscar(DISCIPLINA.getIdDisciplinaServidor());
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo alterar da classe DisciplinaDao.
     */
    @Test
    public void testAlterar() throws Exception {
        DISCIPLINA_DAO.alterar(DISCIPLINA);
    }

    /**
     * Teste do metodo dropAlll da classe DisciplinaDao.
     *
    @Test
    public void testDropAlll() throws Exception {
        DisciplinaDao instance = DisciplinaDao.getInstance();
        instance.dropAlll();
    }

    /**
     * Teste do metodo dropTable da classe DisciplinaDao.
     *
    @Test
    public void testDropTable() throws Exception {
        String table = "aluno";
        DisciplinaDao instance = null;
        instance.dropTable(table);
    }*/
    
}
