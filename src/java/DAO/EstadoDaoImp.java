/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class EstadoDaoImp implements EstadoDao {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs;

    @Override
    public Object salvar(Object obj) throws Exception {
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
    Estado ST;
        List<Estado> Les = new ArrayList();
        try {
            conn = ConnectDB.abreConexao();
            String sql = "SELECT * FROM estado";
            stmt = conn.prepareCall(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                ST = new Estado();
                ST.setDescricao(rs.getString("descricao"));
                ST.setId_estadoo(rs.getInt("id_estado"));
                Les.add(ST);
            }
       } catch (Exception e) {
            System.out.println("Erro ao carregar informaçoes do estado " + e.getMessage() + e.getLocalizedMessage());
        } finally {
            ConnectDB.fechaConexao(conn, stmt, rs);
        }
        return Les;
    }

}
