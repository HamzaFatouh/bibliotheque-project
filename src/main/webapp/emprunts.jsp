<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Emprunts</title>
</head>
<body>
<h1>Liste des Emprunts</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Livre</th>
        <th>Utilisateur</th>
        <th>Date d'Emprunt</th>
        <th>Date de Retour</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="emprunt" items="${emprunts}">
        <tr>
            <td>${emprunt.id}</td>
            <td>${emprunt.livre.titre}</td>
            <td>${emprunt.utilisateur.nom}</td>
            <td>${emprunt.dateEmprunt}</td>
            <td>${emprunt.dateRetour != null ? emprunt.dateRetour : "Non retourné"}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
