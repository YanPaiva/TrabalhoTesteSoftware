/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Disciplina;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernanda
 */
public class DisciplinaDao {

    private static DisciplinaDao instance;
    
    private DisciplinaDao(){}
    
    public static DisciplinaDao getInstance(){
        if(instance == null)
            instance = new DisciplinaDao();
        return instance;
    }

    public void salvar(Disciplina disciplina) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "INSERT INTO disciplina (id_disciplina, disciplina) "
                       + "VALUES (%d , '%s')";
            sql = String.format(sql, disciplina.getIdDisciplinaServidor(), disciplina.getDisciplina());
            
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
        
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
    }  
    
    public boolean buscar(int idDisciplina) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        
        try {
                       
            String sql = String.format("SELECT * FROM disciplina WHERE id_disciplina=%d", idDisciplina);
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next())
                return true;
                        
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
        
        return false;
    }
    
    public void alterar(Disciplina disciplina) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "UPDATE disciplina SET disciplina='%s' WHERE id_disciplina=%d" ;
            sql = String.format(sql, Disciplina.getInstance().getDisciplina(), Disciplina.getInstance().getIdDisciplinaServidor());
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
            
                        
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
    }
    
    public void dropAlll() throws ClassNotFoundException, SQLException{
        try {
                
            dropTable("atividade_aluno");
            dropTable("grupo_aluno");
            dropTable("aluno");
            dropTable("grupo");
            dropTable("atividade");
            dropTable("disciplina");
        
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public void dropTable(String table) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        
         try {
            String sql = String.format("drop table %s", table);
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
         } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
    }
}
