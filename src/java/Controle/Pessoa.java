package Controle;

import DAO.EnderecoDao;
import DAO.EnderecoDaoImp;
import DAO.EstadoDao;
import DAO.EstadoDaoImp;
import DAO.PaisDao;
import DAO.PaisDaoImp;
import DAO.TipoFormacaoDao;
import DAO.TipoFormacaoDaoImp;
import DAO.UsuarioDao;
import DAO.UsuarioDaoImp;
import Entidade.Curriculo;
import Entidade.Endereco;
import Entidade.Estado;
import Entidade.Formacao;
import Entidade.Pais;
import Entidade.PessoaUser;
import Entidade.TipoFormacao;
import Entidade.TipoPublicado;
import Entidade.TrabalhoPublicado;
import Entidade.Usuarios;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class Pessoa {

    @PostConstruct
    public void iniciar() {
        getTiposFormacao();
        getEstados();
        getPais();
        if (listform == null) {
            listform = new ArrayList();
        }
        if (listtp == null) {
            listtp = new ArrayList();
        }
    }
    private DataModel modeListar;
    private DataModel modelFormacao;
    private DataModel modelTitulo;
    private PessoaUser PS;
    private Curriculo crs;
    private Pais pas;
    private Endereco ends;
    private Estado Est;
    private Formacao form;
    private TipoFormacao Tform;
    private List<Formacao> listform;
    private List<TrabalhoPublicado> listtp;
    private TrabalhoPublicado Trapub;
    private TipoPublicado Tpub;
    private List<TipoFormacao> lis;
    private List<Estado> listEs;
    private List<Pais> listPa;

    public Pais getPas() {
        if (pas == null) {
            pas = new Pais();
        }
        return pas;
    }

    public DataModel getModeListar() {
        return modeListar;
    }

    public void setModeListar(DataModel modeListar) {
        this.modeListar = modeListar;
    }

    public void setPas(Pais pas) {
        this.pas = pas;
    }

    public Curriculo getCrs() {
        if (crs == null) {
            crs = new Curriculo();
        }
        return crs;
    }

    public void setCrs(Curriculo crs) {
        this.crs = crs;
    }

    public PessoaUser getPS() {
        if (PS == null) {
            PS = new PessoaUser();
        }
        return PS;
    }

    public void setPS(PessoaUser PS) {
        this.PS = PS;
    }

    public Endereco getEnds() {
        if (ends == null) {
            ends = new Endereco();
        }
        return ends;
    }

    public void setEnds(Endereco ends) {
        this.ends = ends;
    }

    public Estado getEst() {
        if (Est == null) {
            Est = new Estado();
        }
        return Est;
    }

    public void setEst(Estado Est) {
        this.Est = Est;
    }

    public DataModel getModelFormacao() {
        return modelFormacao;
    }

    public void setModelFormacao(DataModel modelFormacao) {
        this.modelFormacao = modelFormacao;
    }

    public DataModel getModelTitulo() {
        return modelTitulo;
    }

    public void setModelTitulo(DataModel modelTitulo) {
        this.modelTitulo = modelTitulo;
    }

    public List<Formacao> getListform() {
        return listform;
    }

    public void setListform(List<Formacao> listform) {
        this.listform = listform;
    }

    public List<TrabalhoPublicado> getListtp() {
        return listtp;
    }

    public void setListtp(List<TrabalhoPublicado> listtp) {
        this.listtp = listtp;
    }

    public Formacao getForm() {
        if (form == null) {
            form = new Formacao();
        }
        return form;
    }

    public void setForm(Formacao form) {
        this.form = form;
    }

    public TipoFormacao getTform() {
        if (Tform == null) {
            Tform = new TipoFormacao();
        }
        return Tform;
    }

    public void setTform(TipoFormacao Tform) {
        this.Tform = Tform;
    }

    public TrabalhoPublicado getTrapub() {
        if (Trapub == null) {
            Trapub = new TrabalhoPublicado();
        }
        return Trapub;
    }

    public void setTrapub(TrabalhoPublicado Trapub) {
        this.Trapub = Trapub;
    }

    public TipoPublicado getTpub() {
        if (Tpub == null) {
            Tpub = new TipoPublicado();
        }
        return Tpub;
    }

    public void setTpub(TipoPublicado Tpub) {
        this.Tpub = Tpub;
    }

    public String inicioVolta() {
        return "/sistema/viewCurriculo";
    }

    public String cadastroView() {
        listEs = new ArrayList();
        lis = new ArrayList();
        listform = new ArrayList();
        listPa = new ArrayList();
        listtp = new ArrayList();
        return "/sistema/curriculo";
        
    }

    public void carregarEstado() {
        TipoFormacaoDao tfd = new TipoFormacaoDaoImp();
        try {

        } catch (Exception e) {
        }
    }

    public List<SelectItem> getTiposFormacao() {
        TipoFormacaoDao tfDao = new TipoFormacaoDaoImp();
        List<SelectItem> listTipoFormacao = new ArrayList<SelectItem>();
        try {
            lis = tfDao.listar();
            for (TipoFormacao tf : lis) {
                listTipoFormacao.add(new SelectItem(tf.getId_TipoFormacao(), tf.getDescricao()));
            }
            return listTipoFormacao;
        } catch (Exception e) {
            System.out.println("ERRO CONTROLE getTiposFormacao() " + e.getMessage());
        }
        return null;
    }

    public List<SelectItem> getEstados() {
        EstadoDao esDao = new EstadoDaoImp();
        List<SelectItem> listEstado = new ArrayList<SelectItem>();
        try {
            listEs = esDao.listar();
            for (Estado es : listEs) {
                listEstado.add(new SelectItem(es.getId_estadoo(), es.getDescricao()));
            }
            return listEstado;
        } catch (Exception e) {
            System.out.println("Erro ao tentar buscar o Estado" + e.getMessage() + e.getLocalizedMessage());
        }
        return null;
    }

    public List<SelectItem> getPais() {
        PaisDao pdDao = new PaisDaoImp();
        List<SelectItem> listPais = new ArrayList<SelectItem>();
        try {
            listPa = pdDao.listar();
            for (Pais pp : listPa) {
                listPais.add(new SelectItem(pp.getId_pais(), pp.getDescricao()));
            }
            return listPais;
        } catch (Exception e) {
            System.out.println("Erro ao tentar carregar o pais" + e.getMessage() + e.getLocalizedMessage());
        }
        return null;
    }

    public void salvarTudo(int id_usuario) {
        UsuarioDao pdd = new UsuarioDaoImp();
        Usuarios us= new Usuarios();
        us.setId_usuario(id_usuario);
        try {
           
           crs.setFormalogo(listform);
           crs.setTpublic(listtp);
           PS.setId_endereco(ends);
           ends.setEst(Est);
      
           PS.setId_curriculo(crs);
           PS.setLogin(us);
            pdd.salvar(PS);
            PS = null;
            crs = null;
            ends = null;
            Est = null;
            Tform = null;
            Tpub = null;
            Trapub= null;
            form= null;
            lis= null;
            listEs= null;
            listPa= null;
            listform= null;
            listtp= null;
            pas= null;
        } catch (Exception ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarform() {
        for (TipoFormacao tf : lis) {
            if (Tform.getId_TipoFormacao() == tf.getId_TipoFormacao()) {
                Tform.setDescricao(tf.getDescricao());
            }
        }
        form.setId_TipoFormacao(Tform);
        listform.add(form);
        modelFormacao = new ListDataModel(listform);
        form = null;
        Tform = null;
    }

    public void listarpublic() {
         for (Pais es : listPa) {
            if(pas.getId_pais().equals(es.getId_pais())){
                pas.setDescricao(es.getDescricao());
            }
        }
        Trapub.setPais(pas);
        
        Trapub.setId_TipoPublicado(Tpub);
        listtp.add(Trapub);
        modelTitulo = new ListDataModel(listtp);
        Trapub = null;
        Tpub = null;
    }
}
