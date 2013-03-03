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
import modele.Medium;
import modele.Prediction;

/**
 *
 * @author Kim
 */
public class ServVoyance {
    private Employe eEmploye;
    private Client cClient;
    private int[] iActualPredictions = new int[3];
    private int iActualMedium;
    List<Integer> liListesMediums = new ArrayList();

    public ServVoyance() {
        //JpaUtil.creerEntityManager();
        this.eEmploye = null;
        this.cClient = null;
        for(int i=0;i<3;i++) {
            this.iActualPredictions[i]=0;
        }
        this.iActualMedium = 0;
    }
    
    public Employe identifierEmp(Long iCode) {
        eEmploye = VoyanceDAO.identifyEmp(iCode);
        return (eEmploye!=null)?eEmploye:null;
    }
    
    public Client choisirClient(Client aClient) {
        cClient = aClient;
        return cClient;
    }
    
    public List<Prediction> recupPredictions() {
        return VoyanceDAO.recupPredictions();
    }
    
    public void initialisation() {
        VoyanceDAO.init();
    }
}
