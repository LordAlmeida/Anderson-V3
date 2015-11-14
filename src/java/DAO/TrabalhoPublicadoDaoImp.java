/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.TrabalhoPublicado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class TrabalhoPublicadoDaoImp implements TrabalhoPublicadoDao {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs;

    @Override
    public Object salvar(Object obj) throws Exception {
        TrabalhoPublicado pub = (TrabalhoPublicado) obj;
        try {
            String sql = ("INSERT INTO trabalhopublicados (nome,ano,pais,id_curriculo,tipotraba) VALUES (?,?,?,?,?)");
            conn = ConnectDB.abreConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pub.getNome());
            stmt.setDate(2, new java.sql.Date(pub.getAno().getTime()));
            stmt.setString(3, pub.getPais().getId_pais());
            stmt.setInt(4, pub.getId_Curriculo().getId_Curriculo());
            stmt.setString(5, pub.getTipoTrabalho());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao salvar nova formacao " + e.getMessage() + e.getLocalizedMessage());
        } finally {
            ConnectDB.fechaConexao(conn, stmt);
        }
        return null;
    }

    @Override
    public void alterar(Object obj) throws Exception {
        TrabalhoPublicado pub = (TrabalhoPublicado) obj;
        try {
            String sql = ("UPDATE trabalhopublicados SET nome = ? , ano = ? , pais = ? , id_curriculo = ? , id_tipotrabalho = ? WHERE id_curriculo=?");
            conn = ConnectDB.abreConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pub.getNome());
            stmt.setDate(2,new java.sql.Date(pub.getAno().getTime()));
            stmt.setString(3, pub.getPais().getId_pais());
            stmt.setInt(4, pub.getId_Curriculo().getId_Curriculo());
            stmt.setInt(5, pub.getId_TipoPublicado().getId_TipoPublicado());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao alterar a formacao " + e.getMessage() + e.getLocalizedMessage());
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
