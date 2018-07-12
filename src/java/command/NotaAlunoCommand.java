package command;

import classe.Grupo;
import dao.GrupoDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotaAlunoCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            Grupo grupo;
            String idGrupoString = request.getParameter("cbGrupo");
            /*try {
                
                int idGrupo = Integer.parseInt(request.getParameter("idGrupo"));
                GrupoDao grupoDao = GrupoDao.getInstance();
                grupo = grupoDao.buscar(idGrupo);
                
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/notaAlunos.jsp");
                request.setAttribute("grupo", grupo);
                request.setAttribute("alunos", grupo.getAlunos());
                request.setAttribute("titulo", "Editor de Nota");
                dispachante.forward(request, response);
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NotaAlunoCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(NotaAlunoCommand.class.getName()).log(Level.SEVERE, null, ex);
            }*/

        }
    }

}
