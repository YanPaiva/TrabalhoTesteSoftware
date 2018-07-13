/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Aluno;
import classe.Grupo;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marit
 */
public class GrupoDaoTest {
    
    /**
     * Teste do metodo getInstance da classe GrupoDao.
     */
    @Test
    public void testGetInstance() {
        GrupoDao result = GrupoDao.getInstance();
        assertNotNull(result);
    }

    /**
     * Teste do metodo salvar da classe GrupoDao.
     */
    @Test
    public void testSalvar() throws Exception {
        Grupo grupo = new Grupo(8,8,"Grupo 8",8.00);
        GrupoDao instance = GrupoDao.getInstance();
        instance.salvar(grupo);
    }

    /**
     * Teste do metodo salvarSemNota da classe GrupoDao.
     */
    @Test
    public void testSalvarSemNota() throws Exception {
        List<Aluno> alunos = null;
        Aluno aluno = new Aluno(8,"Ana",6.00);
        Grupo grupo = new Grupo(1,1,"Grupo 7",alunos);
        GrupoDao instance = GrupoDao.getInstance();
        instance.salvarSemNota(grupo);
    }

    /**
     * Teste do metodosalvarAlunos da classe GrupoDao.
     */
    @Test
    public void testSalvarAlunos() throws Exception {
        List<Aluno> alunos = null;
        Aluno aluno = new Aluno(6,"Carol",10.00);
        alunos.add(aluno);
        int idGrupo = 1;
        GrupoDao instance = GrupoDao.getInstance();
        instance.salvarAlunos(alunos, idGrupo);
    }

    /**
     * Teste do metodo alterarAlunos da classe GrupoDao.
     */
    @Test
    public void testAlterarAlunos() throws Exception {
        List<Aluno> alunos = null;
        int idGrupo = 0;
        GrupoDao instance = GrupoDao.getInstance();
        instance.alterarAlunos(alunos, idGrupo);
    }

    /**
     * Teste do metodo alterar da classe GrupoDao.
     */
    @Test
    public void testAlterar_Grupo() throws Exception {
        Grupo grupo = new Grupo(2,3,"grupo 6", 90.0);
        GrupoDao instance = GrupoDao.getInstance();
        instance.alterar(grupo);
    }

    /**
     * Teste do metodo alterar da classe GrupoDao.
     */
    @Test
    public void testAlterar_int_double() throws Exception {
        int idGrupo = 0;
        double nota = 10.0;
        GrupoDao instance = GrupoDao.getInstance();
        instance.alterar(idGrupo, nota);
    }

    /**
     * Teste do metodo buscar da classe GrupoDao.
     */
    @Test
    public void testBuscar() throws Exception {
        int idGrupo = 2;
        GrupoDao instance = GrupoDao.getInstance();
        Grupo grupo = new Grupo(2,3,"grupo 6", 90.0);
        Grupo result = instance.buscar(idGrupo);
        assertEquals(grupo, result);
    }

    /**
     * Teste do metodo buscarTodos da classe GrupoDao.
     */
    @Test
    public void testBuscarTodos() throws Exception {
        int idAtividade = 0;
        GrupoDao instance = GrupoDao.getInstance();
        List<Grupo> result = instance.buscarTodos(idAtividade);
        assertNotNull(result);
    }

    /**
     * Teste do metodo buscarAlunos da classe GrupoDao.
     */
    @Test
    public void testBuscarAlunos() throws Exception {
        int idGrupo = 0;
        GrupoDao instance = GrupoDao.getInstance();
        List<Aluno> result = instance.buscarAlunos(idGrupo);
        assertNotNull(result);
    }

    /**
     * Teste do metodo deleteAlunos da classe GrupoDao.
     */
    @Test
    public void testDeleteAlunos() throws Exception {
        int idGrupo = 0;
        GrupoDao instance = GrupoDao.getInstance();
        instance.deleteAlunos(idGrupo);
    }
    
}
