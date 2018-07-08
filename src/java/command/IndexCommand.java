package command;

import api.JsonReader;
import classe.Grupo;
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
import service.DisciplinaService;

public class IndexCommand implements Command {
    
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {

            try {
                
                GrupoDao grupoDao = GrupoDao.getInstance();
                List<Grupo> grupos = grupoDao.buscarTodos(DisciplinaService.ATIVIDADE_ID);
                
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/notaGrupo.jsp");
                
                request.setAttribute("disciplina","Editar Notas");
                request.setAttribute("atividade","Editar Notas");
                request.setAttribute("titulo","Editar Notas");
                request.setAttribute("todosGrupos", grupos);
                
                dispachante.forward(request, response);
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IndexCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(IndexCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
