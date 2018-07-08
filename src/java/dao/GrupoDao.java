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
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into grupo (id_grupo, id_atividade, nome, nota)" +
                       "values ("+ grupo.getIdGrupoServidor()+" , " +grupo.getIdAtividadeServidor()+" , "
                               + "'" + grupo.getNome() + "', " + grupo.getNota() +" )");
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
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update grupo set id_atividade=" +grupo.getIdAtividadeServidor()+" , "
                               + " nome='" + grupo.getNome() + "', nota=" + grupo.getNota() 
                               + " where id_grupo="+ grupo.getIdGrupoServidor());
                        
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
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update grupo set nota=" + nota 
                               + " where id_grupo="+ idGrupo);
                        
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
                       
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    
            
            String query = "select * from grupo where id_grupo= "+idGrupo;
            ResultSet rs = st.executeQuery(query);
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
            String query = "select * from grupo";
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
                       
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    
            
            String query = "select id_aluno from grupo_aluno ga " 
                          +"left join aluno a a.id_aluno = ga.id_aluno "
                          +"where ga.id_grupo= "+idGrupo ;
            ResultSet rs = st.executeQuery(query);
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

