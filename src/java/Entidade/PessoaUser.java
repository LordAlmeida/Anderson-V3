package Entidade;

import java.util.Date;

public class PessoaUser {
    
    private int id_PessoaUser;
    private String nome;
    private String sobreNome;
    private int ano;
    private String cpf;
    private Curriculo id_curriculo;
    private Endereco id_endereco;
    private String sexo;
    private Usuarios login;

    public Usuarios getLogin() {
        return login;
    }

    public void setLogin(Usuarios login) {
        this.login = login;
    }


    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public int getId_PessoaUser() {
        return id_PessoaUser;
    }

    public void setId_PessoaUser(int id_PessoaUser) {
        this.id_PessoaUser = id_PessoaUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Curriculo getId_curriculo() {
        return id_curriculo;
    }

    public void setId_curriculo(Curriculo id_curriculo) {
        this.id_curriculo = id_curriculo;
    }

    public Endereco getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Endereco id_endereco) {
        this.id_endereco = id_endereco;
    }

    
    
}
