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
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iIdClient;
    private String sNom;
    private String sPrenom;
    private String sAdresse;
    private String sEmail;
    private int iMoisNaissance;
    /*@ManyToMany
    private List<Medium> mMediums = new ArrayList<>();*/
            
    public Client() {
    }

    public Client(String sNom, String sPrenom, String sAdresse, String sEmail, int iMoisNaissance/*, List<Medium> mMediums*/) {
        this.sNom = sNom;
        this.sPrenom = sPrenom;
        this.sAdresse = sAdresse;
        this.sEmail = sEmail;
        this.iMoisNaissance = iMoisNaissance;
        //this.mMediums = mMediums;
    }

    public String getsNom() {
        return sNom;
    }

    public void setsNom(String sNom) {
        this.sNom = sNom;
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

    public String getsPrenom() {
        return sPrenom;
    }

    public long getiIdClient() {
        return iIdClient;
    }

    public void setsPrenom(String sPrenom) {
        this.sPrenom = sPrenom;
    }
}
