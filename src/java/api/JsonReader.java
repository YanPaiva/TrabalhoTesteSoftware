/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import classe.Grupo;
import classe.Aluno;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author fernanda
 */
public class JsonReader {
    
    private static String URL = "http://localhost:3000/";
    private static String URL_GRUPO = URL + "grupos";
    
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

    public static List<Grupo> getGrupos() throws Exception{
        JSONArray jsonArray=new JSONArray(getText(URL_GRUPO)); 
        List<Grupo> grupos = new ArrayList<>();
        
        //iterate loop
        for(int i=0;i<jsonArray.length();i++){
            JSONObject obj= jsonArray.getJSONObject(i); 
            int id = obj.getInt("id");
            String nome = obj.getString("nome");
            double nota = obj.getDouble("nota");
            String feedback = obj.getString("feedback");
            
            ArrayList<Aluno> alunos = new ArrayList<>();
            JSONArray alunosJsonArray= obj.getJSONArray("alunos");
            
            for(int j=0;j<alunosJsonArray.length();j++){
                JSONObject alunoObj = jsonArray.getJSONObject(j); 
                int idAluno = alunoObj.getInt("id");
                String nomeAluno = alunoObj.getString("nome");
                double notaAluno = alunoObj.getDouble("nota");
                
                alunos.add(new Aluno(idAluno, nomeAluno, notaAluno));
            }       
                      
            grupos.add(new Grupo(id, nome, nota, alunos));
        }
        
        return grupos;
    }
}
