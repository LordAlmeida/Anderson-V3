package Entidade;

public class Estado {
   private int id_estadoo;
   private String descricao;
   private String uf;

    public int getId_estadoo() {
        return id_estadoo;
    }

    public void setId_estadoo(int id_estadoo) {
        this.id_estadoo = id_estadoo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
