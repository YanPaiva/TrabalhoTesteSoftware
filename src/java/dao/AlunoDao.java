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
    
    private AlunoDao(){}
    
    public static AlunoDao getInstance(){
        if(instance == null)
            instance = new AlunoDao();
        return instance;
    }
    
    public void salvar(Aluno aluno) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into aluno (id_aluno, nome, nota)" +
                       "values ("+ aluno.getIdALunoServidor()+" , '" +aluno.getNome()+"' , " + aluno.getNota() +" )");
        } catch(SQLException e) {
            throw e;
        } finally {
            fecharConexao(conn, st);
        }
    }
    
    public Aluno buscar(int idAluno) throws ClassNotFoundException, SQLException {
        Aluno aluno = null;
        Connection conn = null;
        Statement st = null;
        
        try {
                       
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    
            
            String query = "select * from aluno where id_aluno= "+idAluno;
            ResultSet rs = st.executeQuery(query);
            rs.next();
            
            aluno = new Aluno(idAluno, rs.getString("nome"), rs.getDouble("nota"));
                        
        } catch(SQLException e) {
            throw e;
        } finally {
            fecharConexao(conn, st);
        }
        
        return aluno;
    }
    
    public List<Aluno> buscarTodos() throws ClassNotFoundException, SQLException {
        List<Aluno> alunos = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        
        try {
            String query = "select * from aluno";
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
            fecharConexao(conn, st);
        }
        
        return alunos;
    }
    
    private void fecharConexao(Connection conn, Statement st) {
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();

        } catch(SQLException e) {

        }
    } 
}
