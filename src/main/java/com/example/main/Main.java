package com.example.main;

import com.example.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliothequePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Ajouter un exemple de Livre
        Livre livre = new Livre();
        livre.setTitre("Java Avancé");
        livre.setAuteur("John Smith");
        livre.setCategorie("Programmation");
        em.persist(livre);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
