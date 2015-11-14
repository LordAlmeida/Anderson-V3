package DAO;


import Entidade.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class LoginDaoImp implements LoginDao{

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs;
    
    @Override
    public Usuarios pesquisarLogin(String nome, String senha) throws Exception {
        boolean logado = false; 
        conn = ConnectDB.abreConexao();
        String sql = "SELECT * FROM login  WHERE nome = ? AND senha = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2, senha);
        rs = stmt.executeQuery();
        Usuarios log = new Usuarios();
        
        if (rs.next()) {
        log.setId_usuario(rs.getInt("id_login"));
        log.setNome(rs.getString("nome"));
            logado = true;
        }
         return log;
    }

    @Override
    public Object salvar(Object obj) throws Exception {
      Usuarios user = (Usuarios) obj;
        try {
            String sql = "INSERT INTO login (nome,senha) VALUES (?,?)";
            conn = ConnectDB.abreConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao salvar novo usuario " + e.getMessage() + e.getLocalizedMessage());
        } finally {
            ConnectDB.fechaConexao(conn, stmt);
        }
     return null;    
    }

    @Override
    public void alterar(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object procurar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
