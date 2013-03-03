/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ClientDAO;
import DAO.JpaUtil;
import DAO.VoyanceDAO;
import java.util.ArrayList;
import java.util.List;
import modele.Client;
import modele.Employe;
import modele.Horoscope;
import modele.Medium;
import modele.Prediction;

/**
 *
 * @author Kim
 */
public class ServVoyance {
    private Employe eEmploye;
    private Horoscope hHoroscope;
    
    public ServVoyance() {
        this.hHoroscope = new Horoscope();
    }
    
    public Employe identifierEmp(Long iCode) {
        eEmploye = VoyanceDAO.identifyEmp(iCode);
        return (eEmploye!=null)?eEmploye:null;
    }
    
    public Client choisirClient(Client aClient) {
        hHoroscope.setcClient(aClient);
        return aClient;
    }
    
    public List<Prediction> recupPredictions() {
        return VoyanceDAO.recupPredictions();
    }
    
    public boolean selectPrediction(Prediction aPred) {
        return hHoroscope.addPred(aPred);
    }

    public List<Prediction> actualPredictions() {
        return hHoroscope.getPred();
    }

    public void signerHoroscope(Medium mMedium) {
        hHoroscope.setmMedium(mMedium);
    }

    public Medium getmMedium() {
        return hHoroscope.getmMedium();
    }
    
    public Horoscope creerHoroscope() {
        //Création de l'horoscope
        Horoscope tempHoroscope = hHoroscope;
        
        //Réinitialisation des variables
        this.hHoroscope = new Horoscope();
        
        return tempHoroscope;
    }
    
    public void initialisation() {
        VoyanceDAO.init();
    }
}
