/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import classe.Aluno;
import classe.Grupo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author YanNotebook
 */
public class GrupoDao {  

    private static GrupoDao instance;
    
    private GrupoDao(){}
    
    public static GrupoDao getInstance(){
        if(instance == null)
            instance = new GrupoDao();
        return instance;
    }
    
    public void salvar(Grupo grupo) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "INSERT INTO grupo (id_grupo, id_atividade, nome, nota) " +
                         "VALUES (%d, %d, '%s', '%s')";
            sql = String.format(sql, grupo.getIdGrupoServidor(), grupo.getIdAtividadeServidor(), grupo.getNome(),grupo.getNota());
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
        } catch(SQLException e) {
            throw e;
        } finally {
            fecharConexao(conn, st);
        }
    }

    public void alterar(Grupo grupo) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "UPDATE grupo SET id_atividade= %d , nome='%s', nota=%f WHERE id_grupo=%d" ;
            sql = String.format(sql,grupo.getIdAtividadeServidor(), grupo.getNome(), grupo.getNota(), grupo.getIdGrupoServidor());
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();  
            st.execute(sql);
                        
        } catch(SQLException e) {
            throw e;
        } finally {
            fecharConexao(conn, st);
        }
    }
    
    public void alterar(int idGrupo, double nota) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "UPDATE grupo SET nota=%f WHERE id_grupo=%d" ;
            sql = String.format(sql, nota, idGrupo);
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
                        
        } catch(SQLException e) {
            throw e;
        } finally {
            fecharConexao(conn, st);
        }
    }
    
    public Grupo buscar(int idGrupo) throws ClassNotFoundException, SQLException {
        Grupo grupo = null;
        Connection conn = null;
        Statement st = null;
        
        try {
                      
            String sql = String.format("SELECT * FROM grupo WHERE id_grupo=%d", idGrupo);
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            
            grupo = new Grupo(idGrupo, rs.getInt("id_atividade"), rs.getString("nome"), rs.getDouble("nota"));
            grupo.setAlunos(buscarAlunos(idGrupo));
                        
        } catch(SQLException e) {
            throw e;
        } finally {
            fecharConexao(conn, st);
        }
        
        return grupo;
    }
    
    public List<Grupo> buscarTodos() throws ClassNotFoundException, SQLException {
        List<Grupo> grupos = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        
        try {
            String query = "SELECT * FROM grupo";
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                int idGrupo = rs.getInt("id_grupo");
                Grupo grupo = new Grupo(idGrupo, rs.getInt("id_atividade"), rs.getString("nome"), rs.getDouble("nota"));
                grupo.setAlunos(buscarAlunos(idGrupo));
                grupos.add(grupo);            
            }

        } catch(SQLException e) {
            throw e;
        } finally {
            fecharConexao(conn, st);
        }
        
        return grupos;
    }

    public List<Aluno> buscarAlunos(int idGrupo)throws ClassNotFoundException, SQLException {
        List<Aluno> alunos =  new ArrayList<>();;
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "SELECT id_aluno FROM grupo_aluno ga " +
                         "LEFT JOIN aluno a a.id_aluno = ga.id_aluno " +
                         "WHERE ga.id_grupo = %d ";
            sql = String.format(sql, idGrupo);
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    

            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Aluno aluno = new Aluno( rs.getInt("id_aluno"), rs.getString("nome"), rs.getDouble("nota"));
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

