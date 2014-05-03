/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaDominio;

import Enumerations.SocialNetwork;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Alessio
 */
@Entity
public class CredenzialiSocialNetwork implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String accessToken;
    @Id
    private String accessTokenSecret;

    private SocialNetwork socialNetwork;
    
    @ManyToMany
    private Collection<Account> accounts;

    public SocialNetwork getSocialNetwork() {
        return socialNetwork;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }

    public void setSocialNetwork(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }
    
    
    
    
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessToken != null ? accessToken.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the accessToken fields are not set
        if (!(object instanceof CredenzialiSocialNetwork)) {
            return false;
        }
        CredenzialiSocialNetwork other = (CredenzialiSocialNetwork) object;
        if ((this.accessToken == null && other.accessToken != null) || (this.accessToken != null && !this.accessToken.equals(other.accessToken))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LogicaDominio.CredenzialiSocialNetwork[ id=" + accessToken + " ]";
    }
    
}
