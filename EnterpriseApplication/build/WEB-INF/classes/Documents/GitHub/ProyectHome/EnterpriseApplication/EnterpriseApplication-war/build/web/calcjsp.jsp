<%-- 
    Document   : calcjsp
    Created on : 14 mar 2026, 19:01:59
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <div class="card">
            <h2>Calculadora EJB</h2>
            <form action="calcservlet" method="post">
                <input type="number" name="t1" placeholder="Número 1" required>
                <input type="number" name="t2" placeholder="Número 2">
                <div class="buttons">
                    <button type="submit" name="operacion" value="suma"> Sumar</button>
                    <button type="submit" name="operacion" value="resta"> Restar</button>
                    <button type="submit" name="operacion" value="multiplicar"> Multiplicar</button>
                    <button type="submit" name="operacion" value="dividir"> Dividir</button>
                    <button type="submit" name="operacion" value="modulo"> Módulo</button>
                    <button type="submit" name="operacion" value="elevar" class="btn-elevar"> Elevar al cuadrado</button>
                </div>
            </form>

            <% if (request.getAttribute("error") != null) { %>
                <div class="error-box">
                    <p>${error}</p>
                </div>
            <% } %>

            <% if (request.getAttribute("resultado") != null) { %>
                <div class="resultado-box">
                    <p class="nombre-op">${nombreOp}</p>
                    <p class="resultado">${resultado}</p>
                </div>
            <% } %>
        </div>
    </body>
</html>