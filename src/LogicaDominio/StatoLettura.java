/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaDominio;

import Enumerations.Stato;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Alessio
 */
@Entity
public class StatoLettura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Stato stato;

    @OneToMany
    private Collection<CopiaUtente> copieUtente;

    public Collection<CopiaUtente> getCopieUtente() {
        return copieUtente;
    }

    public void setCopieUtente(Collection<CopiaUtente> copieUtente) {
        this.copieUtente = copieUtente;
    }
  
    
    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato Stato) {
        this.stato = Stato;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stato != null ? stato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the Stato fields are not set
        if (!(object instanceof StatoLettura)) {
            return false;
        }
        StatoLettura other = (StatoLettura) object;
        if ((this.stato == null && other.stato != null) || (this.stato != null && !this.stato.equals(other.stato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LogicaDominio.StatoLettura[ id=" + stato + " ]";
    }
    
}
