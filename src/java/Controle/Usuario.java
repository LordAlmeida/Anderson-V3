package Controle;

import DAO.ConnectDB;
import DAO.LoginDao;
import DAO.LoginDaoImp;
import DAO.TipoFormacaoDao;
import DAO.TipoFormacaoDaoImp;
import DAO.UsuarioDao;
import DAO.UsuarioDaoImp;
import Entidade.Estado;
import Entidade.TipoFormacao;
import Entidade.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Usuario {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs;
    private Usuarios users;

    public Usuarios getUsers() {
        if (users == null) {
            users = new Usuarios();
        }
        return users;
    }

    public void setUsers(Usuarios users) {
        this.users = users;
    }

    public String login() {
        LoginDao LDao = new LoginDaoImp();
        try {
            users=LDao.pesquisarLogin(users.getNome(), users.getSenha());
            
            if (users.getId_usuario() != 0){
                return "sistema/viewCurriculo";
            } else {
                System.out.println("Usuario ou senha errado!");
            }
        } catch (Exception ex) {
            System.out.println("Nao foi possivel chamar a parte de pesquisa de login " + ex.getMessage() + ex.getLocalizedMessage());
        }
        return null;
    }

    public void salvarNovoUser() {
        try {
            LoginDao LDao = new LoginDaoImp();
            users = (Usuarios) LDao.salvar(users);
        } catch (Exception e) {
            System.out.println("Erro ao tentar salvar novo " + e.getMessage() + e.getLocalizedMessage());
        }
    }

    public void alterarUsuario() {

    }

  
}
