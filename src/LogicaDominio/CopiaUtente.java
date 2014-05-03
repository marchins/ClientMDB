/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaDominio;

import Enumerations.Formato;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Alessio
 */
@Entity
public class CopiaUtente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int numeroCopia;
    @Id
    @OneToOne
    private Libro libro;
    @Id
    @OneToOne
    private Account account;

    private Formato formato;
    private String copertinaLocale;

    @ManyToMany
    private Collection<Categoria> categorieAssegnate;
  
    @ManyToOne
    private StatoLettura statoLettura;
    
    @ManyToOne
    private Valutazione valutazione;
    
    @OneToOne
    private Collocazione collocazione;
    
    public Collection<Categoria> getCategorieAssegnate() {
        return categorieAssegnate;
    }

    public void setCategorieAssegnate(Collection<Categoria> categorieAssegnate) {
        this.categorieAssegnate = categorieAssegnate;
    }
    
    

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public String getCopertinaLocale() {
        return copertinaLocale;
    }

    public void setCopertinaLocale(String copertinaLocale) {
        this.copertinaLocale = copertinaLocale;
    }
    
 
    public int getNumeroCopia() {
        return numeroCopia;
    }

    public void setNumeroCopia(int numeroCopia) {
        this.numeroCopia = numeroCopia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroCopia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the numeroCopia fields are not set
        if (!(object instanceof CopiaUtente)) {
            return false;
        }
        CopiaUtente other = (CopiaUtente) object;
        if (this.numeroCopia != other.numeroCopia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LogicaDominio.CopiaUtente[ id=" + numeroCopia + " ]";
    }
    
}
