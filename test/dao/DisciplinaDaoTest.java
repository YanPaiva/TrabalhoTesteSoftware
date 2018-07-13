/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Disciplina;
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
public class DisciplinaDaoTest {
    
    /**
     * Teste do metodo getInstance da classe DisciplinaDao.
     */
    @Test
    public void testGetInstance() {
        DisciplinaDao result = DisciplinaDao.getInstance();
        assertNotNull(result);
    }

    /**
     * Teste do metodo salvar da classe DisciplinaDao.
     */
    @Test
    public void testSalvar() throws Exception {
        Disciplina disciplina = Disciplina.getInstance();
        DisciplinaDao instance = DisciplinaDao.getInstance();
        instance.salvar(disciplina);
    }

    /**
     * Teste do metodo buscar da classe DisciplinaDao.
     */
    @Test
    public void testBuscar() throws Exception {
        int idDisciplina = 0;
        DisciplinaDao instance = DisciplinaDao.getInstance();
        boolean expResult = false;
        boolean result = instance.buscar(idDisciplina);
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo alterar da classe DisciplinaDao.
     */
    @Test
    public void testAlterar() throws Exception {
        Disciplina disciplina = Disciplina.getInstance();
        DisciplinaDao instance = DisciplinaDao.getInstance();
        instance.alterar(disciplina);
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
