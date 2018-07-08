package command;

import classe.Aluno;
import dao.GrupoDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotaSalvaCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {            
            try {
                int idGrupo = Integer.parseInt(request.getParameter("cbGrupo"));
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/notaSalva.jsp");
                GrupoDao grupoDao = GrupoDao.getInstance();  
                grupoDao.alterar(idGrupo, Double.parseDouble(request.getParameter("txtNota")));
                request.setAttribute("titulo","Pagina inicial");       
                dispachante.forward(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NotaSalvaCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(NotaSalvaCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }

    }

}
