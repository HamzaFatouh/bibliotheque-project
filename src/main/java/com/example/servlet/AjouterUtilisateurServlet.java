package com.example.servlet;

import com.example.model.Utilisateur;
import com.example.repository.UtilisateurRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajouterUtilisateur")
public class AjouterUtilisateurServlet extends HttpServlet {
    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        Utilisateur utilisateur = new Utilisateur(nom, email, role);
        utilisateurRepository.save(utilisateur);

        response.sendRedirect("index.jsp");
    }
}
