/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaDominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.eclipse.persistence.annotations.UuidGenerator;

/**
 *
 * @author Blanco
 */
@Entity
@UuidGenerator(name="UUID-GEN")
public class Amico implements Serializable {
    //private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator="UUID-GEN", strategy=GenerationType.TABLE)
    private String id;
    
    private String nome;
    private String email;
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amico)) {
            return false;
        }
        Amico other = (Amico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LogicaDominio.Amico[ id=" + id + " ]";
    }
    
}
