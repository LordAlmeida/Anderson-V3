/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.TipoFormacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class TipoFormacaoDaoImp implements TipoFormacaoDao{
    
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
      TipoFormacao TF;
       List<TipoFormacao> LTF = new ArrayList();
        try {
            conn = ConnectDB.abreConexao();
            String sql = "SELECT * FROM tipoforma";
            stmt = conn.prepareCall(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                TF = new TipoFormacao();
                TF.setDescricao(rs.getString("descricao"));
                TF.setId_TipoFormacao(rs.getInt("id_tipoforma"));
                LTF.add(TF);
            }
       } catch (Exception e) {
            System.out.println("Erro ao carregar informaçoes do Tipo de formacao " + e.getMessage() + e.getLocalizedMessage());
        } finally {
            ConnectDB.fechaConexao(conn, stmt, rs);
        }
        return LTF;
    }
    }
    

