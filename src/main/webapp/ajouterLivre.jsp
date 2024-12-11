<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Livre</title>
</head>
<body>
<h1>Ajouter un Nouveau Livre</h1>
<form action="ajouterLivre" method="post">
    <label for="titre">Titre :</label>
    <input type="text" name="titre" id="titre" required><br>
    <label for="auteur">Auteur :</label>
    <input type="text" name="auteur" id="auteur" required><br>
    <label for="categorie">Catégorie :</label>
    <input type="text" name="categorie" id="categorie"><br>
    <label for="disponibilite">Disponible :</label>
    <input type="checkbox" name="disponibilite" id="disponibilite" value="true"><br>
    <button type="submit">Ajouter</button>
</form>
</body>
</html>
