/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import api.JsonReader;
import classe.Aluno;
import classe.Atividade;
import classe.Disciplina;
import classe.Grupo;
import dao.AlunoDao;
import dao.AtividadeDao;
import dao.DisciplinaDao;
import dao.GrupoDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author fernanda
 */
public class InitialService {
 
    public static boolean LER_ARQ_LOCAL=true;
    public static String NAME_ARQ_LOCAL = "atividades.json";
    public static boolean CONFIGURAR=true;
    public static int ATIVIDADE_ID=10;
    public static int DISCIPLINA_ID=15;
    public static Map<String, String> ROTAS = new HashMap<>();
        
    public InitialService(){}
    
    public static void lerDadosIniciais(){

        try {
            Disciplina.getInstance().setIdDisciplinaServidor(DISCIPLINA_ID);
            JsonReader.getDisciplina(DISCIPLINA_ID);
            JsonReader.getAtividade(ATIVIDADE_ID);
            JsonReader.getGrupos(ATIVIDADE_ID);
        } catch (Exception ex) {
            Logger.getLogger("Erro ao tentar ler json inicial.");
        }
        
        
    }
    
    public static void configuracoesIniciais(){   
        ROTAS.put("/notaAluno.jsp", "command.NotaAlunoCommand");
        ROTAS.put("/index.jsp", "command.IndexCommand");
        
        CONFIGURAR=false;
    }    
    
    public void getGrupos(int idAtividade) throws Exception{
               
        GrupoDao grupoDao = GrupoDao.getInstance();
        AlunoDao alunoDao = AlunoDao.getInstance();
  
        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(alunoDao.buscar(1));
        alunos.add(alunoDao.buscar(2));
        Grupo grupo = new Grupo(1, idAtividade, "GRUPO 1", alunos);

        if(grupoDao.buscar(grupo.getIdGrupoServidor()) == null){
           grupoDao.salvarSemNota(grupo);              
        }else{
           grupoDao.alterar(grupo); 
        } 

        Disciplina.getInstance().getAtividade().setGrupos(grupo);
        
    }
    
    public void getAtividade(int idAtividade) throws Exception{
        
        AtividadeDao atividadeDao = AtividadeDao.getInstance();
 
        Disciplina.getInstance().setAtividade(new Atividade(idAtividade, "ATIVIDADE 1"));
 
        if(atividadeDao.buscar(Disciplina.getInstance().getAtividade().getIdAtividadeServidor()) == null){
            atividadeDao.salvar(Disciplina.getInstance().getAtividade());              
        }else{
            atividadeDao.alterar(Disciplina.getInstance().getAtividade());
        }
    }

    public void getDisciplina(int idDisciplina) throws Exception{
              
        AlunoDao alunoDao = AlunoDao.getInstance();
        DisciplinaDao disciplinaDao = DisciplinaDao.getInstance();
        
        Disciplina.getInstance().setDisciplina("TESTE");
        Disciplina.getInstance().setIdDisciplinaServidor(idDisciplina);
        
        if(disciplinaDao.buscar(idDisciplina)){
            disciplinaDao.alterar(Disciplina.getInstance());
        }else{
            disciplinaDao.salvar(Disciplina.getInstance());
        }
        
        
        for(int i=1;i<3;i++){

            Aluno aluno = new Aluno(i, "ALUNO "+i);
            
            if(alunoDao.buscar(aluno.getIdAlunoServidor()) == null){
               alunoDao.salvar(aluno);
            }else{
                alunoDao.alterar(aluno);
            }
            
            Disciplina.getInstance().setAlunos(aluno);
        }
    }
}
