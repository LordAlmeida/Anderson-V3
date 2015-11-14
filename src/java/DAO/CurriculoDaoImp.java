/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Curriculo;
import Entidade.Formacao;
import Entidade.PessoaUser;
import Entidade.TrabalhoPublicado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class CurriculoDaoImp implements CurriculoDao {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs;

    @Override
    public Object salvar(Object obj) throws Exception {
        PessoaUser ccl = (PessoaUser) obj;
        try {
            String sql = ("INSERT INTO curriculo (resumo,exprofissional,forbasica,formedia,id_pessoa) VALUES (?,?,?,?,?)");
            conn = ConnectDB.abreConexao();
            stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, ccl.getId_curriculo().getResumo());
            stmt.setString(2, ccl.getId_curriculo().getExpProfissional());
            stmt.setString(3, ccl.getId_curriculo().getFormacaoBasica());
            stmt.setString(4, ccl.getId_curriculo().getFormacaoMedia());
            stmt.setInt(5, ccl.getId_PessoaUser());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            rs.next();
            Curriculo C = ccl.getId_curriculo();
            C.setId_Curriculo(rs.getInt(1));
            FormacaoDao fdao = new FormacaoDaoImp();
            TrabalhoPublicadoDao tpdao = new TrabalhoPublicadoDaoImp();
            for (Formacao F : C.getFormalogo()) {
                F.setCur(C);
                fdao.salvar(F);
            }
            for (TrabalhoPublicado TP : C.getTpublic()) {
                TP.setId_Curriculo(C);
                tpdao.salvar(TP);
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar novo curriculo base " + e.getMessage() + e.getLocalizedMessage());
        } finally {
            ConnectDB.fechaConexao(conn, stmt, rs);
        }
        return null;
    }

    @Override
    public void alterar(Object obj) throws Exception {
        PessoaUser ccl = (PessoaUser) obj;
        try {
            String sql = ("UPDATE curriculo SET resumo = ? , exprofissional = ? , forbasica =? , formedia = ? WHERE id_curriculo = ?");
            conn = ConnectDB.abreConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ccl.getId_curriculo().getResumo());
            stmt.setString(2, ccl.getId_curriculo().getExpProfissional());
            stmt.setString(3, ccl.getId_curriculo().getFormacaoBasica());
            stmt.setString(4, ccl.getId_curriculo().getFormacaoMedia());
            stmt.executeUpdate();
            } catch (Exception e) {
            System.out.println("Erro ao fazer as alteraçoes no curriculoDaoImp " + e.getMessage() + e.getLocalizedMessage());
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
