package DAO;

import java.util.List;

public interface BaseDao {
   
    Object salvar(Object obj) throws Exception;

    void alterar(Object obj) throws Exception;

    void excluir(int id) throws Exception;

    Object procurar(Integer id) throws Exception;

    List listar() throws Exception;
    
}
