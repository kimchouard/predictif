/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author MrKim
 */
@Entity
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long iCode;
    @OneToMany
    private List<Client> lNbClients = new ArrayList();

    public Employe() {
    }

    public Employe(List<Client> iNbClients) {
        this.lNbClients=iNbClients;
    }

    public long getiCode() {
        return iCode;
    }
    
}
