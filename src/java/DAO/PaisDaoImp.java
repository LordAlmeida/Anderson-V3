/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Estado;
import Entidade.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class PaisDaoImp implements PaisDao {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs;

    @Override
    public Object salvar(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        Pais ps;
        List<Pais> pass = new ArrayList();
        try {
            conn = ConnectDB.abreConexao();
            String sql = "SELECT * FROM paises";
            stmt = conn.prepareCall(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ps = new Pais();
                ps.setDescricao(rs.getString("nome"));
                ps.setId_pais(rs.getString("iso"));
                pass.add(ps);
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar informaçoes do estado " + e.getMessage() + e.getLocalizedMessage());
        } finally {
            ConnectDB.fechaConexao(conn, stmt, rs);
        }
        return pass;
    }
}


