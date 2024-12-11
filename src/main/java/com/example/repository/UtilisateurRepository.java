package com.example.repository;

import com.example.model.Livre;
import com.example.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UtilisateurRepository {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public UtilisateurRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("bibliothequePU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public Utilisateur save(Utilisateur Utilisateur) {
        if (Utilisateur.getId() == 0) {
            // Nouveau livre : persist
            entityManager.persist(Utilisateur);
        } else {
            // Livre existant : merge
            Utilisateur = entityManager.merge(Utilisateur);
        }
        return Utilisateur;
    }

    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        entityManager.getTransaction().begin();
        entityManager.persist(utilisateur);
        entityManager.getTransaction().commit();
        return utilisateur;
    }


    public Utilisateur trouverParId(Long id) {
        return entityManager.find(Utilisateur.class, id);
    }

    public List<Utilisateur> listerUtilisateurs() {
        return entityManager.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class).getResultList();
    }

    public void supprimerUtilisateur(Long id) {
        Utilisateur utilisateur = trouverParId(id);
        if (utilisateur != null) {
            entityManager.remove(utilisateur);
        }
    }
}
