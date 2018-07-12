/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import classe.Grupo;
import dao.GrupoDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernanda
 */
public class RetornaPaginaService {
    
    private final  static String CAMINHO = "/WEB-INF/";
    private final HttpServletRequest request;
    private final  HttpServletResponse response;

    public RetornaPaginaService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
     
    private void PreenchaDadosIndex(String disciplina, String atividade, List<Grupo> grupos){
        request.setAttribute("disciplina", disciplina);
        request.setAttribute("atividade", atividade);
        request.setAttribute("todosGrupos", grupos);
    }
    
    public int retornaIdGrupo(){
        String idGrupoString = request.getParameter("cbGrupo");
        int idGrupo = 0;
        
        if(idGrupoString != null && !idGrupoString.isEmpty())
            idGrupo = Integer.parseInt(idGrupoString);
        else
            idGrupo = -1;
        
        return idGrupo;    
    } 
    
    public void RetornaIndex(String disciplina, String atividade, List<Grupo> grupos, int idGrupo) 
            throws ClassNotFoundException, SQLException{
        try {
           
            RequestDispatcher dispachante = request.getRequestDispatcher(CAMINHO + "index.jsp");
            
            if(idGrupo > 0){
                GrupoDao grupoDao = GrupoDao.getInstance();
                Grupo grupo = grupoDao.buscar(idGrupo);
                request.setAttribute("alunos", grupo.getAlunos());
                request.setAttribute("nota", grupo.getNota());
            }
          
            request.setAttribute("idGrupo", idGrupo);
            PreenchaDadosIndex(disciplina, atividade, grupos);
            dispachante.forward(request, response);

        } catch (ServletException ex) {
            Logger.getLogger(RetornaPaginaService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RetornaPaginaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void RetornaNotaAluno(int idGrupo) 
            throws ClassNotFoundException, SQLException{
        try {
           
            RequestDispatcher dispachante = request.getRequestDispatcher(CAMINHO + "notaAluno.jsp");
            
            GrupoDao grupoDao = GrupoDao.getInstance();
            Grupo grupo = grupoDao.buscar(idGrupo);
            request.setAttribute("alunos", grupo.getAlunos());          
            request.setAttribute("idGrupo", idGrupo);
            
            dispachante.forward(request, response);

        } catch (ServletException ex) {
            Logger.getLogger(RetornaPaginaService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RetornaPaginaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
