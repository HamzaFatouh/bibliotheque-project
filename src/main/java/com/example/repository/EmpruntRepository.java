package com.example.repository;

import com.example.model.Emprunt;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class EmpruntRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Emprunt enregistrerEmprunt(Emprunt emprunt) {
        entityManager.persist(emprunt);
        return emprunt;
    }

    public List<Emprunt> listerEmprunts() {
        return entityManager.createQuery("SELECT e FROM Emprunt e", Emprunt.class).getResultList();
    }

    public Emprunt trouverParId(Long id) {
        return entityManager.find(Emprunt.class, id);
    }
}
