package command;

import classe.Disciplina;
import classe.Grupo;
import dao.GrupoDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.InitialService;
import service.RetornaPaginaService;

public class IndexCommand implements Command {
    
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            if(InitialService.CONFIGURAR){
                InitialService.lerDadosIniciais();
                InitialService.configuracoesIniciais();
            }

            try {
                
                RetornaPaginaService retornaPaginaService = new RetornaPaginaService(request, response);
                GrupoDao grupoDao = GrupoDao.getInstance();
                List<Grupo> grupos = grupoDao.buscarTodos(InitialService.ATIVIDADE_ID);
                String atividade = Disciplina.getInstance().getAtividade().getDescricao();
                String disciplina = Disciplina.getInstance().getDisciplina();
                int idGrupo = retornaPaginaService.retornaIdGrupo();
                                 
                if(request.getParameter("btnSalvar") == null){
                    retornaPaginaService.RetornaIndex(disciplina, atividade, grupos, idGrupo);
                }else{
                    double nota =  Double.parseDouble(request.getParameter("txtNota"));
                    grupoDao.alterar(idGrupo, nota);   
                }
                
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IndexCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(IndexCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
    
}
