/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ClientDAO;
import DAO.JpaUtil;
import java.util.List;
import modele.Client;

/**
 *
 * @author MrKim
 */
public class ServClient {

    public ServClient() {
        JpaUtil.creerEntityManager();
    }
    
    public void ajouterClient(String asNom, String asPrenom, String asAdresse, String asEmail, int aiMoisNaissance) {
        JpaUtil.ouvrirTransaction();
        //TODO gérer médium
        Client cClient = new Client(asNom, asPrenom, asAdresse, asEmail, aiMoisNaissance);
        ClientDAO.add(cClient);
        JpaUtil.validerTransaction();
    }
    
    public void modifierClient(int niIdClient, String nsNom, String nsPrenom, String nsAdresse, String nsEmail, int niMoisNaissance) {
        JpaUtil.ouvrirTransaction();
        ClientDAO.modifierClient(niIdClient, nsNom, nsPrenom, nsAdresse, nsEmail, niMoisNaissance);
        JpaUtil.validerTransaction();
    }
    
    public List<Client> getClientByName(String aNom) {
        return ClientDAO.getClientByName(aNom);
    }
    
    public void supprimerClient(int aiIdClient) {
        JpaUtil.ouvrirTransaction();
        ClientDAO.delete(aiIdClient);
        JpaUtil.validerTransaction();
    }
}
