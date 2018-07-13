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
    
    private boolean EDITAR;
    private boolean SALVAR;
    
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {

            try {
                
                configuracoes();
                
                RetornaPaginaService retornaPaginaService = new RetornaPaginaService(request, response);                
                retornaPaginaService.retornaIndex();
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IndexCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(IndexCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(IndexCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
    
    private void configuracoes(){
        try{
            
            if(InitialService.CONFIGURAR){
                InitialService.configuracoesIniciais();   
            } 
            
            if(InitialService.LER_ARQ_LOCAL){
                InitialService intialService = new InitialService(); 
                intialService.getDisciplina(InitialService.DISCIPLINA_ID);
                intialService.getAtividade(InitialService.ATIVIDADE_ID);
                intialService.getGrupos(InitialService.ATIVIDADE_ID);

            }else{
                InitialService.lerDadosIniciais();
            }   
        
        } catch (Exception ex) {
            Logger.getLogger(IndexCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
