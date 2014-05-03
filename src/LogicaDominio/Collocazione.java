/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaDominio;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Alessio
 */
@Entity
public class Collocazione implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nomeLibreria;
    private String posizioneNellaLibreria;

    @OneToOne
    private Collection<CopiaUtente> copieUtente;
    
    public String getNomeLibreria() {
        return nomeLibreria;
    }

    public void setNomeLibreria(String nomeLibreria) {
        this.nomeLibreria = nomeLibreria;
    }

    public String getPosizioneNellaLibreria() {
        return posizioneNellaLibreria;
    }

    public void setPosizioneNellaLibreria(String posizioneNellaLibreria) {
        this.posizioneNellaLibreria = posizioneNellaLibreria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collocazione)) {
            return false;
        }
        Collocazione other = (Collocazione) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LogicaDominio.Collocazione[ id=" + id + " ]";
    }
    
}
