/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaDominio;

import Enumerations.Valore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Alessio
 */
@Entity
public class Valutazione implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Valore valore;

    @OneToMany
    private Collection<CopiaUtente> copieUtente;

    public Collection<CopiaUtente> getCopieUtente() {
        return copieUtente;
    }

    public void setCopieUtente(Collection<CopiaUtente> copieUtente) {
        this.copieUtente = copieUtente;
    }
    
    public Valore getValore() {
        return valore;
    }

    public void setValore(Valore valore) {
        this.valore = valore;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valore != null ? valore.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the Valore fields are not set
        if (!(object instanceof Valutazione)) {
            return false;
        }
        Valutazione other = (Valutazione) object;
        if ((this.valore == null && other.valore != null) || (this.valore != null && !this.valore.equals(other.valore))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LogicaDominio.NewEntity[ id=" + valore + " ]";
    }
    
}
