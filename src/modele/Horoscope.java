/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import DAO.ClientDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kim
 */
public class Horoscope {
    private Client cClient;
    private Medium mMedium;
    private String sSigne;
    private List<Prediction> lpPredictions = new ArrayList();

    public Horoscope() {
        this.cClient = null;
        this.mMedium = null;
    }

    public String getsSigne() {
        return sSigne;
    }

    public Client getcClient() {
        return cClient;
    }

    public void setcClient(Client cClient) {
        this.cClient = cClient;
        sSigne = ClientDAO.getSigne(cClient.getiMoisNaissance());
    }

    public Medium getmMedium() {
        return mMedium;
    }

    public void setmMedium(Medium mMedium) {
        this.mMedium = mMedium;
    }

    public List<Prediction> getPred() {
        return lpPredictions;
    }
    
    public boolean complete() {
        return (lpPredictions.size() < 3) ? false : true;
    }

    public boolean addPred(Prediction aPredictions) {
        //On vérifie qu'il n'y a pas déjà eu une prediction de ce type
        boolean valide = true;
        for (int i=0; i < lpPredictions.size(); i++) {
            if (aPredictions.getsType() == lpPredictions.get(i).getsType())
                valide = false;
        }
        
        if (valide)
            lpPredictions.add(aPredictions);
        
        return valide;
    }
}
