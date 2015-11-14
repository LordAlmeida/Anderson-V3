/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Curriculo;
import Entidade.Formacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class FormacaoDaoImp implements FormacaoDao {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs;

    @Override
    public Object salvar(Object obj) throws Exception {
        Formacao fm = (Formacao) obj;
        try {
            String sql = ("INSERT INTO formacao (nomeinstitui,datainicio,datatermino,id_Tipoforma,id_cur) VALUES (?,?,?,?,?)");
            conn = ConnectDB.abreConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fm.getNomeInstituicao());
            stmt.setDate(2, new java.sql.Date(fm.getDataInicio().getTime()));
            stmt.setDate(3, new java.sql.Date(fm.getDataTermino().getTime()));
            stmt.setInt(4, fm.getId_TipoFormacao().getId_TipoFormacao());
            stmt.setInt(5, fm.getCur().getId_Curriculo());
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
         Formacao fm = (Formacao) obj;
        try {
            String sql = ("UPDATE formacao SET nomeinstitui = ? , datainicio = ? , datatermino = ? , id_Tipoforma = ?) WHERE id_curriculo = ?");
            conn = ConnectDB.abreConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fm.getNomeInstituicao());
            stmt.setDate(2, new java.sql.Date(fm.getDataInicio().getTime()));
            stmt.setDate(3, new java.sql.Date(fm.getDataTermino().getTime()));
            stmt.setInt(4, fm.getId_TipoFormacao().getId_TipoFormacao());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao executar alteração na formacao " + e.getMessage() + e.getLocalizedMessage());
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
