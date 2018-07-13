/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Aluno;
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
public class AlunoDao {
    private static AlunoDao instance;
    
    public AlunoDao(){}
    
    public static AlunoDao getInstance(){
        if(instance == null)
            instance = new AlunoDao();
        return instance;
    }
    
    public void salvar(Aluno aluno) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "INSERT INTO aluno (id_aluno, nome) VALUES (%d, '%s')";
            sql = String.format(sql, aluno.getIdAlunoServidor(), aluno.getNome());
     
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
            
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
    }
    
    public Aluno buscar(int idAluno) throws ClassNotFoundException, SQLException {
        Aluno aluno = null;
        Connection conn = null;
        Statement st = null;
        
        try {
                       
            String sql = String.format("SELECT * FROM aluno WHERE id_aluno=%d", idAluno);
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    
            
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                aluno = new Aluno(idAluno, rs.getString("nome"));
            }       
                        
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
        
        return aluno;
    }
    
    public Aluno buscar(int idAluno, int idAtividade) throws ClassNotFoundException, SQLException {
        Aluno aluno = null;
        Connection conn = null;
        Statement st = null;
        
        try {
                       
            String sql = "SELECT * FROM aluno a"
                       + "LEFT JOIN atividade_aluno aa ON a.id_aluno = aa.id_aluno"
                       + "WHERE a.id_aluno=%d AND aa.id_atividade=%d"; 
            sql = String.format(sql, idAluno, idAtividade);
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    
            
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            
            aluno = new Aluno(idAluno, rs.getString("nome"), rs.getDouble("nota"));
                        
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
        
        return aluno;
    }
    
    public List<Aluno> buscarTodos() throws ClassNotFoundException, SQLException {
        List<Aluno> alunos = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        
        try {
            String query = "SELECT * FROM aluno";
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                Aluno aluno = new Aluno(rs.getInt("id_aluno"), rs.getString("nome"), rs.getDouble("nota"));
                alunos.add(aluno);            
            }

        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
        
        return alunos;
    }
    
     public void alterar(Aluno aluno) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "UPDATE aluno SET nome='%s'WHERE id_aluno=%d" ;
            sql = String.format(sql,aluno.getNome(), aluno.getIdAlunoServidor());
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
