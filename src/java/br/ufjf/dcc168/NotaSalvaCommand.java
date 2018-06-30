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
            int numGrupo = Integer.parseInt(request.getParameter("cbGrupo"));
            if (request.getParameter("btnSalvar") != null) {
                GrupoDao.getInstace();
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/notaSalva.jsp");

                GrupoDao.getGrupoDesejado(numGrupo).setNota(Double.parseDouble(request.getParameter("txtNota")));
                GrupoDao.getGrupoDesejado(numGrupo).setNotaAlunos(Double.parseDouble(request.getParameter("txtNota")));
                request.setAttribute("titulo",
                        "Pagina inicial");

                for (Aluno a : GrupoDao.getGrupoDesejado(numGrupo).getInstace()) {
                    System.out.println(a.getNome() + "+" + a.getNota());
                }

                dispachante.forward(request, response);
            } else {
                GrupoDao.getInstace();
                GrupoDao.getGrupoDesejado(numGrupo).setNota(Double.parseDouble(request.getParameter("txtNota")));
                GrupoDao.getGrupoDesejado(numGrupo).setNotaAlunos(Double.parseDouble(request.getParameter("txtNota")));
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/notaAlunos.jsp");

                request.setAttribute("grupo", GrupoDao.getInstace().get(numGrupo).getInstace());

                request.setAttribute("nota", GrupoDao.getGrupoDesejado(numGrupo).getNota());
               
                
                request.setAttribute("titulo",
                        "Pagina inicial");
                request.setAttribute("cbGrupo", numGrupo);
                dispachante.forward(request, response);
            }
        }

    }

}
