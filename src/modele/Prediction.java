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
        AMOUR, TRAVAIL, SANTE
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long iIdPred;
    protected Type eType;
    protected int iIntensite;
    protected String iIntitulle;

    public Prediction() {
    }

    public Prediction(Type eType, int iIntensite, String iIntitulle) {
        this.eType = eType;
        this.iIntensite = iIntensite;
        this.iIntitulle = iIntitulle;
    }

    public Long getiIdPred() {
        return iIdPred;
    }

    public Type geteType() {
        return eType;
    }

    public void seteType(Type eType) {
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
