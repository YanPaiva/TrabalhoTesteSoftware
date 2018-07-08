/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import api.JsonReader;
import java.util.logging.Logger;

/**
 *
 * @author fernanda
 */
public class DisciplinaService {
 
    public static int ATIVIDADE_ID=10;
    public static int DISCIPLINA_ID=15;
    
    public static void lerDadosIniciais(){
        try {
            JsonReader.getAtividade(ATIVIDADE_ID);
            JsonReader.getDisciplina(DISCIPLINA_ID);
            JsonReader.getGrupos(ATIVIDADE_ID);
        } catch (Exception ex) {
            Logger.getLogger("Erro ao tentar ler json inicial.");
        }
    }
    
}
