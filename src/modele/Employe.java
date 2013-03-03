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
    private Long iCode;
    private int iNbClient;
    @OneToMany
    private List<Client> lClients = new ArrayList();

    public int getiNbClient() {
        return iNbClient;
    }

    public List<Client> getlClients() {
        return lClients;
    }

    public Employe() {
        this.iNbClient = 0;
    }

    public Employe(List<Client> lClients) {
        this.lClients=lClients;
        this.iNbClient = lClients.size();
    }

    public long getiCode() {
        return iCode;
    }
    
    public void addClient(Client cClient) {
        iNbClient++;
        lClients.add(cClient);
    }
}
