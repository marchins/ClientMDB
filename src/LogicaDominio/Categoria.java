/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaDominio;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Blanco
 */
@Entity
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String nome;
    
    @Id
    @ManyToOne
    private Account account;
    @ManyToMany
    private Collection<CopiaUtente> copieLibriAssociate;


    public Collection<CopiaUtente> getCopieLibriAssociate() {
        return copieLibriAssociate;
    }

    public void setCopieLibriAssociate(Collection<CopiaUtente> copieLibriAssociate) {
        this.copieLibriAssociate = copieLibriAssociate;
    }
    
    
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nome != null ? nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the nome fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.nome == null && other.nome != null) || (this.nome != null && !this.nome.equals(other.nome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LogicaDominio.Categoria[ id=" + nome + " ]";
    }
    
}
