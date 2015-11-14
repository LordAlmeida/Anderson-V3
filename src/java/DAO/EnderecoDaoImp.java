/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Endereco;
import Entidade.PessoaUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class EnderecoDaoImp implements EnderecoDao {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs;

    @Override
    public Object salvar(Object obj) throws Exception {
        PessoaUser edr = (PessoaUser) obj;
        try {
            String sql = "INSERT INTO endereco (rua,numero,complemento,cidade,cep,id_estado,id_pessoa) VALUES (?,?,?,?,?,?,?)";
            conn = ConnectDB.abreConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, edr.getId_endereco().getRua());
            stmt.setInt(2, edr.getId_endereco().getNumero());
            stmt.setString(3, edr.getId_endereco().getComplemento());
            stmt.setString(4, edr.getId_endereco().getCidade());
            stmt.setString(5, edr.getId_endereco().getCep());
            stmt.setInt(6, edr.getId_endereco().getEst().getId_estadoo());
            stmt.setInt(7, edr.getId_PessoaUser());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao salvar novo endereco " + e.getMessage() + e.getLocalizedMessage());
        } finally {
            ConnectDB.fechaConexao(conn, stmt);
        }
        return null;
    }

    @Override
    public void alterar(Object obj) throws Exception {
        PessoaUser edr = (PessoaUser) obj;
        try {
            String sql = "UPDATE endereco SET rua = ? , numero = ? , complemento = ? , cidade = ? , cep = ? , id_estado = ? WHERE id_curriculo = ?)";
            conn = ConnectDB.abreConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, edr.getId_endereco().getRua());
            stmt.setInt(2, edr.getId_endereco().getNumero());
            stmt.setString(3, edr.getId_endereco().getComplemento());
            stmt.setString(4, edr.getId_endereco().getCidade());
            stmt.setString(5, edr.getId_endereco().getCep());
            stmt.setInt(6, edr.getId_endereco().getEst().getId_estadoo());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao salvar novo endereco " + e.getMessage() + e.getLocalizedMessage());
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
