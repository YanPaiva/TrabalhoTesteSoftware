/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Atividade;
import classe.Disciplina;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernanda
 */
public class AtividadeDao {
    private static AtividadeDao instance;
    
    public AtividadeDao(){}
    
    public static AtividadeDao getInstance(){
        if(instance == null)
            instance = new AtividadeDao();
        return instance;
    }
    
    public void salvar(Atividade atividade) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        
        try {
            
            String sql = "INSERT INTO atividade (id_atividade, id_disciplina,  descricao) "
                       + "VALUES (%d , %d , '%s')";
            sql = String.format(sql, atividade.getIdAtividadeServidor(), Disciplina.getInstance().getIdDisciplinaServidor(), atividade.getDescricao());
            
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
        
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
    }
    
    public void alterar(Atividade atividade) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "UPDATE atividade SET id_disciplina=%d, descricao='%s' WHERE id_atividade=%d" ;
            sql = String.format(sql, Disciplina.getInstance().getIdDisciplinaServidor(), atividade.getDescricao(), atividade.getIdAtividadeServidor());
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
            
                        
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
        
    }
    
    public Atividade buscar(int idAtividade) throws ClassNotFoundException, SQLException {
        Atividade atividade = null;
        Connection conn = null;
        Statement st = null;
        
        try {
                       
            String sql = String.format("SELECT * FROM atividade WHERE id_atividade=%d", idAtividade);
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    

            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                atividade = new Atividade(idAtividade, rs.getString("descricao"));
            }
            
                        
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
        
        return atividade;
    }
    
    public List<Atividade> buscarTodos() throws ClassNotFoundException, SQLException {
        List<Atividade> atividades = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        
        try {
            String query = "SELECT * FROM atividade";
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                Atividade atividade = new Atividade(rs.getInt("id_atividade"), rs.getString("descricao"));
                atividades.add(atividade);            
            }

        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
        
        return atividades;
    }

}
