/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

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
public class AlunoTest {
    
    /**
     * Teste do metodo getIdALunoServidor da classe Aluno.
     */
    @Test
    public void testGetIdALunoServidor() {
        Aluno aluno = new Aluno(1,"Fred",15.00);
        int expResult = 1;
        int result = aluno.getIdAlunoServidor();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setIdALunoServidor da classe Aluno.
     */
    @Test
    public void testSetIdALunoServidor() {
        int idALunoServidor = 0;
        Aluno aluno = new Aluno(1,"Fred",15.00);
        aluno.setIdAlunoServidor(idALunoServidor);
        assertEquals(idALunoServidor,aluno.getIdAlunoServidor());
    }

    /**
     * Teste do metodo getNome da classe Aluno.
     */
    @Test
    public void testGetNome() {
        Aluno aluno = new Aluno(1,"Fred",15.00);
        String expResult = "Fred";
        String result = aluno.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Teste do metodo setNome da classe Aluno.
     */
    @Test
    public void testSetNome() {
        String nome = "Ana";
        Aluno aluno = new Aluno(1,"Fred",15.00);
        aluno.setNome(nome);
        assertEquals(nome,aluno.getNome());
    }

    /**
     * Teste do metodo getNota da classe Aluno.
     */
    @Test
    public void testGetNota() {
        Aluno aluno = new Aluno(1,"Fred",15.00);
        double expResult = 15.0;
        double result = aluno.getNota();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Teste do metodo setNota da classe Aluno.
     */
    @Test
    public void testSetNota() {
        double nota = 25.0;
        Aluno aluno = new Aluno(1,"Fred",15.00);
        aluno.setNota(nota);
        assertEquals(nota,aluno.getNota(),0.0);
    }
    
}
