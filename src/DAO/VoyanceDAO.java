/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Service.ServClient;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modele.Client;
import modele.Employe;
import modele.Medium;
import modele.Prediction;
import modele.Prediction.Type;

/**
 *
 * @author Kim
 */
public class VoyanceDAO {
    
    public static ServClient servClient = new ServClient();
    
    public static Employe identifyEmp(Long iCode) {
        Employe cEmp = JpaUtil.obtenirEntityManager().find(Employe.class, iCode);
        
        return (cEmp!=null)?cEmp:null;
    }
        
    public static List<Prediction> recupPredictions() {
        //On récupère tous les employé triés par nombre de clients
        String sQuery = "select p from Prediction p order by p.eType";
        Query query = JpaUtil.obtenirEntityManager().createQuery(sQuery);
        List<Prediction> find = (List<Prediction>) query.getResultList();
        
        return find;
    }
    
    public static void init() {
        //---------------------------------- Mediums ---------------------------
        Medium m1 = new Medium("Gourou");
        Medium m2 = new Medium("Pere Fourra");
        Medium m3 = new Medium("Madame Irma");
        servClient.ajouterMedium(m1);
        servClient.ajouterMedium(m2);
        servClient.ajouterMedium(m3);
        
        //---------------------------------- Employes ---------------------------
        Employe e1 = new Employe();
        Employe e2 = new Employe();
        servClient.ajouterEmploye(e1);
        servClient.ajouterEmploye(e2);
        
        //---------------------------------- Clients ---------------------------
        List<Medium> l1 = new ArrayList<>();
        l1.add(m1);
        l1.add(m2);
        List<Medium> l2 = new ArrayList<>();
        l2.add(m1);
        l2.add(m3);
        List<Medium> l3 = new ArrayList<>();
        l3.add(m3);
        l3.add(m2);
        
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
        
        //---------------------------------- Predictions ---------------------------
        JpaUtil.ouvrirTransaction();
        Prediction p1 = new Prediction(Type.AMOUR, 4, "Tout est bien dans le meilleur des mondes.");
        Prediction p2 = new Prediction(Type.AMOUR, 2, "Les hommes ne demanderont qu'à être chouchoutés et ne penseront pas à courir les jupons, alors que les femmes ne chercheront qu'à faire plaisir à leurs partenaires. ");
        Prediction p3 = new Prediction(Type.AMOUR, 1, "Vénus, la planète de l'amour, sera bien placée pour vous, mais elle ne sera pas la seule, et vous aurez tellement à faire par ailleurs que vos émois sentimentaux ne seront pas prioritaires.");
        Prediction p4 = new Prediction(Type.AMOUR, 3, "Trop manger de sarces va finir par vous porter préjudice.");
        
        Prediction p5 = new Prediction(Type.TRAVAIL, 1, "Climat professionnel un peu confus sous l'impact d'aspects planétaires contradictoires.");
        Prediction p6 = new Prediction(Type.TRAVAIL, 2, "Méfiez-vous : vous serez assez distrait et risquez d'oublier des choses importantes.");
        Prediction p7 = new Prediction(Type.TRAVAIL, 3, "Attention également à bien vous faire comprendre de vos interlocuteurs, de manière à éviter tout malentendu.");
        Prediction p8 = new Prediction(Type.TRAVAIL, 4, "Ne vous rendez pas au travail, votre boss vous annonce un licenciement économique.");
        
        Prediction p9 = new Prediction(Type.SANTE, 2, "Votre énergie sera en nette hausse.");
        Prediction p10 = new Prediction(Type.SANTE, 3, "Vous serez en grande forme physique et morale, et ferez preuve d'un élan qui fera plaisir à voir.");
        Prediction p11 = new Prediction(Type.SANTE, 1, "Votre trop-plein d'énergie risque de se changer en stress.");
        Prediction p12 = new Prediction(Type.SANTE, 4, "Vous allez mourir demain. Profitez bien de votre dernière journée sur cette douce planète.");
        
        JpaUtil.obtenirEntityManager().persist(p1);
        JpaUtil.obtenirEntityManager().persist(p2);
        JpaUtil.obtenirEntityManager().persist(p3);
        JpaUtil.obtenirEntityManager().persist(p4);
        JpaUtil.obtenirEntityManager().persist(p5);
        JpaUtil.obtenirEntityManager().persist(p6);
        JpaUtil.obtenirEntityManager().persist(p7);
        JpaUtil.obtenirEntityManager().persist(p8);
        JpaUtil.obtenirEntityManager().persist(p9);
        JpaUtil.obtenirEntityManager().persist(p10);
        JpaUtil.obtenirEntityManager().persist(p11);
        JpaUtil.obtenirEntityManager().persist(p12);
        JpaUtil.validerTransaction();
    }
}
