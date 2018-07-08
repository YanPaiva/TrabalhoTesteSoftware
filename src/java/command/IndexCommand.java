package command;

import dao.GrupoDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            try {
                GrupoDao grupoDao = GrupoDao.getInstance();
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/notaGrupo.jsp");
                
                request.setAttribute("titulo","Pagina inicial");
                request.setAttribute("todosGrupos", grupoDao.buscarTodos());
                
                dispachante.forward(request, response);
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IndexCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(IndexCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
