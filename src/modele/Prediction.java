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
 * @author Kim
 */
@Entity
public class Prediction implements Serializable {
    public enum Type {
        AMOUR, TRAVAIL, SANTE, TOUT
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long iIdPred;
    protected String sType;
    protected int iIntensite;
    protected String iIntitulle;

    public Prediction() {
    }

    public Prediction(String sType, int iIntensite, String iIntitulle) {
        this.sType = sType;
        this.iIntensite = iIntensite;
        this.iIntitulle = iIntitulle;
    }

    public Long getiIdPred() {
        return iIdPred;
    }

    public String getsType() {
        return sType;
    }

    public void seteType(String sType) {
        this.sType = sType;
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
