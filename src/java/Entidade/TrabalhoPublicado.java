package Entidade;

import java.util.Date;

public class TrabalhoPublicado {

    private int id_TrabalhoPublicado;
    private String nome;
    private Date ano;
    private Pais pais;
    private Curriculo id_Curriculo;
    private TipoPublicado id_TipoPublicado;
    private String tipoTrabalho;

    public String getTipoTrabalho() {
        return tipoTrabalho;
    }

    public void setTipoTrabalho(String tipoTrabalho) {
        this.tipoTrabalho = tipoTrabalho;
    }

    
    
    public int getId_TrabalhoPublicado() {
        return id_TrabalhoPublicado;
    }

    public void setId_TrabalhoPublicado(int id_TrabalhoPublicado) {
        this.id_TrabalhoPublicado = id_TrabalhoPublicado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

        

    public Curriculo getId_Curriculo() {
        return id_Curriculo;
    }

    public void setId_Curriculo(Curriculo id_Curriculo) {
        this.id_Curriculo = id_Curriculo;
    }

    public TipoPublicado getId_TipoPublicado() {
        return id_TipoPublicado;
    }

    public void setId_TipoPublicado(TipoPublicado id_TipoPublicado) {
        this.id_TipoPublicado = id_TipoPublicado;
    }

    
}
