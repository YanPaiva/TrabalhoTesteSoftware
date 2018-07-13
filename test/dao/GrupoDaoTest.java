/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Aluno;
import classe.Grupo;
import static dao.Dados.ALUNOS;
import static dao.Dados.ALUNO_3;
import static dao.Dados.ATIVIDADE_ID;
import static dao.Dados.GRUPO;
import static dao.Dados.GRUPO_DAO;
import static dao.Dados.GRUPO_SEM_NOTA;
import java.util.ArrayList;
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
        assertNotNull(GRUPO_DAO);
    }

    /**
     * Teste do metodo salvar da classe GrupoDao.
     */
    @Test
    public void testSalvar() throws Exception {
        
        if(GRUPO_DAO.buscar(GRUPO.getIdGrupoServidor())== null){
            GRUPO_DAO.salvar(GRUPO);
        }else{
            GRUPO_DAO.alterar(GRUPO);
        }
    }

    /**
     * Teste do metodo salvarSemNota da classe GrupoDao.
     */
    @Test
    public void testSalvarSemNota() throws Exception {
     
        if(GRUPO_DAO.buscar(GRUPO_SEM_NOTA.getIdGrupoServidor())== null){
            GRUPO_DAO.salvarSemNota(GRUPO_SEM_NOTA);
        }else{
            GRUPO_DAO.alterar(GRUPO_SEM_NOTA);
        }
    }

    /**
     * Teste do metodosalvarAlunos da classe GrupoDao.
     */
    @Test
    public void testSalvarAlunos() throws Exception {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(ALUNO_3);

        GRUPO_DAO.salvarAlunos(alunos, GRUPO_SEM_NOTA.getIdGrupoServidor());
    }

    /**
     * Teste do metodo alterarAlunos da classe GrupoDao.
     */
    @Test
    public void testAlterarAlunos() throws Exception {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(ALUNO_3);
        GRUPO_DAO.alterarAlunos(alunos, GRUPO.getIdGrupoServidor());
    }

    /**
     * Teste do metodo alterar da classe GrupoDao.
     */
    @Test
    public void testAlterar_Grupo() throws Exception {
        GRUPO_SEM_NOTA.setNota(90);
        GRUPO_DAO.alterar(GRUPO_SEM_NOTA);
    }

        /**
     * Teste do metodo buscar da classe GrupoDao.
     */
    @Test
    public void testBuscar() throws Exception {
        Grupo result = GRUPO_DAO.buscar(GRUPO.getIdGrupoServidor());
        
        if(result != null){
            boolean id = (GRUPO.getIdGrupoServidor() == result.getIdGrupoServidor());
            boolean atividade = (GRUPO.getIdAtividadeServidor()== result.getIdAtividadeServidor());
            boolean nota = (GRUPO.getNota()== result.getNota());
            boolean nome = (GRUPO.getNome().equals(result.getNome()));

            assertTrue(id && atividade && nota && nome);
        }
 
    }
    
    /**
     * Teste do metodo alterar da classe GrupoDao.
     */
    @Test
    public void testAlterar_int_double() throws Exception {
        GRUPO_DAO.alterar(GRUPO.getIdGrupoServidor(), 8);
    }



    /**
     * Teste do metodo buscarTodos da classe GrupoDao.
     */
    @Test
    public void testBuscarTodos() throws Exception {
        List<Grupo> result = GRUPO_DAO.buscarTodos(ATIVIDADE_ID);
        assertNotNull(result);
    }

    /**
     * Teste do metodo buscarAlunos da classe GrupoDao.
     */
    @Test
    public void testBuscarAlunos() throws Exception {
        List<Aluno> result = GRUPO_DAO.buscarAlunos(GRUPO.getIdGrupoServidor());
        assertNotNull(result);
    }

    /**
     * Teste do metodo deleteAlunos da classe GrupoDao.
     */
    @Test
    public void testDeleteAlunos() throws Exception {
        GRUPO_DAO.deleteAlunos(GRUPO.getIdGrupoServidor());
    }
    
}
