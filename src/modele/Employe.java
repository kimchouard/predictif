/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author MrKim
 */
@Entity
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long iCode;
    private int iNbClients;

    public int getiNbClients() {
        return iNbClients;
    }

    public void setiNbClients(int iNbClients) {
        this.iNbClients = iNbClients;
    }

    public long getiCode() {
        return iCode;
    }
    
}
