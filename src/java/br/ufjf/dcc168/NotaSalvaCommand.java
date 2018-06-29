package br.ufjf.dcc168;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class NotaSalvaCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            if (request.getParameter("btnSalvar") != null) {
                GrupoDao.getInstace();               
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/notaSalva.jsp");
                
                
                
                GrupoDao.getGrupoDesejado(0).setNota(Double.parseDouble( request.getParameter("txtNota")));
                GrupoDao.getGrupoDesejado(0).setNotaAlunos(Double.parseDouble( request.getParameter("txtNota")));
                request.setAttribute("titulo",
                        "Pagina inicial");
                
                for (Aluno a : GrupoDao.getGrupoDesejado(0).getInstace()) {
                    System.out.println(a.getNome()+"+"+a.getNota());
                }
                
                dispachante.forward(request, response);
            }else{
                GrupoDao.getInstace();               
                
                GrupoDao.getGrupoDesejado(0).setNota(Double.parseDouble( request.getParameter("txtNota")));
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/notaAlunos.jsp");
                
                request.setAttribute("grupo", GrupoDao.getInstace().get(0).getInstace());
                
                request.setAttribute("nota", GrupoDao.getGrupoDesejado(0).getNota());
                for (Aluno aluno : GrupoDao.getGrupoDesejado(0).getInstace()) {
                    System.out.println(aluno.getNome());
                }
                request.setAttribute("titulo",
                        "Pagina inicial");
                dispachante.forward(request, response);
            }
        }

    }

}
