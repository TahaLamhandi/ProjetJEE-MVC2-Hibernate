<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Produits</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #e8f5e9;
            padding: 20px;
        }
        .container {
            max-width: 1000px;
            margin: 0 auto;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }
        h2 {
            color: #2e7d32;
        }
        .logout {
            color: #c62828;
            text-decoration: none;
            font-size: 14px;
        }
        .card {
            background: white;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: inline-block;
            width: 100px;
            color: #555;
            font-size: 14px;
        }
        input {
            padding: 10px;
            border: 2px solid #c8e6c9;
            border-radius: 6px;
            width: 250px;
        }
        input:focus {
            outline: none;
            border-color: #4caf50;
        }
        button, .btn {
            padding: 10px 20px;
            background: #4caf50;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
        }
        button:hover, .btn:hover {
            background: #43a047;
        }
        .btn-danger {
            background: #ef5350;
        }
        .btn-danger:hover {
            background: #e53935;
        }
        .btn-small {
            padding: 6px 12px;
            font-size: 12px;
        }
        .error {
            background: #ffebee;
            color: #c62828;
            padding: 12px;
            border-radius: 6px;
            margin-bottom: 15px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        th {
            background: #4caf50;
            color: white;
            padding: 12px;
            text-align: left;
        }
        td {
            padding: 12px;
            border-bottom: 1px solid #e0e0e0;
        }
        tr:hover {
            background: #f5f5f5;
        }
        .empty {
            text-align: center;
            color: #888;
            padding: 40px;
        }
        h3 {
            color: #2e7d32;
            margin-bottom: 15px;
            font-size: 16px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>Gestion des Produits</h2>
        <a href="controller?controller=logout" class="btn btn-small btn-danger">Déconnexion</a>
    </div>

    <c:if test="${sessionScope.currentUser.role eq 'ADMIN'}">
        <div class="card">
            <h3>${produitEdit != null ? 'Modifier' : 'Ajouter'} un produit</h3>

            <form action="controller?controller=${produitEdit != null ? 'update' : 'ajouter'}" method="post">
                <input type="hidden" name="id" value="${produitEdit.id}"/>

                <div class="form-group">
                    <label>Nom</label>
                    <input type="text" name="nomprod" value="${produitEdit.nom}" required/>
                </div>

                <div class="form-group">
                    <label>Description</label>
                    <input type="text" name="description" value="${produitEdit.description}" required/>
                </div>

                <div class="form-group">
                    <label>Prix</label>
                    <input type="number" step="0.01" name="prix" value="${produitEdit.prix}" required/>
                </div>

                <button type="submit">${produitEdit != null ? 'Modifier' : 'Ajouter'}</button>
                <c:if test="${produitEdit != null}">
                    <a href="controller?controller=list" class="btn" style="background: #757575;">Annuler</a>
                </c:if>
            </form>
        </div>
    </c:if>

    <div class="card">
        <h3>Rechercher par ID</h3>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <form action="controller?controller=list" method="get">
            <div class="form-group">
                <label>ID</label>
                <input type="number" name="id" placeholder="Numéro ID" required/>
                <button type="submit">Rechercher</button>
            </div>
        </form>
    </div>

    <div class="card">
        <h3>Liste des produits</h3>

        <c:if test="${not empty produits}">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Prix</th>
                    <c:if test="${sessionScope.currentUser.role eq 'ADMIN'}">
                        <th>Actions</th>
                    </c:if>
                </tr>

                <c:forEach var="p" items="${produits}">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.nom}</td>
                        <td>${p.description}</td>
                        <td>${p.prix} €</td>

                        <c:if test="${sessionScope.currentUser.role eq 'ADMIN'}">
                            <td>
                                <a href="controller?controller=modifier&id=${p.id}" class="btn btn-small">modifier️</a>
                                <a href="controller?controller=supprimer&id=${p.id}"
                                   class="btn btn-small btn-danger"
                                   onclick="return confirm('Supprimer ${p.nom} ?')">supprimer</a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <c:if test="${empty produits}">
            <div class="empty">Aucun produit à afficher</div>
        </c:if>
    </div>
</div>
</body>
</html>