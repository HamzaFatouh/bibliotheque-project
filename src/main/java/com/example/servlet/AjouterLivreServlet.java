package com.example.servlet;

import com.example.model.Livre;
import com.example.repository.LivreRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajouterLivre")
public class AjouterLivreServlet extends HttpServlet {
    private LivreRepository livreRepository = new LivreRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String categorie = request.getParameter("categorie");
        boolean disponibilite = request.getParameter("disponibilite") != null;

        Livre livre = new Livre(titre, auteur, categorie, disponibilite);
        livreRepository.save(livre);

        response.sendRedirect("livres");
    }
}
