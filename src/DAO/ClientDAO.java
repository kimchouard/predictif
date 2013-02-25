/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.Query;
import modele.Client;
import modele.Medium;

/**
 *
 * @author MrKim
 */
public class ClientDAO {
    public static void add(Client aClient) {
        JpaUtil.obtenirEntityManager().persist(aClient);
    }
    public static void add(Medium aMedium) {
        JpaUtil.obtenirEntityManager().persist(aMedium);
    }
    
    public static List<Client> getClientByName(String aNom) {
        String sQuery = "select c from Client c where c.sNom=\""+aNom+"\"";
        Query query = JpaUtil.obtenirEntityManager().createQuery(sQuery);
        List<Client> find = (List<Client>) query.getResultList();
        
        return find;
    }
    
    public static void modifierClient(Long niIdClient, String nsNom, String nsPrenom, String nsAdresse, String nsEmail, int niMoisNaissance) {
        Client cClient = JpaUtil.obtenirEntityManager().find(Client.class, niIdClient);
        
        cClient.setsAdresse(nsAdresse);
        cClient.setsEmail(nsEmail);
        cClient.setiMoisNaissance(niMoisNaissance);
        cClient.setsNom(nsNom);
        cClient.setsPrenom(nsPrenom);
    }
    
    public static void deleteClient(Long aiIdClient) {
        
    }
}
