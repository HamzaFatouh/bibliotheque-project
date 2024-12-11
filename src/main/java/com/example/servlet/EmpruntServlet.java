package com.example.servlet;

import com.example.model.Emprunt;
import com.example.model.Livre;
import com.example.model.Utilisateur;
import com.example.repository.EmpruntRepository;
import com.example.repository.LivreRepository;
import com.example.repository.UtilisateurRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
@WebServlet("/emprunt")
public class EmpruntServlet extends HttpServlet {

    private EmpruntRepository empruntRepository = new EmpruntRepository();
    private LivreRepository livreRepository = new LivreRepository();
    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long livreId = Long.parseLong(request.getParameter("livreId"));
        Long utilisateurId = Long.parseLong(request.getParameter("utilisateurId"));

        Livre livre = livreRepository.trouverParId(livreId);
        Utilisateur utilisateur = utilisateurRepository.trouverParId(utilisateurId);

        if (livre != null && utilisateur != null) {
            Emprunt emprunt = new Emprunt(livre, utilisateur, new Date(), null);
            empruntRepository.enregistrerEmprunt(emprunt);
        }

        response.sendRedirect("/emprunts");
    }
}
