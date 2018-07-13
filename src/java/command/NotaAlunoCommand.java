package command;

import classe.Aluno;
import classe.Grupo;
import dao.AlunoDao;
import dao.GrupoDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.InitialService;
import service.RetornaPaginaService;

public class NotaAlunoCommand implements Command {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {            
            try {
     
                RetornaPaginaService retornaPaginaService = new RetornaPaginaService(request, response);
                int idGrupo = Integer.parseInt(request.getParameter("cbGrupo"));
          
                retornaPaginaService.retornaNotaAluno(idGrupo); 
                       
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NotaAlunoCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(NotaAlunoCommand.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
