<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Livres</title>
</head>
<body>
<h1>Liste des Livres</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Titre</th>
        <th>Auteur</th>
        <th>Catégorie</th>
        <th>Disponibilité</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="livre" items="${requestScope.livres}">
        <tr>
            <td>${livre.id}</td>
            <td>${livre.titre}</td>
            <td>${livre.auteur}</td>
            <td>${livre.categorie}</td>
            <td>${livre.disponibilite ? "Disponible" : "Non disponible"}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
