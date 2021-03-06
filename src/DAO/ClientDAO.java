/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.Query;
import modele.*;

/**
 *
 * @author MrKim
 */
public class ClientDAO {
    public static void add(Client aClient) {
        JpaUtil.obtenirEntityManager().persist(aClient);
        
        //On récupère tous les employé triés par nombre de clients
        String sQuery = "select e from Employe e order by e.iNbClient ASC";
        Query query = JpaUtil.obtenirEntityManager().createQuery(sQuery);
        List<Employe> find = (List<Employe>) query.getResultList();
        
        //On affecte ensuite le client actuel à l'employé qui à le moins de clients
        Employe empAct = find.get(0);
        empAct.addClient(aClient);
    }
    public static void add(Medium aMedium) {
        JpaUtil.obtenirEntityManager().persist(aMedium);
    }
    public static void add(Employe eEmploye) {
        JpaUtil.obtenirEntityManager().persist(eEmploye);
    }
    
    public static List<Client> getClientByName(String aNom) {
        String sQuery = "select c from Client c ";
        if (aNom != "") {
            sQuery += "where c.sNom=\""+aNom+"\"";
        }
        
        Query query = JpaUtil.obtenirEntityManager().createQuery(sQuery);
        List<Client> find = (List<Client>) query.getResultList();
        
        return find;
    }
    
    public static String getSigne(int iMois) {
        String sQuery = "select s from SigneAstro s where s.iMois="+iMois;
        Query query = JpaUtil.obtenirEntityManager().createQuery(sQuery);
        List<SigneAstro> find = (List<SigneAstro>) query.getResultList();
        
        return find.get(0).getsAstro();
    }
    
    public static List<Medium> getMediums() {
        String sQuery = "select m from Medium m";
        Query query = JpaUtil.obtenirEntityManager().createQuery(sQuery);
        List<Medium> find = (List<Medium>) query.getResultList();
        
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
        //Récupération du client à supprimer
        Client cClient = JpaUtil.obtenirEntityManager().find(Client.class, aiIdClient);
        
        //Suppression du lien avec l'employé
        String sQuery = "select e from Employe e";
        Query query = JpaUtil.obtenirEntityManager().createQuery(sQuery);
        List<Employe> lEmp = (List<Employe>) query.getResultList();
        
        for (Employe emp : lEmp) {
            for (Client eClient : emp.getlClients()) {
                if (eClient == cClient) {
                    emp.getlClients().remove(eClient);
                    break;
                }
            }
        }
        
        //Suppression du client.
        JpaUtil.obtenirEntityManager().remove(cClient);
    }
}
