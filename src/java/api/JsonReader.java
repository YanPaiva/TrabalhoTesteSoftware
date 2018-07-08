/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import classe.Grupo;
import classe.Aluno;
import classe.Atividade;
import dao.AlunoDao;
import dao.AtividadeDao;
import dao.GrupoDao;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author fernanda
 */
public class JsonReader {
    
    private static String URL = "http://localhost:3000/";
    private static String URL_GRUPO = URL + "grupos";
    private static String URL_ATIVIDADE = URL + "atividade";
    private static String URL_ALUNO = URL + "alunos";
    
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

    public static void getGrupos() throws Exception{
        JSONArray jsonArray=new JSONArray(getText(URL_GRUPO)); 
        GrupoDao grupoDao = GrupoDao.getInstance();

        for(int i=0;i<jsonArray.length();i++){
            JSONObject obj= jsonArray.getJSONObject(i); 
            int id = obj.getInt("id");
            String nome = obj.getString("nome");
            double nota = obj.getDouble("nota");
            
            ArrayList<Aluno> alunos = new ArrayList<>();
            JSONArray alunosJsonArray= obj.getJSONArray("alunos");
            
            for(int j=0;j<alunosJsonArray.length();j++){
                JSONObject alunoObj = jsonArray.getJSONObject(j); 
                int idAluno = alunoObj.getInt("id");
                String nomeAluno = alunoObj.getString("nome");
                double notaAluno = alunoObj.getDouble("nota");
                
                alunos.add(new Aluno(idAluno, nomeAluno, notaAluno));
            }       
                      
            grupoDao.salvar(new Grupo(id, nome, nota, alunos));              
        }
    }
    
    public static void getAtividade() throws Exception{
        
        JSONObject obj =new JSONObject(getText(URL_ATIVIDADE)); 
        
        int id = obj.getInt("id");
        int idDisciplina = obj.getInt("id_disciplina");
        String disciplina = obj.getString("disciplina");
        String descricao = obj.getString("descricao");

        AtividadeDao atividadeDao = AtividadeDao.getInstance();
        atividadeDao.salvar(new Atividade(id, idDisciplina, disciplina, descricao));              
    }
  
    public static void getAlunos() throws Exception{
        JSONArray jsonArray=new JSONArray(getText(URL_ALUNO)); 
        AlunoDao alunoDao = AlunoDao.getInstance();

        for(int i=0;i<jsonArray.length();i++){
            JSONObject obj= jsonArray.getJSONObject(i); 
            int id = obj.getInt("id");
            String nome = obj.getString("nome");
            double nota = obj.getDouble("nota");
            
            alunoDao.salvar(new Aluno(id, nome, nota));
        }
    }
}
