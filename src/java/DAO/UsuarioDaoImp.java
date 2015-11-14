package DAO;

import Entidade.PessoaUser;
import Entidade.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UsuarioDaoImp implements UsuarioDao {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs;

    @Override
    public Object salvar(Object obj) throws Exception {
        PessoaUser PD = (PessoaUser) obj;
        try {
            String sql = "INSERT INTO usuario (nome,sobrenome,idade,sexo,CPF,id_login) VALUES (?,?,?,?,?,?)";
            conn = ConnectDB.abreConexao();
            stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, PD.getNome());
            stmt.setString(2, PD.getSobreNome());
            stmt.setInt(3, PD.getAno());
            stmt.setString(4, PD.getSexo());
            stmt.setString(5, PD.getCpf());
            stmt.setInt(6, PD.getLogin().getId_usuario());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            rs.next();
            PD.setId_PessoaUser(rs.getInt(1));
            CurriculoDao cdao = new CurriculoDaoImp();
            EnderecoDao ddaoo = new EnderecoDaoImp();
            ddaoo.salvar(PD);
            cdao.salvar(PD);
        } catch (Exception e) {
            System.out.println("Erro ao salvar novo usuario " + e.getMessage() + e.getLocalizedMessage());
        } finally {
            ConnectDB.fechaConexao(conn, stmt);
        }
        return null;

    }

    @Override
    public void alterar(Object obj) throws Exception {
        PessoaUser PD = (PessoaUser) obj;
        try {
            String sql = "UPDATE usuario SET nome = ? , sobrenome = ? , idade = ? , sexo = ? , CPF = ? , id_edereco = ? WHERE = id_curriculo = ?";
            conn = ConnectDB.abreConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, PD.getNome());
            stmt.setString(2, PD.getSobreNome());
            stmt.setInt(3, PD.getAno());
            stmt.setString(4, PD.getSexo());
            stmt.setString(5, PD.getCpf());
            stmt.setInt(6, PD.getLogin().getId_usuario());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao salvar novo usuario " + e.getMessage() + e.getLocalizedMessage());
        } finally {
            ConnectDB.fechaConexao(conn, stmt);
        }
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
