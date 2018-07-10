package command;

import classe.Disciplina;
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
import service.InitialService;

public class IndexCommand implements Command {
    
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {

            try {
                InitialService.lerDadosIniciais();
                InitialService.configuracoesIniciais();
                
                GrupoDao grupoDao = GrupoDao.getInstance();
                List<Grupo> grupos = grupoDao.buscarTodos(InitialService.ATIVIDADE_ID);
                
                RequestDispatcher dispachante = request.getRequestDispatcher("/WEB-INF/index.jsp");
                request.setAttribute("disciplina",Disciplina.getInstance().getDisciplina());
                request.setAttribute("atividade",Disciplina.getInstance().getAtividade().getDescricao());
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
