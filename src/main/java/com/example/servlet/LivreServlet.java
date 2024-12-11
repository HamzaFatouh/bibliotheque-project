package com.example.servlet;

import com.example.model.Livre;
import com.example.model.Utilisateur;
import com.example.repository.LivreRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/livres")
public class LivreServlet extends HttpServlet {

    private LivreRepository livreRepository = new LivreRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Livre> livres = livreRepository.listerLivres();
        System.out.println("Livres récupérés : " + livres);
        request.setAttribute("livres", livres);
        request.getRequestDispatcher("/livres.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String categorie = request.getParameter("categorie");

        Livre livre = new Livre(titre, auteur, categorie, true);
        livreRepository.ajouterLivre(livre);

        response.sendRedirect("/livres");
    }
}
