/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Service.ServClient;
import java.util.ArrayList;
import java.util.List;
import modele.Client;
import modele.Employe;
import modele.Medium;

/**
 *
 * @author Kim
 */
public class VoyanceDAO {
    
    public static ServClient servClient = new ServClient();
    
    public static int identifyEmp(int iCode) {
        Employe cEmp = JpaUtil.obtenirEntityManager().find(Employe.class, iCode);
        return (cEmp!=null)?iCode:0;
    }
    
    public static void init() {
        Medium m1 = new Medium("Gourou");
        Medium m2 = new Medium("Pere Fourra");
        Medium m3 = new Medium("Madame Irma");
        servClient.ajouterMedium(m1);
        servClient.ajouterMedium(m2);
        servClient.ajouterMedium(m3);
        
        /*List<Medium> l1 = new ArrayList<>();
        l1.add(m1);
        l1.add(m2);
        List<Medium> l2 = new ArrayList<>();
        l1.add(m1);
        l1.add(m3);
        List<Medium> l3 = new ArrayList<>();
        l1.add(m3);
        l1.add(m2);
        
        Client c1 = new Client("Robert", "Hyvan", "86 Rue des tilleuls", "prout@hotmail.com", 4, l1);
        Client c2 = new Client("Robert", "Pattinson", "86 Rue du zale", "bogos@hotmail.com", 3, l2);
        Client c3 = new Client("Legrand", "Jaques", "86 Rue rue rue", "petit@hotmail.com", 6, l3);
        Client c4 = new Client("Lalane", "Francis", "86 Rue des tilleuls", "enigme@hotmail.com", 2, l3);
        Client c5 = new Client("Dartus", "Pissou", "Carton du coin", "oreiller@hotmail.com", 8, l2);
        
        servClient.ajouterClient(c1);
        servClient.ajouterClient(c2);
        servClient.ajouterClient(c3);
        servClient.ajouterClient(c4);
        servClient.ajouterClient(c5);
        
        
        List<Client> l4 = new ArrayList<>();
        l4.add(c1);
        l4.add(c2);
        l4.add(c3);
        List<Client> l5 = new ArrayList<>();
        l5.add(c1);
        l5.add(c4);
        l5.add(c5);
        
        
        Employe e1 = new Employe(l4);
        Employe e2 = new Employe(l5);
        JpaUtil.obtenirEntityManager().persist(e1);
        JpaUtil.obtenirEntityManager().persist(e2);*/
    }
}
