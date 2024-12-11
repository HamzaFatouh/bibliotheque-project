<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Ajouter un Utilisateur</title>
</head>
<body>
<h1>Ajouter un Utilisateur</h1>
<form action="ajouterUtilisateur" method="post">
  <label for="nom">Nom :</label>
  <input type="text" name="nom" id="nom" required><br>
  <label for="email">Email :</label>
  <input type="email" name="email" id="email" required><br>
  <label for="role">Rôle :</label>
  <select name="role" id="role">
    <option value="utilisateur">Utilisateur</option>
    <option value="admin">Admin</option>
  </select><br>
  <button type="submit">Ajouter</button>
</form>
</body>
</html>
