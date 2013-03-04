/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author MrKim
 */
@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iIdClient;
    private String sNom;
    private String sPrenom;
    private String sAdresse;
    private String sEmail;
    private int iMoisNaissance;
    @ManyToMany (cascade = CascadeType.DETACH)
    private List<Medium> mMediums = new ArrayList<>();
    @ManyToOne (cascade = CascadeType.DETACH)
    private Employe eEmploye;
            
    public Client() {
    }

    public Client(String sNom, String sPrenom, String sAdresse, String sEmail, int iMoisNaissance, List<Medium> mMediums) {
        this.sNom = sNom;
        this.sPrenom = sPrenom;
        this.sAdresse = sAdresse;
        this.sEmail = sEmail;
        this.iMoisNaissance = iMoisNaissance;
        this.mMediums = mMediums;
    }

    public long getiIdClient() {
        return iIdClient;
    }

    public String getsNom() {
        return sNom;
    }

    public void setsNom(String sNom) {
        this.sNom = sNom;
    }

    public String getsPrenom() {
        return sPrenom;
    }

    public void setsPrenom(String sPrenom) {
        this.sPrenom = sPrenom;
    }

    public String getsAdresse() {
        return sAdresse;
    }

    public void setsAdresse(String sAdresse) {
        this.sAdresse = sAdresse;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public int getiMoisNaissance() {
        return iMoisNaissance;
    }

    public void setiMoisNaissance(int iMoisNaissance) {
        this.iMoisNaissance = iMoisNaissance;
    }

    public List<Medium> getmMediums() {
        return mMediums;
    }

    public void addMediums(Medium mMediums) {
        this.mMediums.add(mMediums);
    }
}
