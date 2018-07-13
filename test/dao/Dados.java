/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Aluno;
import classe.Atividade;
import classe.Disciplina;
import classe.Grupo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernanda
 */
public class Dados {
    public static AlunoDao ALUNO_DAO = AlunoDao.getInstance();
    public static DisciplinaDao DISCIPLINA_DAO = DisciplinaDao.getInstance();
    public static AtividadeDao ATIVIDADE_DAO = AtividadeDao.getInstance();
    public static GrupoDao GRUPO_DAO = GrupoDao.getInstance();
    
    public static int ATIVIDADE_ID = 1;
    public static Atividade ATIVIDADE = new Atividade(1,"atividade 1");
    public static Atividade ATIVIDADE_ALT = new Atividade(1,"atividade 2");
    
    public static Aluno ALUNO_1 = new Aluno(5,"Marta",55.00); 
    public static Aluno ALUNO_2 = new Aluno(8,"Henrique",55.00);
    public static Aluno ALUNO_3 = new Aluno(6,"Carol",10.00);
    
    public static Grupo GRUPO = new Grupo(8,1,"Grupo 8",8.00);
    public static Grupo GRUPO_SEM_NOTA = new Grupo(7,1,"Grupo 7",null);     

    public static Disciplina DISCIPLINA = Disciplina.getInstance();
    
    public static List<Aluno> ALUNOS = new ArrayList<>();
     
}
