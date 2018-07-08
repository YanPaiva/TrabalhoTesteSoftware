/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import command.Command;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author YanNotebook
 */
@WebServlet(name = "NotaServlet", urlPatterns = {"/index.jsp", "/notaSalva.jsp", "/notaSalvaAluno.jsp"})
public class NotaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/index.jsp", "command.IndexCommand");
        
        String className = rotas.get(request.getServletPath());
        try {
            Command comando = (Command) Class.forName("command.IndexCommand").newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException ex) {
            response.sendError(500, "erro.  " + ex);
            Logger.getLogger(NotaServlet.class.getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(NotaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NotaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/notaSalva.jsp", "command.NotaSalvaCommand");
        rotas.put("/notaSalvaAluno.jsp", "command.NotaSalvaAlunoCommand");

        String clazzName = rotas.get(request.getServletPath());
        try {
            Command comando = (Command) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException ex) {
            response.sendError(500, "erro.  " + ex);
            Logger.getLogger(NotaServlet.class.getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(NotaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NotaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
