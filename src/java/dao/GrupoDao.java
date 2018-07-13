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
import service.ValidarNumeroService;
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
            String sql = "INSERT INTO grupo (id_grupo, id_atividade, nome, nota) VALUES (%d, %d, '%s', %s)";
            sql = String.format(sql, grupo.getIdGrupoServidor(), grupo.getIdAtividadeServidor(), grupo.getNome(),  String.valueOf(grupo.getNota()));
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
            
            salvarAlunos(grupo.getAlunos() , grupo.getIdGrupoServidor());
            
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
    }
    
    public void salvarSemNota(Grupo grupo) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "INSERT INTO grupo (id_grupo, id_atividade, nome) VALUES (%d, %d, '%s')";
            sql = String.format(sql, grupo.getIdGrupoServidor(), grupo.getIdAtividadeServidor(), grupo.getNome());
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
            
            salvarAlunos(grupo.getAlunos() , grupo.getIdGrupoServidor());
            
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
    }
    
    public void salvarAlunos(List<Aluno> alunos , int idGrupo)throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
           
            for(Aluno aluno : alunos){
                if(buscarAluno(idGrupo, aluno.getIdAlunoServidor()) == null){
                    String sql =  String.format("INSERT INTO grupo_aluno (id_grupo, id_aluno) VALUES (%d, %d); ", idGrupo, aluno.getIdAlunoServidor());
                    st.execute(sql);
                }
            }

        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
    }

    public void alterarAlunos(List<Aluno> alunos , int idGrupo)throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            for(Aluno aluno : alunos){
                if(buscarAluno(idGrupo, aluno.getIdAlunoServidor()) == null){
                    String sql =  String.format("INSERT INTO grupo_aluno (id_grupo, id_aluno) VALUES (%d, %d); ", idGrupo, aluno.getIdAlunoServidor());
                    st.execute(sql);
                }
            }
        
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
    }
    
    public void alterar(Grupo grupo) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "UPDATE grupo SET id_atividade= %d , nome='%s', nota=%s WHERE id_grupo=%d" ;
            sql = String.format(sql,grupo.getIdAtividadeServidor(), grupo.getNome(), String.valueOf(grupo.getNota()), grupo.getIdGrupoServidor());
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();  
            st.execute(sql);
            
            //alterarAlunos(grupo.getAlunos(), grupo.getIdGrupoServidor());
                        
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
    }
    
    public void alterar(int idGrupo, double nota) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "UPDATE grupo SET nota=%s WHERE id_grupo=%d" ;           
            sql = String.format(sql, String.valueOf(nota), idGrupo);  
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
                        
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
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
            if(rs.next()){
                grupo = new Grupo(idGrupo, rs.getInt("id_atividade"), rs.getString("nome"), rs.getDouble("nota"));
                grupo.setAlunos(buscarAlunos(idGrupo)); 
            }
       
        } catch(SQLException e) {
            throw e;
        } finally {
            DatabaseLocator.fecharConexao(conn, st);
        }
        
        return grupo;
    }
    
    public List<Grupo> buscarTodos(int idAtividade) throws ClassNotFoundException, SQLException {
        List<Grupo> grupos = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        
        try {
            String query = String.format("SELECT * FROM grupo WHERE id_atividade=%d", idAtividade);
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
            DatabaseLocator.fecharConexao(conn, st);
        }
        
        return grupos;
    }

    public List<Aluno> buscarAlunos(int idGrupo)throws ClassNotFoundException, SQLException {
        List<Aluno> alunos =  new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "SELECT a.id_aluno AS id_aluno , a.nome AS nome, at.nota AS nota "
                       + "FROM grupo_aluno ga " +
                         "LEFT JOIN aluno a ON a.id_aluno = ga.id_aluno " +
                         "LEFT JOIN grupo g ON g.id_grupo = ga.id_grupo " +
                         "LEFT JOIN atividade_aluno at ON at.id_aluno = a.id_aluno " +
                         "WHERE ga.id_grupo = %d ";
            sql = String.format(sql, idGrupo);
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    

            ResultSet rs = st.executeQuery(sql);
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
    
    public List<Aluno> buscarAluno(int idGrupo, int idAluno)throws ClassNotFoundException, SQLException {
        List<Aluno> alunos =  new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "SELECT a.id_aluno AS id_aluno , a.nome AS nome, at.nota AS nota "
                       + "FROM grupo_aluno ga " +
                         "LEFT JOIN aluno a ON a.id_aluno = ga.id_aluno " +
                         "LEFT JOIN grupo g ON g.id_grupo = ga.id_grupo " +
                         "LEFT JOIN atividade_aluno at ON at.id_aluno = a.id_aluno " +
                         "WHERE ga.id_grupo = %d AND a.id_aluno = %d";
            sql = String.format(sql, idGrupo, idAluno);
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();    

            ResultSet rs = st.executeQuery(sql);
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
    
    public void deleteAlunos(int idGrupo) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        
        try {
            String sql = "DELETE FROM grupo_aluno WHERE id_grupo=%d" ;
            sql = String.format(sql, idGrupo);
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

