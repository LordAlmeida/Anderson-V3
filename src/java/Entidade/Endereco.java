package Entidade;

public class Endereco {
    private int id_Endereco;
    private String rua;
    private int numero;
    private String complemento;
    private String cidade;
    private String cep;
    private Estado est;
    private PessoaUser id_pessoa;

    public PessoaUser getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(PessoaUser id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    
    public int getId_Endereco() {
        return id_Endereco;
    }

    public void setId_Endereco(int id_Endereco) {
        this.id_Endereco = id_Endereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Estado getEst() {
        return est;
    }

    public void setEst(Estado est) {
        this.est = est;
    }

  
    
}
