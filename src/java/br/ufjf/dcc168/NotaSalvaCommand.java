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
               
                GrupoDao.setNota(Double.parseDouble( request.getParameter("txtNota")));
                GrupoDao.setNotaAlunos(Double.parseDouble( request.getParameter("txtNota")));
                request.setAttribute("titulo",
                        "Pagina inicial");
                
                for (Aluno a : GrupoDao.getInstace()) {
                    System.out.println(a.getNome()+"+"+a.getNota());
                }
                
                dispachante.forward(request, response);
            }else{
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/notaAlunos.jsp");
                request.setAttribute("titulo",
                        "Pagina inicial");
                dispachante.forward(request, response);
            }
        }

    }

}
