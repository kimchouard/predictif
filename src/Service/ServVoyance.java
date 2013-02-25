/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.JpaUtil;
import DAO.VoyanceDAO;
import java.util.ArrayList;
import java.util.List;
import modele.Prediction;

/**
 *
 * @author Kim
 */
public class ServVoyance {
    private int iCodeEmploye;
    private int iActualClient;
    //private int iActualPredictions[3];
    private int iActualMedium;
    List<Integer> liListesMediums = new ArrayList();
    List<Prediction> lpPredictions = new ArrayList();

    public ServVoyance() {
        //JpaUtil.creerEntityManager();
        this.iCodeEmploye = 0;
        this.iActualClient = 0;
        /*for(int i=0;i<3;i++) {
            this.iActualPredictions[i]=0;
        }*/
        this.iActualMedium = 0;
    }
    
    public boolean identifierEmp(int iCode) {
        JpaUtil.ouvrirTransaction();
        iCodeEmploye=VoyanceDAO.identifyEmp(iCode);
        JpaUtil.validerTransaction();
        return (iCodeEmploye!=0)?true:false;
    }
    
    public void initialisation() {
        JpaUtil.ouvrirTransaction();
        VoyanceDAO.init();
        JpaUtil.validerTransaction();
    }
}
