/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Aluno;
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
public class AlunoDaoTest {
    
    /**
     * Teste do metodo getInstance da classe AlunoDao.
     */
    @Test
    public void testGetInstance() {
        AlunoDao result = AlunoDao.getInstance();
        assertNotNull(result);
    }

    /**
     * Teste do metodo salvar da classe AlunoDao.
     */
    @Test
    public void testSalvar() throws Exception {
        Aluno aluno = new Aluno(5,"Marta",55.00);
        AlunoDao instance = new AlunoDao();
        instance.salvar(aluno);
    }

    /**
     * Teste do metodo buscar da classe AlunoDao.
     */
    @Test
    public void testBuscar_int() throws Exception {
        int idAluno = 5;
        AlunoDao instance = new AlunoDao();
        Aluno aluno = new Aluno(5,"Marta",55.00);
        Aluno result = instance.buscar(idAluno);
        assertEquals(aluno, result);
    }

    /**
     * Teste do metodo buscar da classe AlunoDao.
     */
    @Test
    public void testBuscar_int_int() throws Exception {
        int idAluno = 3;
        int idAtividade = 1;
        AlunoDao instance = new AlunoDao();
        Aluno aluno = new Aluno(3,"José",45.00);
        Aluno result = instance.buscar(idAluno, idAtividade);
        assertEquals(aluno, result);
    }

    /**
     * Teste do metodo buscarTodos de classe AlunoDao.
     */
    @Test
    public void testBuscarTodos() throws Exception {
        AlunoDao instance = new AlunoDao();
        List<Aluno> result = instance.buscarTodos();
        assertNotNull(result);
    }

    /**
     * Teste do metodo alterar da classe AlunoDao.
     */
    @Test
    public void testAlterar() throws Exception {
        Aluno aluno = new Aluno(3,"Henrique",50.00);
        AlunoDao instance = new AlunoDao();
        instance.alterar(aluno);
    }
    
}
