
package Controle;

import Entidade.Curriculo;
import javax.faces.bean.ManagedBean;
@ManagedBean
public class Curriculos {
 
    private Curriculo Cur;

    public Curriculo getCur() {
      if(Cur == null){
          Cur = new Curriculo();
      }
        return Cur;
    }

    public void setCur(Curriculo Cur) {
        this.Cur = Cur;
    }
    
    
}
