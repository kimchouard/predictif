/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predict.pkgif;

import Service.ServClient;
import Service.ServVoyance;
import java.util.List;
import modele.Client;
import modele.Employe;
import modele.Horoscope;
import modele.Medium;
import modele.Prediction;


/**
 *
 * @author MrKim
 */
public class PredictIF {
    
    public static ServClient servClient = new ServClient();
    public static ServVoyance ServVoyance = new ServVoyance();
    
    //Rentrez les valeurs de base
    public static void initialiserApp() throws Exception {
        ServVoyance.initialisation();
    }
    
    //Loguer un employé
    public static Employe idEmp(Long idEmp) throws Exception {
        return ServVoyance.identifierEmp(idEmp);
    }
    
    //Choisir un client
    public static Client choixClient(Client aClient) throws Exception {
        return ServVoyance.choisirClient(aClient);
    }
    
    //Choisir une prediction
    public static boolean choixPred(Prediction pPred) throws Exception {
        return ServVoyance.selectPrediction(pPred);
    }
    
    //Choisir un medium
    public static void choixMedium(Medium mMed) throws Exception {
        ServVoyance.signerHoroscope(mMed);
    }
    
    //Finaliser Horoscope
    public static Horoscope finirHoroscope() throws Exception {
        return ServVoyance.creerHoroscope();
    }
    
    //Afficher les clients
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
            
            System.out.println("connexion");
            Employe eActuel = idEmp(Long.valueOf(5));
            if (eActuel != null) {
                System.out.println("connexion OK \n");
            
                System.out.println("choix client");
                Client cActuel = choixClient(eActuel.getlClients().get(0));
                System.out.println("choix client OK \n");

                System.out.println("Recup prédictions");
                List<Prediction> lPred = ServVoyance.recupPredictions();
                System.out.println("Recup prédictions OK \n");

                System.out.println("Pred 1");
                choixPred(lPred.get(0));
                System.out.println("Pred 1 OK \n");

                System.out.println("Pred 2");
                choixPred(lPred.get(4));
                System.out.println("Pred 2 OK \n");

                System.out.println("Pred 3");
                choixPred(lPred.get(9));
                System.out.println("Pred 3 OK \n");

                System.out.println("Signer horoscope");
                choixMedium(cActuel.getmMediums().get(0));
                System.out.println("Signer Horoscope OK \n");

                System.out.println("Finir horoscope");
                Horoscope hActuel = finirHoroscope();
                System.out.println("Finir Horoscope OK \n");
            }
            else
            {
                System.out.println("Connexion échoué.");
            }
            
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
