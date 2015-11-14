package Entidade;

import java.util.List;

public class Curriculo {
    
    private int id_Curriculo;
    private String Resumo;
    private String expProfissional;
    private String formacaoBasica;
    private String FormacaoMedia;
    private PessoaUser id_pessoa;
    private List<Formacao> Formalogo;
    private List<TrabalhoPublicado> tpublic;

    public List<TrabalhoPublicado> getTpublic() {
        return tpublic;
    }

    public void setTpublic(List<TrabalhoPublicado> tpublic) {
        this.tpublic = tpublic;
    }
    
    public List<Formacao> getFormalogo() {
        return Formalogo;
    }

    public void setFormalogo(List<Formacao> Formalogo) {
        this.Formalogo = Formalogo;
    }
  
    public PessoaUser getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(PessoaUser id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    
    
    public int getId_Curriculo() {
        return id_Curriculo;
    }

    public void setId_Curriculo(int id_Curriculo) {
        this.id_Curriculo = id_Curriculo;
    }

    public String getResumo() {
        return Resumo;
    }

    public void setResumo(String Resumo) {
        this.Resumo = Resumo;
    }

    public String getExpProfissional() {
        return expProfissional;
    }

    public void setExpProfissional(String expProfissional) {
        this.expProfissional = expProfissional;
    }

    public String getFormacaoBasica() {
        return formacaoBasica;
    }

    public void setFormacaoBasica(String formacaoBasica) {
        this.formacaoBasica = formacaoBasica;
    }

    public String getFormacaoMedia() {
        return FormacaoMedia;
    }

    public void setFormacaoMedia(String FormacaoMedia) {
        this.FormacaoMedia = FormacaoMedia;
    }
    
    
}
