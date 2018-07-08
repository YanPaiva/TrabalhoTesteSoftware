/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

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
public class DisciplinaTest {

    /**
     * Teste do metodo getIdDisciplinaServidor da classe Disciplina.
     */
    @Test
    public void testGetIdDisciplinaServidor() {
        Disciplina disciplina = new Disciplina();
        int expResult = 0;
        int result = disciplina.getIdDisciplinaServidor();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setIdDisciplinaServidor da classe Disciplina.
     */
    @Test
    public void testSetIdDisciplinaServidor() {
        int idDisciplinaServidor = 0;
        Disciplina disciplina = new Disciplina();
        disciplina.setIdDisciplinaServidor(idDisciplinaServidor);
        assertEquals(idDisciplinaServidor,disciplina.getIdDisciplinaServidor());
    }

    /**
     * Teste do metodo getDisciplina da classe Disciplina.
     */
    @Test
    public void testGetDisciplina() {
        Disciplina disciplina = new Disciplina();
        String expResult = null;
        String result = disciplina.getDisciplina();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setDisciplina da classe Disciplina.
     */
    @Test
    public void testSetDisciplina() {
        String descricao = "descricao 1";
        Disciplina disciplina = new Disciplina();
        disciplina.setDisciplina(descricao);
        assertEquals(descricao,disciplina.getDisciplina());
    }

    /**
     * Teste do metodo getAtividade da classe Disciplina.
     */
    @Test
    public void testGetAtividade() {
        Disciplina disciplina = new Disciplina();
        Atividade expResult = null;
        Atividade result = disciplina.getAtividade();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setAtividade da classe Disciplina.
     */
    @Test
    public void testSetAtividade() {
        Atividade atividade = null;
        Disciplina disciplina = new Disciplina();
        disciplina.setAtividade(atividade);
    }

    /**
     * Teste do metodo getAlunos da classe Disciplina.
     */
    @Test
    public void testGetAlunos() {
        Disciplina disciplina = new Disciplina();;
        List<Aluno> expResult = null;
        List<Aluno> result = disciplina.getAlunos();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setAlunos da classe Disciplina.
     */
    @Test
    public void testSetAlunos_List() {
        List<Aluno> alunos = null;
        Disciplina disciplina = new Disciplina();
        disciplina.setAlunos(alunos);
    }

    /**
     * Teste do metodo setAlunos da classe Disciplina.
     */
    @Test
    public void testSetAlunos_Aluno() {
        Aluno aluno = null;
        Disciplina disciplina = new Disciplina();
        disciplina.setAlunos(aluno);
    }
    
}
