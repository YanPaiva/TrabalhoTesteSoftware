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
public class GrupoTest {
    
    /**
     * Teste do metodo getIdGrupoServidor da classe Grupo.
     */
    @Test
    public void testGetIdGrupoServidor() {
        Grupo grupo = new Grupo(2,3,"grupo 6", 90.0);
        int expResult = 2;
        int result = grupo.getIdGrupoServidor();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setIdGrupoServidor da classe Grupo.
     */
    @Test
    public void testSetIdGrupoServidor() {
        int idGrupoServidor = 0;
        Grupo grupo = new Grupo(2,3,"grupo 6", 90.0);
        grupo.setIdGrupoServidor(idGrupoServidor);
        assertEquals(idGrupoServidor, grupo.getIdGrupoServidor());
    }

    /**
     * Teste do metodo getNome da classe Grupo.
     */
    @Test
    public void testGetNome() {
        Grupo grupo = new Grupo(2,3,"grupo 6", 90.0);
        String expResult = "grupo 6";
        String result = grupo.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setNome da classe Grupo.
     */
    @Test
    public void testSetNome() {
        String nome = "";
        Grupo grupo = new Grupo(2,3,"grupo 6", 90.0);
        grupo.setNome(nome);
    }

    /**
     * Teste do metodo getNota da classe Grupo.
     */
    @Test
    public void testGetNota() {
        Grupo grupo = new Grupo(2,3,"grupo 6", 90.0);
        double expResult = 90.0;
        double result = grupo.getNota();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Teste do metodo setNota da classe Grupo.
     */
    @Test
    public void testSetNota() {
        double nota = 0.0;
        Grupo grupo = new Grupo(2,3,"grupo 6", 90.0);
        grupo.setNota(nota);
    }

    /**
     * Teste do metodo getAlunos da classe Grupo.
     */
    @Test
    public void testGetAlunos() {
        Grupo grupo = new Grupo(2,3,"grupo 6", 90.0);
        List<Aluno> expResult = null;
        List<Aluno> result = grupo.getAlunos();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setAlunos da classe Grupo.
     */
    @Test
    public void testSetAlunos_Aluno() {
        Aluno aluno = new Aluno(5,"Ana");
        Grupo grupo = new Grupo(2,3,"grupo 6", 90.0);
        grupo.setAluno(aluno);
    }

    /**
     * Teste do metodo setAlunos da classe Grupo.
     */
    @Test
    public void testSetAlunos_List() {
        List<Aluno> alunos = null;
        Grupo grupo = new Grupo(2,3,"grupo 6", 90.0);
        grupo.setAlunos(alunos);
    }

    /**
     * Teste do metodo getIdAtividadeServidor da classe Grupo.
     */
    @Test
    public void testGetIdAtividadeServidor() {
        Grupo grupo = new Grupo(2,3,"grupo 6", 90.0);
        int expResult = 3;
        int result = grupo.getIdAtividadeServidor();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setIdAtividadeServidor da classe Grupo.
     */
    @Test
    public void testSetIdAtividadeServidor() {
        int idAtividadeServidor = 0;
        Grupo grupo = new Grupo(2,3,"grupo 6", 90.0);
        grupo.setIdAtividadeServidor(idAtividadeServidor);
        assertEquals(idAtividadeServidor,grupo.getIdAtividadeServidor());
    }
    
}
