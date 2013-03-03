/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ClientDAO;
import DAO.JpaUtil;
import java.util.List;
import modele.Client;
import modele.Employe;
import modele.Medium;

/**
 *
 * @author MrKim
 */
public class ServClient {

    public ServClient() {
        JpaUtil.creerEntityManager();
    }
    
    public void ajouterClient(Client cClient) {
        JpaUtil.ouvrirTransaction();
        ClientDAO.add(cClient);
        JpaUtil.validerTransaction();
    }
    
    public void ajouterMedium(Medium mMedium) {
        JpaUtil.ouvrirTransaction();
        ClientDAO.add(mMedium);
        JpaUtil.validerTransaction();
    }
    
    public void ajouterEmploye(Employe eEmploye) {
        JpaUtil.ouvrirTransaction();
        ClientDAO.add(eEmploye);
        JpaUtil.validerTransaction();
    }
    
    public void modifierClient(Long niIdClient, String nsNom, String nsPrenom, String nsAdresse, String nsEmail, int niMoisNaissance) {
        JpaUtil.ouvrirTransaction();
        ClientDAO.modifierClient(niIdClient, nsNom, nsPrenom, nsAdresse, nsEmail, niMoisNaissance);
        JpaUtil.validerTransaction();
    }
    
    public List<Client> clientParNom(String aNom) {
        return ClientDAO.getClientByName(aNom);
    }
    
    public String signeAstro(int iMois) {
        return ClientDAO.getSigne(iMois);
    }
    
    public List<Medium> mediumParClient(Long iIdClient) {
        return ClientDAO.getMediumByClient(iIdClient);
    }
    
    public void supprimerClient(Long aiIdClient) {
        JpaUtil.ouvrirTransaction();
        ClientDAO.deleteClient(aiIdClient);
        JpaUtil.validerTransaction();
    }
}
