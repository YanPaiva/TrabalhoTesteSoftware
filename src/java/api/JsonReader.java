/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import classe.Grupo;
import classe.Aluno;
import classe.Atividade;
import classe.Disciplina;
import dao.AlunoDao;
import dao.AtividadeDao;
import dao.DisciplinaDao;
import dao.GrupoDao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import service.InitialService;
/**
 *
 * @author fernanda
 */
public class JsonReader {
    
    private static Disciplina DISCIPLINA = Disciplina.getInstance();
    private static String URL = "http://localhost:3000/";
    private static String URL_GRUPO = URL + "grupos?id_atividade=%d";
    private static String URL_ATIVIDADE = URL + "atividades/%d";
    private static String URL_DISCIPLINA = URL + "disciplinas/%d";
    
    public static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream(),"UTF8"));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);

        in.close();

        return response.toString();
    }

    public static void getGrupos(int idAtividade) throws Exception{
       
        JSONObject obj = new JSONObject(getText(String.format(URL_GRUPO, idAtividade)));
        
        GrupoDao grupoDao = GrupoDao.getInstance();
        AlunoDao alunoDao = AlunoDao.getInstance();
        JSONArray jsonArray= obj.getJSONArray("grupos"); 

        for(int i=0;i<jsonArray.length();i++){
            JSONObject grupoObj= jsonArray.getJSONObject(i); 
            ArrayList<Aluno> alunos = new ArrayList<>();
            JSONArray alunosJsonArray= grupoObj.getJSONArray("alunos");            
            for(int j=0;j<alunosJsonArray.length();j++){
                JSONObject alunoObj = alunosJsonArray.getJSONObject(j);                 
                alunos.add(alunoDao.buscar(alunoObj.getInt("id")));
            }       
            
            Grupo grupo = new Grupo(grupoObj.getInt("id"), idAtividade, grupoObj.getString("nome"), alunos);
            
            if(grupoDao.buscar(grupo.getIdGrupoServidor()) == null){
               grupoDao.salvar(grupo);              
            }else{
               grupoDao.alterar(grupo); 
            } 
            
            DISCIPLINA.getAtividade().setGrupos(grupo);

        }
    }
    
    public static void getAtividade(int idAtividade) throws Exception{
        
        AtividadeDao atividadeDao = AtividadeDao.getInstance();
        JSONObject obj = new JSONObject(getText(String.format(URL_ATIVIDADE, idAtividade)));
 
        DISCIPLINA.setAtividade(new Atividade(idAtividade, obj.getString("descricao")));
 
        if(atividadeDao.buscar(DISCIPLINA.getAtividade().getIdAtividadeServidor()) == null){
            atividadeDao.salvar(DISCIPLINA.getAtividade());              
        }else{
            atividadeDao.alterar(DISCIPLINA.getAtividade());
        }
    }
  
    public static void getDisciplina(int idDisciplina) throws Exception{
    
        AlunoDao alunoDao = AlunoDao.getInstance();
        DisciplinaDao disciplinaDao = DisciplinaDao.getInstance();
        JSONObject obj = new JSONObject(getText(String.format(URL_DISCIPLINA, idDisciplina)));
        
        DISCIPLINA.setDisciplina(obj.getString("disciplina"));
        DISCIPLINA.setIdDisciplinaServidor(idDisciplina);
        
        if(disciplinaDao.buscar(idDisciplina)){
            disciplinaDao.alterar(DISCIPLINA);
        }else{
            disciplinaDao.salvar(DISCIPLINA);
        }
        
        JSONArray alunosJsonArray = obj.getJSONArray("alunos");
        
        for(int i=0;i<alunosJsonArray.length();i++){
            JSONObject alunoObj= alunosJsonArray.getJSONObject(i); 
            Aluno aluno = new Aluno(alunoObj.getInt("id"), alunoObj.getString("nome"));
            
            if(alunoDao.buscar(aluno.getIdAlunoServidor()) == null){
               alunoDao.salvar(aluno);
            }else{
                alunoDao.alterar(aluno);
            }
            
            DISCIPLINA.setAlunos(aluno);
        }
    }
  
}
