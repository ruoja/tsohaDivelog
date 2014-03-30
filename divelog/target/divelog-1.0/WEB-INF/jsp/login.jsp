<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">
        <link href="bootstrap-3.0.0/examples/signin/signin.css" rel="stylesheet">
        <title>Divelog</title>
    </head>

    <body>
        <h1 class="text-center">Divelog - Sukelluspäiväkirja</h1>

        <p class="text-center lead">Pidä kirjaa sukelluksistasi ja sukelluskohteistasi.</p>

        <div class="container">

            <form action="login" method="POST" class="form-signin" >
                <h2 class="form-signin-heading text-center">Kirjaudu sisään</h2>
                <input type="text" name="email" value="${email}" class="form-control" placeholder="sähköposti" autofocus>
                <input type="password" name="pswd" class="form-control" placeholder="salasana">
                <button type="submit" class="btn btn-lg btn-primary btn-block">Kirjaudu</button>
                <button type="submit" formaction="register" formmethod="GET"class="btn btn-lg btn-primary btn-block">Rekisteröidy</button>
            </form>
            
            <c:if test="${errorMessage != null}">
                <div class="alert alert-danger">${errorMessage}</div>
            </c:if>
            <c:if test="${goodbye != null}">
                <div class="alert alert-success">${goodbye}</div>
            </c:if>

        </div>
    </body>
</html>
