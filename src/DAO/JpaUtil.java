/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

/**
 * Cette classe fournit des m?thodes statiques utiles pour acc?der aux
 * fonctionnalit?s de JPA (Entity Manager, Entity Transaction). Le nom de
 * l'unit? de persistance (PERSISTENCE_UNIT_NAME) doit ?tre conforme ? la
 * configuration indiqu?e dans le fichier persistence.xml du projet.
 * @author DASI Team
 */
public class JpaUtil {

    // *************************************************************************************
    // * TODO: IMPORTANT -- Adapter le nom de l'Unit? de Persistance (cf. persistence.xml) *
    // *************************************************************************************
    /**
     * Nom de l'unit? de persistance utilis?e par la Factory de Entity Manager.
     * <br/><strong>V?rifier le nom de l'unit? de persistance (cf.&nbsp;persistence.xml)</strong>
     */
    public static final String PERSISTENCE_UNIT_NAME = "Predict_IFPU";
    /**
     * Factory de Entity Manager li?e ? l'unit? de persistance.
     * <br/><strong>V?rifier le nom de l'unit? de persistance indiqu?e dans l'attribut statique PERSISTENCE_UNIT_NAME (cf.&nbsp;persistence.xml)</strong>
     */
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    /**
     * G?re les instances courantes de Entity Manager li?es aux Threads.
     * L'utilisation de ThreadLocal garantie une unique instance courante par Thread.
     */
    private static final ThreadLocal<EntityManager> threadLocalEntityManager = new ThreadLocal<EntityManager>() {

        @Override
        protected EntityManager initialValue() {
            return null;
        }
    };

    // Essai pour avoir des messages de Log dans le bon ordre
    private static void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
        }
    }

    private static void log(String message) {
        System.out.flush();
        pause(5);
        System.err.println(message);
        System.err.flush();
        pause(5);
    }

    ;

    /**
     * Cr??e l'instance courante de Entity Manager (li?e ? ce Thread).
     * <br/><strong>? utiliser uniquement au niveau Service.</strong>
     * @return instance de Entity Manager
     */
    public static void creerEntityManager() {
        log("cr?ation du contexte de persistance");
        threadLocalEntityManager.set(entityManagerFactory.createEntityManager());
    }

    /**
     * Ferme l'instance courante de Entity Manager (li?e ? ce Thread).
     * <br/><strong>? utiliser uniquement au niveau Service.</strong>
     */
    public static void fermerEntityManager() {
        log("fermeture du contexte de persistance");
        EntityManager em = threadLocalEntityManager.get();
        em.close();
        threadLocalEntityManager.set(null);
    }

    /**
     * D?marre une transaction sur l'instance courante de Entity Manager.
     * <br/><strong>? utiliser uniquement au niveau Service.</strong>
     */
    public static void ouvrirTransaction() {
        log("debut transaction");
        EntityManager em = threadLocalEntityManager.get();
        em.getTransaction().begin();
    }

    /**
     * Valide la transaction courante sur l'instance courante de Entity Manager.
     * <br/><strong>? utiliser uniquement au niveau Service.</strong>
     * @exception RollbackException lorsque le <em>commit</em> n'a pas r?ussi.
     */
    public static void validerTransaction() throws RollbackException {
        log("commit transaction");
        EntityManager em = threadLocalEntityManager.get();
        em.getTransaction().commit();
    }

    /**
     * Annule la transaction courante sur l'instance courante de Entity Manager.
     * Si la transaction courante n'est pas d?marr?e, cette m?thode n'effectue aucune op?ration.
     * <br/><strong>? utiliser uniquement au niveau Service.</strong>
     */
    public static void annulerTransaction() {
        log("rollback transaction");
        EntityManager em = threadLocalEntityManager.get();
        if (em.getTransaction().isActive()) {
            log("rollback transaction effectue");
            em.getTransaction().rollback();
        }
    }

    /**
     * Retourne l'instance courante de Entity Manager.
     * <br/><strong>? utiliser uniquement au niveau DAO.</strong>
     * @return instance de Entity Manager
     */
    protected static EntityManager obtenirEntityManager() {
        log("obtention du contexte de persistance");
        return threadLocalEntityManager.get();
    }
}