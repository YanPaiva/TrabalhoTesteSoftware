package br.ufjf.dcc168;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class NotaSalvaAlunoCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            int numGrupo = Integer.parseInt(request.getParameter("cbGrupo"));
            int idAluno = Integer.parseInt(request.getParameter("idAluno"));
            double novaNota= Double.parseDouble(request.getParameter("txtNota"));
            GrupoDao.getInstace();
            //ta 0 por que até então só colocamos uma nota
            // temos que ver como tratar pra identificar ql nota desejamos trocar
            GrupoDao.getInstace().get(numGrupo).getInstace().get(idAluno).setNotaExist(novaNota, 0);
            RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/notaAlunos.jsp");
            request.setAttribute("grupo", GrupoDao.getInstace().get(numGrupo).getInstace());
            request.setAttribute("nota", GrupoDao.getGrupoDesejado(numGrupo).getNota());
            System.out.println("nova nota do aluno é "+GrupoDao.getInstace().
                    get(numGrupo).getInstace().get(idAluno).getNota(0));
            request.setAttribute("titulo",
                    "Pagina inicial");
            request.setAttribute("cbGrupo", numGrupo);
            dispachante.forward(request, response);
        }
    }

}
