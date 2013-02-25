/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Kim
 */
@Entity
public class Prediction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int iIdPred;
    protected String eType;
    protected int iIntensite;
    protected String iIntitulle;

    public Prediction() {
    }

    public Prediction(String eType, int iIntensite, String iIntitulle) {
        this.eType = eType;
        this.iIntensite = iIntensite;
        this.iIntitulle = iIntitulle;
    }

    public int getiIdPred() {
        return iIdPred;
    }

    public void setiIdPred(int iIdPred) {
        this.iIdPred = iIdPred;
    }

    public String geteType() {
        return eType;
    }

    public void seteType(String eType) {
        this.eType = eType;
    }

    public int getiIntensite() {
        return iIntensite;
    }

    public void setiIntensite(int iIntensite) {
        this.iIntensite = iIntensite;
    }

    public String getiIntitulle() {
        return iIntitulle;
    }

    public void setiIntitulle(String iIntitulle) {
        this.iIntitulle = iIntitulle;
    }
    
    
}
