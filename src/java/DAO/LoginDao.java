package DAO;

import Entidade.Usuarios;

public interface LoginDao extends BaseDao{
    
   Usuarios pesquisarLogin (String nome,String senha)throws Exception;
}
