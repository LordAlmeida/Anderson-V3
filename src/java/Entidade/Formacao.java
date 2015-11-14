package Entidade;

import java.util.Date;

public class Formacao {
    
    private int id_Formacao;
    private String nomeInstituicao;
    private Date dataInicio;
    private Date dataTermino;
    private TipoFormacao id_TipoFormacao;
    private Curriculo cur;

    public Curriculo getCur() {
        return cur;
    }

    public void setCur(Curriculo cur) {
        this.cur = cur;
    }
    

    public int getId_Formacao() {
        return id_Formacao;
    }

    public void setId_Formacao(int id_Formacao) {
        this.id_Formacao = id_Formacao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public TipoFormacao getId_TipoFormacao() {
        return id_TipoFormacao;
    }

    public void setId_TipoFormacao(TipoFormacao id_TipoFormacao) {
        this.id_TipoFormacao = id_TipoFormacao;
    }

   
}
