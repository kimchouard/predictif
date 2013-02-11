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
import javax.persistence.ManyToMany;

/**
 *
 * @author MrKim
 */
@Entity
public class Medium implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iIdMedium;
    private String sNom;
    @ManyToMany
    private List<Integer> mClients = new ArrayList<>();

    public String getsNom() {
        return sNom;
    }

    public void setsNom(String sNom) {
        this.sNom = sNom;
    }
    
    public void addMedium (String sNom) {
        
    }

    public List<Integer> getmClients() {
        return mClients;
    }

    public void setmClients(List<Integer> mClients) {
        this.mClients = mClients;
    }

    public int getiIdMedium() {
        return iIdMedium;
    }
}
