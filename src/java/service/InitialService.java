/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import api.JsonReader;
import classe.Disciplina;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author fernanda
 */
public class InitialService {
 
    public static boolean CONFIGURAR=true;
    public static int ATIVIDADE_ID=10;
    public static int DISCIPLINA_ID=15;
    public static Map<String, String> ROTAS = new HashMap<>();
    
    public static void lerDadosIniciais(){
        
        Disciplina.getInstance().setIdDisciplinaServidor(DISCIPLINA_ID);
        
        try {
            JsonReader.getDisciplina(DISCIPLINA_ID);
            JsonReader.getAtividade(ATIVIDADE_ID);
            JsonReader.getGrupos(ATIVIDADE_ID);
        } catch (Exception ex) {
            Logger.getLogger("Erro ao tentar ler json inicial.");
        }
        
        CONFIGURAR=false;
    }
    
    public static void configuracoesIniciais(){   
        ROTAS.put("/notaAluno.jsp", "command.NotaAlunoCommand");
        ROTAS.put("/index.jsp", "command.IndexCommand");
    }
}
