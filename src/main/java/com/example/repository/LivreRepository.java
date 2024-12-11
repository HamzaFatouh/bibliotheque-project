package com.example.repository;

import com.example.model.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class LivreRepository {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    // Constructeur qui initialise l'EntityManagerFactory et EntityManager
    public LivreRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("bibliothequePU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Méthode pour enregistrer ou mettre à jour un livre
    public Livre save(Livre livre) {
        entityManager.getTransaction().begin();
        if (livre.getId() == 0) {
            entityManager.persist(livre); // Nouveau livre : persist
        } else {
            livre = entityManager.merge(livre); // Livre existant : merge
        }
        entityManager.getTransaction().commit();
        return livre;
    }

    // Ajouter un livre
    public Livre ajouterLivre(Livre livre) {
        entityManager.getTransaction().begin();
        entityManager.persist(livre);
        entityManager.getTransaction().commit();
        return livre;
    }

    // Lister tous les livres
    public List<Livre> listerLivres() {
        return entityManager.createQuery("SELECT l FROM Livre l", Livre.class).getResultList();
    }

    // Trouver un livre par son ID
    public Livre trouverParId(Long id) {
        return entityManager.find(Livre.class, id);
    }

    // Supprimer un livre
    public void supprimerLivre(Long id) {
        Livre livre = trouverParId(id);
        if (livre != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(livre);
            entityManager.getTransaction().commit();
        }
    }

    // Fermer le EntityManager et EntityManagerFactory
    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
