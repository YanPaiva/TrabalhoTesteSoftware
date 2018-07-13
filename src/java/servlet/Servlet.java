/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import command.Command;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.InitialService;
import static service.InitialService.ROTAS;

/**
 *
 * @author YanNotebook
 */
@WebServlet(name = "Servlet", urlPatterns = {"/index.jsp", "/notaSalva.jsp", "/notaAluno.jsp"})
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
                
        configuraComando(request, response);        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        configuraComando(request, response);
    }

    private void configuraComando(HttpServletRequest request, HttpServletResponse response){
        try {
            boolean EDITAR = (request.getParameter("btnEditarNotas") != null);
            String className = request.getServletPath();
            
            if(InitialService.CONFIGURAR){
                InitialService.configuracoesIniciais();
            }
                    
            if(EDITAR){
                className = "/notaAluno.jsp";
            }
            
            Command comando = (Command) Class.forName(ROTAS.get(className)).newInstance();
            comando.exec(request, response);
            
        } catch (Exception ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
