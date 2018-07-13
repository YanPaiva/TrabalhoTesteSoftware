/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Aluno;
import static dao.Dados.ALUNO_1;
import static dao.Dados.ALUNO_2;
import static dao.Dados.ALUNO_DAO;
import static dao.Dados.ATIVIDADE_ID;
import java.util.List;
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
               
        if(ALUNO_DAO.buscar(ALUNO_1.getIdAlunoServidor()) == null){
            ALUNO_DAO.salvar(ALUNO_1);
            ALUNO_DAO.insereNota(ALUNO_1, ATIVIDADE_ID);            
        }else{
            ALUNO_DAO.alterar(ALUNO_1);
            ALUNO_DAO.atualizaNota(ALUNO_1, ATIVIDADE_ID);
        }
            
    }

    /**
     * Teste do metodo buscar da classe AlunoDao.
     */
    @Test
    public void testBuscar_int() throws Exception {
        Aluno result = Dados.ALUNO_DAO.buscar(ALUNO_1.getIdAlunoServidor());
        
        boolean id = (ALUNO_1.getIdAlunoServidor() == result.getIdAlunoServidor());
        boolean nome = (ALUNO_1.getNome().equals(result.getNome()));
                
        assertTrue(id && nome);
    }

    /**
     * Teste do metodo buscar da classe AlunoDao.
     */
    @Test
    public void testBuscar_int_int() throws Exception {
        Aluno result = ALUNO_DAO.buscar(ALUNO_1.getIdAlunoServidor(), ATIVIDADE_ID);
        
        boolean id = (ALUNO_1.getIdAlunoServidor() == result.getIdAlunoServidor());
        boolean nome = (ALUNO_1.getNome().equals(result.getNome()));
        boolean nota = (ALUNO_1.getNota()== result.getNota());
                
        assertTrue(id && nome && nota);
    }

    /**
     * Teste do metodo buscarTodos de classe AlunoDao.
     */
    @Test
    public void testBuscarTodos() throws Exception {
        List<Aluno> result = ALUNO_DAO.buscarTodos();
        assertNotNull(result);
    }

    /**
     * Teste do metodo alterar da classe AlunoDao.
     */
    @Test
    public void testAlterar() throws Exception {
        
        if(ALUNO_DAO.buscar(ALUNO_2.getIdAlunoServidor()) == null){
            ALUNO_DAO.salvar(ALUNO_2);
        }
        
        ALUNO_2.setNota(85);
        ALUNO_DAO.alterar(ALUNO_2);
    }
    
}
