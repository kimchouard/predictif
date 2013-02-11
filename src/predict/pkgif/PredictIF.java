/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package predict.pkgif;

import Service.ServClient;


/**
 *
 * @author MrKim
 */
public class PredictIF {
    
    public static ServClient servClient = new ServClient();
    
    //Créer un client
    public static void creerClient() throws Exception {
        servClient.ajouterClient("Robert", "Hyvan", "86 Rue des tilleuls", "prout@hotmail.com", 4);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\n ******* creation");
        
        // TODO code application logic heretry {
        try {
            //Essayer medium
            
            System.out.println("creerClient");
            creerClient();
            System.out.println("creerEquipeVide OK \n");
            
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}
