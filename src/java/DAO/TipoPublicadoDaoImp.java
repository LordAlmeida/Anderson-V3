/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.PessoaUser;
import Entidade.TipoPublicado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class TipoPublicadoDaoImp implements TipoPublicadoDao {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs;

    @Override
    public Object salvar(Object obj) throws Exception {
        TipoPublicado TP = (TipoPublicado) obj;
        try {
            String sql = "INSERT INTO tipopublicado (descricao) VALUES (?)";
            conn = ConnectDB.abreConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, TP.getDescricao());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao salvar novo tipo de publicacao " + e.getMessage() + e.getLocalizedMessage());
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
