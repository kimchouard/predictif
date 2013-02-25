/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predict.pkgif;

import Service.ServClient;
import Service.ServVoyance;
import java.util.List;
import modele.Client;


/**
 *
 * @author MrKim
 */
public class PredictIF {
    
    public static ServClient servClient = new ServClient();
    public static ServVoyance ServVoyance = new ServVoyance();
    
    //Créer un client
    public static void initialiserApp() throws Exception {
        ServVoyance.initialisation();
    }
    
    //Créer un client
    public static List<Client> afficherClients(String aNom) throws Exception {
        return servClient.clientParNom(aNom);
    }
    
    //Créer un client
    public static void supprimerClient(Long iId) throws Exception {
        servClient.supprimerClient(iId);
    }
    
    //Créer un client
    public static void modifierClient(Long niIdClient, String nsNom, String nsPrenom, String nsAdresse, String nsEmail, int niMoisNaissance) throws Exception {
        servClient.modifierClient(niIdClient, nsNom, nsPrenom, nsAdresse, nsEmail, niMoisNaissance);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\n ******* creation");
        
        // TODO code application logic heretry {
        try {
            //Essayer medium
            
            System.out.println("initialiser");
            initialiserApp();
            System.out.println("inititaliser OK \n");
            
            /*System.out.println("afficherClients");
            List<Client> clients = afficherClients("Robert");
            System.out.println("afficherClients OK \n");
            
            Client robert = clients.get(0);
            
            
            System.out.println("modifierClient");
            modifierClient(robert.getiIdClient(), robert.getsNom(), robert.getsPrenom(), robert.getsAdresse(), robert.getsEmail(), 7);
            System.out.println("modifierClient OK \n");
            
            
            System.out.println("supprimerClient");
            supprimerClient(robert.getiIdClient());
            System.out.println("supprimerClient OK \n");*/
            
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}
