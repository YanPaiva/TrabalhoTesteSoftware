/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import classe.Aluno;
import classe.Disciplina;
import classe.Grupo;
import dao.AlunoDao;
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
    
    public int retornaIdAluno(){
        String idAlunoString = request.getParameter("alunos");
        int idAluno = 0;
        
        if(idAlunoString != null && !idAlunoString.isEmpty())
            idAluno = Integer.parseInt(idAlunoString);
        else
            idAluno = -1;
        
        return idAluno;    
    }
    
    public double retornaNotaAluno(){
        String notaString = request.getParameter("txtNota");
        double nota = 0.0;
        
        if(notaString != null && !notaString.isEmpty())
            nota = Double.parseDouble(notaString);
        
        return nota;    
    }
    
    public void retornaIndex() 
            throws ClassNotFoundException, SQLException{

        boolean EDITAR = (request.getParameter("btnEditarNotas") != null);
        boolean SALVAR = (request.getParameter("btnSalvar") != null);
        
        try {
           
            GrupoDao grupoDao = GrupoDao.getInstance();
            List<Grupo> grupos = grupoDao.buscarTodos(InitialService.ATIVIDADE_ID);
            String atividade = Disciplina.getInstance().getAtividade().getDescricao();
            String disciplina = Disciplina.getInstance().getDisciplina();
            int idGrupo = retornaIdGrupo();

            if(EDITAR){
                retornaNotaAluno(idGrupo);
                return;
            }

            if(SALVAR){
                double nota =  Double.parseDouble(request.getParameter("txtNota"));
                grupoDao.alterar(idGrupo, nota);
                return;
            }
            
            
            if(idGrupo > 0){
                Grupo grupo = grupoDao.buscar(idGrupo);
                request.setAttribute("alunos", grupo.getAlunos());
                request.setAttribute("nota", grupo.getNota());
            }
          
            request.setAttribute("idGrupo", idGrupo);
            PreenchaDadosIndex(disciplina, atividade, grupos);
            RequestDispatcher dispachante = request.getRequestDispatcher(CAMINHO + "index.jsp");
            dispachante.forward(request, response);

        } catch (ServletException ex) {
            Logger.getLogger(RetornaPaginaService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RetornaPaginaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                
    
    public void retornaNotaAluno(int idGrupo) 
            throws ClassNotFoundException, SQLException{
        try {
            
            boolean SALVAR = (request.getParameter("btnSalvar") != null);

            if(SALVAR){
                salvarNotaAluno();
            }  
            
            int idAluno = retornaIdAluno();
            GrupoDao grupoDao = GrupoDao.getInstance();
            AlunoDao alunoDao = AlunoDao.getInstance();
            Grupo grupo = grupoDao.buscar(idGrupo);
            Aluno aluno = alunoDao.buscar(idAluno, InitialService.ATIVIDADE_ID);
            
            if(aluno != null){ 
                request.setAttribute("nota", aluno.getNota());
            }
            
            request.setAttribute("disciplina", Disciplina.getInstance().getDisciplina());
            request.setAttribute("atividade", Disciplina.getInstance().getAtividade().getDescricao());
            request.setAttribute("idAluno", idAluno);
            request.setAttribute("alunos", grupo.getAlunos());
            request.setAttribute("idGrupo", idGrupo);
            request.setAttribute("grupo", grupo);
            request.setAttribute("titulo", "Editor de Nota Individuais");                
            
            RequestDispatcher dispachante = request.getRequestDispatcher(CAMINHO + "notaAluno.jsp");
            dispachante.forward(request, response);

        } catch (ServletException ex) {
            Logger.getLogger(RetornaPaginaService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RetornaPaginaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvarNotaAluno()throws ClassNotFoundException, SQLException{
        int idAluno = retornaIdAluno();
        AlunoDao alunoDao = AlunoDao.getInstance();
        Aluno aluno = alunoDao.buscar(idAluno);
        aluno.setNota(retornaNotaAluno());
        alunoDao.atualizaNota(aluno, InitialService.ATIVIDADE_ID);
    }
   
}
