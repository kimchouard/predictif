/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predict.pkgif;

import Service.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modele.*;
import modele.Prediction.Type;


/**
 *
 * @author MrKim
 */
public class PredictIF {
    
    public static ServClient servClient = new ServClient();
    public static ServVoyance ServVoyance = new ServVoyance();
    
    //Récupérer les clients
    public static Client getClient() {
        Scanner scanner = new Scanner( System.in );
        String input;
        
        System.out.println("Merci de rentrer le nom :");
        String sNom = scanner.nextLine();
        System.out.println("Merci de rentrer le prénom :");
        String sPrenom = scanner.nextLine();
        System.out.println("Merci de rentrer l'adresse :");
        String sAdresse = scanner.nextLine();
        System.out.println("Merci de rentrer l'email :");
        String sEmail = scanner.nextLine();
        int iMoisNaissance;
        do {
            System.out.println("Merci de rentrer le mois de naissance (1-12) :");
            String sMois = scanner.nextLine();
            iMoisNaissance = Integer.valueOf(sMois);
        } while (iMoisNaissance == 0 && iMoisNaissance > 12);

        System.out.println("Mediums disponibles : ");
        List<Medium> lMed = servClient.recupMediums();
        int o = 0;
        for (Medium p : lMed) {
            System.out.println(o+") "+p.getsNom());
            o++;
        }
        List<Medium> mChoisis = new ArrayList();
        int idMed;
        do {
            System.out.println("Choisissez un medium grace à son chiffre :");
            input = scanner.nextLine();
            idMed = Integer.valueOf(input);
        } while (!(idMed < lMed.size()) && (idMed >= 0));
         mChoisis.add(lMed.get(idMed));

        Client cTemp = new Client(sNom, sPrenom, sAdresse, sEmail, iMoisNaissance, mChoisis);
        
        return cTemp;
    }
    
    //Afficher les clients en fonction de leur nom
    public static List<Client> afficherClients(String aNom) {
        List<Client> lClient = servClient.clientParNom(aNom);
        int j = 0;
        for (Client i : lClient) {
            System.out.println(j+") "+i.getsNom()+" "+i.getsPrenom());
            j++;
        }
        return lClient;
    }
    
    //Chercher des clients
    public static Client chercherClient() {
        Scanner scanner = new Scanner( System.in );
        String input;
        
        System.out.println("Merci de rentrer le nom du client recherché :");
        String sNom = scanner.nextLine();

        List<Client> lClient = afficherClients(sNom);
        int idClient;
        do {
            System.out.println("Choisissez un client grace à son chiffre :");
            input = scanner.nextLine();
            idClient = Integer.valueOf(input);
        } while (!(idClient < lClient.size()) && (idClient >= 0));
        Client cChoisit = lClient.get(idClient);
        
        return cChoisit;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //----------------------------------------------------------------------------
            //                          Initialisation
            //----------------------------------------------------------------------------
            Scanner scanner = new Scanner( System.in );
            String input;
            
            //System.out.println("Press Enter to lunch the application.");
            //scanner.nextLine();
            
            ServVoyance.initialisation();
            System.out.println("Initialisation terminée.\n");
            do {
                System.out.println("Merci de chosir un mode de gestion : 1) Client, 2) Horoscope.");
                input = scanner.nextLine();
                System.out.println("Valeur rentrée : "+input);
            } while (!(("1".equals(input))||("2".equals(input))));
            
            
            
            //----------------------------------------------------------------------------
            //                          Gestion Clients
            //----------------------------------------------------------------------------
            if ("1".equals(input)) {
                do {
                   System.out.println("Liste des clients :");
                   afficherClients("");
                    
                    do {
                        System.out.println("Voulez-vous : 1) Ajouter un client, 2) Chercher/Modifier un client, 3) Chercher/Supprimer un client.");
                        input = scanner.nextLine();
                        System.out.println("Valeur rentrée : "+input);
                    } while (!(("1".equals(input))||("2".equals(input))||("3".equals(input))));

                //----------------------------------------------------------------------------
                //                          Ajouter Client
                //----------------------------------------------------------------------------
                    if ("1".equals(input)) {
                        Client cTemp = getClient();

                        servClient.ajouterClient(cTemp);
                    }

                //----------------------------------------------------------------------------
                //                          Chercher/Modifier Client
                //----------------------------------------------------------------------------
                    else if ("2".equals(input)) {
                        Client cTemp = chercherClient();

                        System.out.println("Merci de rentrer les nouvelles informations du client :");
                        Client cNew = getClient();

                        servClient.modifierClient(cTemp.getiIdClient(),cNew.getsNom(), cNew.getsPrenom(), cNew.getsAdresse(), cNew.getsEmail(), cNew.getiMoisNaissance());
                    }

                //----------------------------------------------------------------------------
                //                          Chercher/Supprimer Client
                //----------------------------------------------------------------------------
                    else if ("3".equals(input)) {
                        Client cTemp = chercherClient();

                        System.out.println("Voulez vous supprimer "+cTemp.getsNom()+" "+cTemp.getsPrenom());

                        servClient.supprimerClient(cTemp.getiIdClient());
                    }
                    
                    System.out.println("La journée est-elle terminée ? (Y/N)");
                    input = scanner.nextLine();
                } while (!"Y".equals(input));
            }
            
            //----------------------------------------------------------------------------
            //                       Fin Gestion Clients
            //----------------------------------------------------------------------------
            
            
            
            //----------------------------------------------------------------------------
            //                          Gestion Horoscope
            //----------------------------------------------------------------------------
            else if ("2".equals(input)) {
            //----------------------------------------------------------------------------
            //                          Connexion
                Employe eActuel;

                do {
                    System.out.println("Connectez vous avec un code valide :");
                    input = scanner.nextLine();
                    eActuel = ServVoyance.identifierEmp(Long.valueOf(input));
                } while(eActuel == null);
                System.out.println("Connexion OK \n");
                
                do {
                //----------------------------------------------------------------------------
                //                          Choix client
                    System.out.println("Clients disponibles : ");
                    List<Client> lClient = eActuel.getlClients();
                    int j = 0;
                    for (Client i : lClient) {
                        System.out.println(j+") "+i.getsNom()+" "+i.getsPrenom());
                        j++;
                    }
                    int idClient;
                    do {
                        System.out.println("Choisissez un client grace à son chiffre :");
                        input = scanner.nextLine();
                        idClient = Integer.valueOf(input);
                    } while (!(idClient < lClient.size()) && (idClient >= 0));
                    Client cChoisit = lClient.get(idClient);
                    ServVoyance.choisirClient(cChoisit);
                    System.out.println("Client valide.\n");

                //----------------------------------------------------------------------------
                //                          Choix prédictions
                    for (int i=0;i<3;i++) {
                        System.out.println("Recupération des prédictions "+Type.values()[i]);
                        List<Prediction> lPred = ServVoyance.recupPredictions(Type.values()[i]);
                        int k = 0;
                        for (Prediction l : lPred) {
                            System.out.println(k+") "+l.getiIntitulle());
                            k++;
                        }
                        int idPred;
                        do {
                            System.out.println("Choisissez une prediction grace à son chiffre :");
                            input = scanner.nextLine();
                            idPred = Integer.valueOf(input);
                        } while (!(idPred < lPred.size()) && (idPred >= 0));
                        Prediction pChoisit = lPred.get(idPred);
                        ServVoyance.selectPrediction(pChoisit);
                        System.out.println("Prediction valide.\n");
                    }

                //----------------------------------------------------------------------------
                //                          Signature médium
                    System.out.println("Signer horoscope avec un medium :");
                    List<Medium> lMed = cChoisit.getmMediums();
                    int n = 0;
                    for (Medium m : lMed) {
                        System.out.println(n+") "+m.getsNom());
                        n++;
                    }
                    int idMed;
                    do {
                        System.out.println("Choisissez une prediction grace à son chiffre :");
                        input = scanner.nextLine();
                        idMed = Integer.valueOf(input);
                    } while (!(idMed < lMed.size()) && (idMed >= 0));
                    Medium mChoisit = lMed.get(idMed);
                    ServVoyance.signerHoroscope(mChoisit);
                    System.out.println("Medium valide. Horoscope Signé.\n");

                //----------------------------------------------------------------------------
                //                          Finalisation de l'horoscope 
                    System.out.println("Appuyer sur entrée pour finir l'horoscope.");
                    input = scanner.nextLine();
                    Horoscope hActuel = ServVoyance.creerHoroscope();
                    System.out.println("Horoscope terminé :\n");
                    System.out.println(hActuel.getcClient().getsNom()+" "+hActuel.getcClient().getsPrenom());
                    System.out.println(hActuel.getcClient().getsAdresse());
                    System.out.println("Votre n° client : "+hActuel.getcClient().getiIdClient());
                    System.out.println("Votre signe astrologique : "+hActuel.getsSigne());
                    String Meds = "";
                    for (Medium med : hActuel.getcClient().getmMediums()) { Meds+=med.getsNom()+", "; }
                    System.out.println("Vos médiums préférés : "+Meds);
                    
                    System.out.println("\n Cher "+hActuel.getcClient().getsPrenom()+", votre voyance vous est offerte par "+hActuel.getmMedium().getsNom()+"\n");
                    
                    for (Prediction pred : hActuel.getPred()) {
                        System.out.println(pred.getsType()+" ("+pred.getiIntensite()+") : "+pred.getiIntitulle()+"\n");
                    }
                    
                    System.out.println("La journée est-elle terminée ? (Y/N)");
                    input = scanner.nextLine();
                } while (!"Y".equals(input));
            }
            //----------------------------------------------------------------------------
            //                         Fin Gestion Horoscope
            //----------------------------------------------------------------------------
            
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}
